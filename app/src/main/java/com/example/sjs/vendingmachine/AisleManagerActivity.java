package com.example.sjs.vendingmachine;

import android.graphics.Color;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sjs.vendingmachine.Manager.openDoorManager;
import com.example.sjs.vendingmachine.SerialUtil.SerialPortActivity;

public class AisleManagerActivity extends SerialPortActivity {
    private static  String TAG="AisleManagerActivity";
    private Button openAllDoor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aisle_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.aisle_toolbar);
        toolbar.setTitle("货道管理");//设置主标题
        toolbar.setTitleTextColor(Color.rgb(0, 0, 0));
//        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back_black_64dp);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new Toolbar.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        openAllDoor = (Button) findViewById(R.id.btn_open_alldoor);
        openAllDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0 ; i<32;i++){
                    send(i);
                }
            }
        });
    }

    @Override
    protected void onDataReceived(byte[] buffer, int size) {

    }

    public void send(int open_num) {

//        String text = mEditTextEmission.getText().toString();
//        if (TextUtils.isEmpty(open_num)) {
//            return;
//        }
        Log.i(TAG,open_num+"send已发送open_num");
        byte [] HxStr = openDoorManager.hex2byte(openDoorManager.open_numarr[open_num]);

        Log.i(TAG,"<<<<<<<<openDoorManager.open_numarr[open_num]>>>>>>>>"+openDoorManager.open_numarr[open_num]);
        Log.i(TAG,"<<<<<<<<openDoorManager.hex2byte(openDoorManager.open_numarr[open_num])>>>>>>>>"+openDoorManager.hex2byte(openDoorManager.open_numarr[open_num]));
        Message message = Message.obtain();
//        message.obj = open_num.getBytes();
        message.obj =  HxStr;
        Log.i(TAG,HxStr+"send已发送");
        sendingHandler.sendMessage(message);


    }
}
