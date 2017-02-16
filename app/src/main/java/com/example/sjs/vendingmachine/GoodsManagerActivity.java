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
import android.view.View;

import com.example.sjs.vendingmachine.Adapter.GoodsManagerReAdapter;

import com.example.sjs.vendingmachine.DB.GoodsRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoodsManagerActivity extends AppCompatActivity {
    private static  String TAG = "GoodsManagerActivity";
    private RecyclerView Goos_RecyclerView;
    //    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<HashMap<String, String>> showGoodsManagerList;
    private List<String> mDatas;
    private GoodsManagerReAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_mmanager);
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

            }


        });

    }


}
