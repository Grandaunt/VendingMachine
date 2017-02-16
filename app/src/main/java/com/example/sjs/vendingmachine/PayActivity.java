package com.example.sjs.vendingmachine;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sjs.vendingmachine.DB.Goods;
import com.example.sjs.vendingmachine.DB.GoodsRepo;

public class PayActivity extends AppCompatActivity implements View.OnClickListener{
    public static String TAG="PayActivity";

    private LinearLayout ly_back,ly_zfb,ly_wx,ly_yl;
    private  String goodsNum;
    private TextView tvGoodsName,tvGoodsPrice;
    private ImageView imGoods,imGoodsEwm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        //获取上一级目录传递数据eventid
        Intent i = getIntent();
        goodsNum = i.getStringExtra("goodsNum");
        Log.i(TAG,"PayActivity已向应");
        GoodsRepo repo = new GoodsRepo(this);
        Goods goods=repo.SelectGoods(goodsNum);

        tvGoodsName = (TextView)findViewById(R.id.tv_goods_pay_name);
        tvGoodsPrice = (TextView)findViewById(R.id.tv_goods_pay_price);
        imGoods = (ImageView) findViewById(R.id.im_goods_pay);
        imGoodsEwm = (ImageView) findViewById(R.id.im_goods_erweima);
        tvGoodsName.setText(goods.getGoodsName());
        tvGoodsPrice = (TextView)findViewById(R.id.tv_goods_pay_price);
        imGoods = (ImageView) findViewById(R.id.im_goods_pay);
        imGoodsEwm = (ImageView) findViewById(R.id.im_goods_erweima);

        ly_back = (LinearLayout)findViewById(R.id.ly_pay_back);
        ly_zfb = (LinearLayout)findViewById(R.id.ly_zhbpay);
        ly_wx = (LinearLayout) findViewById(R.id.ly_wxpay);
        ly_yl = (LinearLayout) findViewById(R.id.ly_ylpay);

        ly_yl.setOnClickListener(this);
        ly_wx.setOnClickListener(this);
        ly_zfb.setOnClickListener(this);
        ly_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ly_wxpay:

                break;
            case R.id.ly_zhbpay:

                break;
            case R.id.ly_ylpay:

                break;
            case R.id.ly_pay_back:

                    finish();
                break;
            default:
                break;

        }
    }
}
