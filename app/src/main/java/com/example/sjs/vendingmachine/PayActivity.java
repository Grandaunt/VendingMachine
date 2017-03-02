package com.example.sjs.vendingmachine;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
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

import org.xutils.image.ImageOptions;
import org.xutils.x;

public class PayActivity extends AppCompatActivity implements View.OnClickListener{
    public static String TAG="PayActivity";

    private LinearLayout ly_back,ly_zfb,ly_wx,ly_yl;
    private  String goodsNum;
    private TextView tvGoodsName,tvGoodsPrice,tvCountDownTimer;
    private ImageView imGoods,imGoodsEwm,imzflc,imwxzf,imzfbzf,imylzf;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        //获取上一级目录传递数据
        Intent i = getIntent();
        goodsNum = i.getStringExtra("goodsNum");
        GoodsRepo repo = new GoodsRepo(this);
        Goods goods=repo.SelectGoods(goodsNum);


        tvGoodsName = (TextView)findViewById(R.id.tv_goods_pay_name);
        tvGoodsPrice = (TextView)findViewById(R.id.tv_goods_pay_price);
        tvCountDownTimer = (TextView)findViewById(R.id.tv_CountDownTimer);
        imGoods = (ImageView) findViewById(R.id.im_goods_pay);
        imzflc = (ImageView) findViewById(R.id.im_goods_zflc);
        imGoodsEwm = (ImageView) findViewById(R.id.im_goods_erweima);
        imwxzf = (ImageView) findViewById(R.id.image_wxpay);
        imzfbzf = (ImageView) findViewById(R.id.image_zfbpay);
        imylzf = (ImageView) findViewById(R.id.image_ylpay);
        Log.i(TAG,"goods.getGoodsName()="+goods.getGoodsName());
        tvGoodsPrice = (TextView)findViewById(R.id.tv_goods_pay_price);


        //注入数据
        tvGoodsName.setText(goods.getGoodsName());
        tvGoodsPrice.setText(goods.getGoodsPrice());
        imzflc.setImageResource(R.mipmap.zfb_zflc);
        imGoodsEwm.setImageResource(R.mipmap.zfb_ewm);
        ImageOptions options = new ImageOptions.Builder()
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.testimage)
                //设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.testimage)
                //设置圆形
                .setCircular(false)
                //某些手机拍照时图片自动旋转，设置图片是否自动旋转为正
                .setAutoRotate(true)
                //等比例缩放居中显示
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .build();
//        x.image().bind(imageView, iconUrl,imageOptions);
        x.image().bind(imGoods, "http://123.57.29.113:8080/sell/static/uploadFiles/uploadImgs/"+goods.getGoodsImage(), options);

        ly_back = (LinearLayout)findViewById(R.id.ly_pay_back);
        ly_zfb = (LinearLayout)findViewById(R.id.ly_zhbpay);
        ly_wx = (LinearLayout) findViewById(R.id.ly_wxpay);
        ly_yl = (LinearLayout) findViewById(R.id.ly_ylpay);

        ly_yl.setOnClickListener(this);
        ly_wx.setOnClickListener(this);
        ly_zfb.setOnClickListener(this);
        ly_back.setOnClickListener(this);

        //倒计时
         timer = new CountDownTimer(50000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvCountDownTimer.setText(""+millisUntilFinished / 1000);
            }
            public void onFinish() {
                tvCountDownTimer.setText("超时！");
                finish();
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ly_zhbpay:

                imGoodsEwm.setImageResource(R.mipmap.zfb_ewm);
                imzflc.setImageResource(R.mipmap.zfb_zflc);
                //底部导航
                imwxzf.setImageResource(R.mipmap.ic_wxpay_bg);
                imzfbzf.setImageResource(R.mipmap.ic_zfbpay_128dp);
                imylzf.setImageResource(R.mipmap.ic_ylpay_bg);
                break;

            case R.id.ly_wxpay:
                imGoodsEwm.setImageResource(R.mipmap.wx_ewm);
                imzflc.setImageResource(R.mipmap.wx_zflc);
                //底部导航
                imwxzf.setImageResource(R.mipmap.ic_wxpay_128dp);
                imzfbzf.setImageResource(R.mipmap.ic_zfbpay_bg);
                 imylzf.setImageResource(R.mipmap.ic_ylpay_bg);
                break;
            case R.id.ly_ylpay:
                //                imGoodsEwm.setImageResource(R.mipmap.yl_ewm);
//                imzflc.setImageResource(R.mipmap.yl_zflc);
                //底部导航
                imwxzf.setImageResource(R.mipmap.ic_wxpay_bg);
                imzfbzf.setImageResource(R.mipmap.ic_zfbpay_bg);
                imylzf.setImageResource(R.mipmap.ic_ylpay_128dp);
                break;

            case R.id.ly_pay_back:
                timer.cancel();
                finish();
                break;
            default:
                break;

        }
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"<<<<onStop>>>");
        super.onStop();
    }

    @Override
    protected void onStart() {
        Log.i(TAG,"<<<<onStart>>>");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"<<<<onDestroy>>>");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"<<<<onPause>>>");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"<<<<onResume>>>");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG,"<<<<onRestart>>>");
        super.onRestart();
    }
}
