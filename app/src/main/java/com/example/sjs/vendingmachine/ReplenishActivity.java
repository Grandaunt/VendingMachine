package com.example.sjs.vendingmachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
