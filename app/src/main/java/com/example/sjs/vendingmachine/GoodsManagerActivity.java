package com.example.sjs.vendingmachine;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sjs.vendingmachine.Adapter.GoodsManagerReAdapter;

import com.example.sjs.vendingmachine.Adapter.GoodsShowReAdapter;
import com.example.sjs.vendingmachine.DB.Goods;
import com.example.sjs.vendingmachine.DB.GoodsRepo;
import com.example.sjs.vendingmachine.Http.GoodsBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoodsManagerActivity extends AppCompatActivity {
    private String URL="http://123.57.29.113:8080/sell/appInterface/getGoods.do";
    private static  String TAG = "GoodsManagerActivity";
    private RecyclerView Goos_RecyclerView;
    //    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<GoodsBean> GoodsBeanList;
    private ArrayList<HashMap<String, String>> showGoodsManagerList;
    private List<String> mDatas;
    private GoodsManagerReAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_manager);
        x.view().inject(this);
//        context=this;
        initData();

    }
    private void initData()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.goods_manager_toolbar);
        toolbar.setTitle("商品管理");//设置主标题
        toolbar.setTitleTextColor(Color.rgb(0, 0, 0));
//        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back_black_64dp);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new Toolbar.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        showGoodsManagerList = new  ArrayList<HashMap<String, String>>();
        GoodsRepo repo = new GoodsRepo(this);
        showGoodsManagerList = repo.showGoodsManagerList();

        //开始设置RecyclerView
        Goos_RecyclerView=(RecyclerView)findViewById(R.id.recyclerview_goods_manager);
        //设置固定大小
        Goos_RecyclerView.setHasFixedSize(true);
        //创建线性布局
        mLayoutManager = new LinearLayoutManager(this);
        //垂直方向
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //给RecyclerView设置布局管理器
//        recyclerView_one.setLayoutManager(mLayoutManager);
        Goos_RecyclerView.setLayoutManager(new GridLayoutManager(this,4));
//        recyclerView_one.setLayoutManager(new StaggeredGridLayoutManager(4,
//                StaggeredGridLayoutManager.VERTICAL));
        //创建适配器，并且设置
        mAdapter = new GoodsManagerReAdapter(this,showGoodsManagerList);
//        Goos_RecyclerView.setAdapter(mAdapter);
        Goos_RecyclerView.setAdapter(mAdapter = new GoodsManagerReAdapter(this,showGoodsManagerList));
        mAdapter.setOnItemClickLitener(new GoodsManagerReAdapter.OnItemClickLitener()
        {

            @Override
            public void onItemClick(View view, int position, String numm) {
                Intent intent = new Intent(GoodsManagerActivity.this,GoodsEditActivity.class);
//                intent.putExtra("MainActivity", "message");
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position, String numm) {
                Intent intent = new Intent(GoodsManagerActivity.this,GoodsEditActivity.class);
//                intent.putExtra("MainActivity", "message");
                startActivity(intent);
            }


        });

        RequestParams params = new RequestParams(URL);
        //根据当前请求方式添加参数位置
        params.addParameter("userAccount", "11000");
        Log.i(TAG,"params="+params);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, "result:" + result);

                if(result.equals("01")||result == "01")
                {
                    Toast.makeText(GoodsManagerActivity.this,"无数据",Toast.LENGTH_LONG).show();

                }
                else {
                    Gson gson = new Gson();
                    GoodsBeanList = gson.fromJson(result, new TypeToken<List<GoodsBean>>() {
                    }.getType());

//                    CIFPersInfBean cifPerBean = gson.fromJson(result, CIFPersInfBean.class);
                    if (GoodsBeanList.size() > 0) {
                        for (int i = 0; i < GoodsBeanList.size(); i++) {
                            GoodsBean cifPerBean = GoodsBeanList.get(i);
                            Goods goods = new Goods();
                            goods.goodsId = cifPerBean.getGOODS_ID();
                            goods.goodsNum = cifPerBean.getGOODSNUM();
                            goods.goodsName = cifPerBean.getGOODSNAME();
                            goods.goodsPrice = cifPerBean.getGOODSPRICE();
                            goods.gooodsInfo = cifPerBean.getGOODSINFO();

                            goods.goodsImage = cifPerBean.getGOODSIMAGE();
                            goods.goodsType = cifPerBean.getGOODSTYPE();
                            goods.goodsStatus = cifPerBean.getGOODSSTATUS();
                            goods.goodsNumber = cifPerBean.getGOODSNUMBER();
                            goods.goodsCost = cifPerBean.getGOODSCOST();

                            goods.goodsTemperature = cifPerBean.getGOODSTEMPERATURE();
                            goods.goodsLight = cifPerBean.getGOODSLIGHT();
                            goods.goodsLife = cifPerBean.getGOODSLIFE();

                            GoodsRepo repo = new GoodsRepo(GoodsManagerActivity.this);
                            Log.i(TAG, "Goods表:cifPerBean.getGoodsId()" + cifPerBean.getGOODSNUM());
                            if (repo.getGoodsNum(cifPerBean.getGOODSNUM())) {
                                repo.update(goods);
                                Log.i(TAG, "goods表更新:" + cifPerBean.getGOODSNAME());
                                Log.i(TAG, "goods表更新:" + cifPerBean.getGOODSNAME());
                            } else {
                                repo.insert(goods);
                                Log.i(TAG, "goods表插入:" + cifPerBean.getGOODSNAME());
                            }


                        }
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.i(TAG,"onError="+ex);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.i(TAG,"onCancelled="+cex);
            }

            @Override
            public void onFinished() {

                showGoodsManagerList = new  ArrayList<HashMap<String, String>> ();
                GoodsRepo repo = new GoodsRepo(GoodsManagerActivity.this);

                showGoodsManagerList = repo.showGoodsList();
                Log.i(TAG,"showGoodsList.size="+showGoodsManagerList);
                //创建适配器，并且设置
                mAdapter = new GoodsManagerReAdapter(GoodsManagerActivity.this,showGoodsManagerList);
                Goos_RecyclerView.setAdapter(mAdapter);
                Log.i(TAG,"onFinished");
            }

            @Override
            public boolean onCache(String result) {
                Log.i(TAG,"onCache"+result);
                return false;
            }
        });


    }


}
