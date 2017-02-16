package com.example.sjs.vendingmachine;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ReplenishActivity extends AppCompatActivity implements View.OnClickListener{

    private Button goodsManager,aislemanager,machinemanager,doormanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replenish);
        goodsManager = (Button) findViewById(R.id.btn_goods_manager);
        aislemanager = (Button) findViewById(R.id.btn_aisle_manager);
        machinemanager = (Button) findViewById(R.id.btn_machine_manager);
        doormanager = (Button) findViewById(R.id.btn_door_manager);
        goodsManager.setOnClickListener(this);
        aislemanager.setOnClickListener(this);
        machinemanager.setOnClickListener(this);
        doormanager.setOnClickListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.rep_toolbar);
        toolbar.setTitle("系统管理维护");//设置主标题
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_goods_manager:
                Intent intent1 = new Intent(this,GoodsManagerActivity.class);
//                intent.putExtra("MainActivity", "message");
                startActivity(intent1);
                break;
            case R.id.btn_aisle_manager:
                Intent intent2 = new Intent(this,AisleManagerActivity.class);
//                intent.putExtra("MainActivity", "message");
                startActivity(intent2);
                break;
            case R.id.btn_machine_manager:
                Intent intent3 = new Intent(this,MachineManagerActivity.class);
//                intent.putExtra("MainActivity", "message");
                startActivity(intent3);
                break;
            case R.id.btn_door_manager:
                Intent intent4 = new Intent(this,DoorManagerActivity.class);
//                intent.putExtra("MainActivity", "message");
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}
