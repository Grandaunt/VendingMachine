package com.example.sjs.vendingmachine;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Switch;


public class MachineManagerActivity extends AppCompatActivity implements View.OnClickListener{

    private Switch xjsbCheckButton,zfbsbCheckButton,zfbewmCheckButton,ylsbCheckButton,wxsbCheckButton, sfzsbCheckButton,dyjsbCheckButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_manager);
        initView();
    }
    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.machine_manager_toolbar);
        toolbar.setTitle("设备参数");//设置主标题
        toolbar.setTitleTextColor(Color.rgb(0, 0, 0));
//        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back_black_64dp);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new Toolbar.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        xjsbCheckButton =(Switch) findViewById(R.id.xjsbChekButton);
        zfbsbCheckButton=(Switch) findViewById(R.id.zfbsbCheckButton);
        zfbewmCheckButton=(Switch) findViewById(R.id.zfbewmCheckButton);
        ylsbCheckButton=(Switch) findViewById(R.id.ylsbCheckButton);
        wxsbCheckButton=(Switch) findViewById(R.id.wxsbCheckButton);
        sfzsbCheckButton=(Switch) findViewById(R.id.sfzsbCheckButton);
        dyjsbCheckButton=(Switch) findViewById(R.id.dyjCheckButton);

        xjsbCheckButton.setOnClickListener(this);
        zfbsbCheckButton.setOnClickListener(this);
        zfbewmCheckButton.setOnClickListener(this);
        ylsbCheckButton.setOnClickListener(this);
        wxsbCheckButton.setOnClickListener(this);
        sfzsbCheckButton.setOnClickListener(this);
        dyjsbCheckButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xjsbChekButton:
                break;
            case R.id.zfbsbCheckButton:
                break;
            case R.id.zfbewmCheckButton:
                break;
            case R.id.wxsbCheckButton:
                break;
            case R.id.ylsbCheckButton:
                break;
            case R.id.sfzsbCheckButton:
                break;
            case R.id.dyjCheckButton:
                break;
            default:
                break;
        }
    }
}
