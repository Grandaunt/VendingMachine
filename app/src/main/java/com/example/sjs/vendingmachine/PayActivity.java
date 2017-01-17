package com.example.sjs.vendingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class PayActivity extends AppCompatActivity implements View.OnClickListener{
    public static String TAG="PayActivity";

    private LinearLayout ly_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Log.i(TAG,"PayActivity已向应");
        ly_back = (LinearLayout)findViewById(R.id.ly_pay_back);
        ly_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ly_wxpay:

                break;
            case R.id.ly_pay_back:

                    finish();
                break;
            default:
                break;

        }
    }
}
