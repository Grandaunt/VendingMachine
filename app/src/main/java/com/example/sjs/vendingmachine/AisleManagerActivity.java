package com.example.sjs.vendingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AisleManagerActivity extends AppCompatActivity {
private Button openAllDoor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aisle_manager);
        openAllDoor = (Button) findViewById(R.id.btn_open_alldoor);
        openAllDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
