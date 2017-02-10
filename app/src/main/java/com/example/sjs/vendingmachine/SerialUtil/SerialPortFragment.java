package com.example.sjs.vendingmachine.SerialUtil;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sjs.vendingmachine.Application.MyApplication;
import com.example.sjs.vendingmachine.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;


public abstract class SerialPortFragment extends Fragment {

    protected MyApplication mApplication;
    protected SerialPort mSerialPort;
    protected OutputStream mOutputStream;
    private InputStream mInputStream;
    private ReadThread mReadThread;

    HandlerThread sendingHandlerThread = new HandlerThread("sendingHandlerThread");

    {
        sendingHandlerThread.start();
    }

    protected Handler sendingHandler = new Handler(sendingHandlerThread.getLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (mOutputStream != null) {
                try {
                    mOutputStream.write((byte[]) msg.obj);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private class ReadThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
                int size;
                try {
                    byte[] buffer = new byte[64];
                    if (mInputStream == null) return;
                    size = mInputStream.read(buffer);
                    if (size > 0) {
                        onDataReceived(buffer, size);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void DisplayError(String resourceId) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("Error");
//        b.setMessage(resourceId);
//        b.setPositiveButton("OK", new OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                SerialPortActivity.this.finish();
//            }
//        });
//        b.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (MyApplication) getActivity().getApplication();
        try {
            mSerialPort = mApplication.getSerialPort();
            mOutputStream = mSerialPort.getOutputStream();
            mInputStream = mSerialPort.getInputStream();

			/* Create a receiving thread */
            mReadThread = new ReadThread();
            mReadThread.start();
        } catch (SecurityException e) {
            // You do not have read/write permission to the serial port.
            DisplayError("You do not have read/write permission to the serial port.");
        } catch (IOException e) {
            // The serial port can not be opened for an unknown reason.
            DisplayError("The serial port can not be opened for an unknown reason.");
        } catch (InvalidParameterException e) {
            // Please configure your serial port first.
            DisplayError("Please configure your serial port first.");
        }
    }

    protected abstract void onDataReceived(final byte[] buffer, final int size);

    @Override
    public void onDestroy() {
        if (mReadThread != null)
            mReadThread.interrupt();
        mApplication.closeSerialPort();
        mSerialPort = null;
        if (null != sendingHandlerThread) {
            sendingHandlerThread.quit();
        }
        super.onDestroy();
    }
}
