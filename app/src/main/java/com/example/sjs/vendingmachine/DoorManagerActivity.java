package com.example.sjs.vendingmachine;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DoorManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door_manager);
        initView();
    }

    private void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.door_manager_toolbar);
        toolbar.setTitle("格子柜操作");//设置主标题
        toolbar.setTitleTextColor(Color.rgb(0, 0, 0));
//        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back_black_64dp);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new Toolbar.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
