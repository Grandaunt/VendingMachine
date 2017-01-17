package com.example.sjs.vendingmachine.Application;

import android.app.Application;

import com.example.sjs.vendingmachine.SerialUtil.SerialPort;
import com.example.sjs.vendingmachine.SerialUtil.SerialPortFinder;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;


/**
 * Created by kqw on 2016/10/26.
 * MyApplication
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    public SerialPortFinder mSerialPortFinder = new SerialPortFinder();
    private SerialPort mSerialPort = null;

    public SerialPort getSerialPort() throws SecurityException, IOException, InvalidParameterException {
        if (mSerialPort == null) {
            mSerialPort = new SerialPort(new File("/dev/ttyUSB0"),9600 , 0);
        }
        return mSerialPort;
    }

    public void closeSerialPort() {
        if (mSerialPort != null) {
            mSerialPort.close();
            mSerialPort = null;
        }
    }
}
