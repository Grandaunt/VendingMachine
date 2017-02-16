package com.example.sjs.vendingmachine.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SJS on 2017/2/8.
 */

public class GoodsRepo {

    private  final static  String  TAG="GoodsRepo";
    private DBHelper dbHelper;

    public GoodsRepo(Context context){
        dbHelper =new DBHelper(context);
    }

    public int insert(Goods goods){
        //打开连接，写入数据
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
//        values.put(Goods.GoodsId,goods.goodsId);
        values.put(Goods.GoodsNum,goods.goodsNum);
        values.put(Goods.GoodsName,goods.goodsName);
        values.put(Goods.GoodsPrice,goods.goodsPrice);
        values.put(Goods.GooodsInfo,goods.gooodsInfo);

        values.put(Goods.GoodsImage,goods.goodsImage);
        values.put(Goods.GoodsType,goods.goodsType);
        values.put(Goods.GoodsStatus,goods.goodsStatus);
        values.put(Goods.GoodsNumber,goods.goodsNumber);
        values.put(Goods.GoodsCost,goods.goodsCost);

        values.put(Goods.GoodsTemperature,goods.GoodsTemperature);
        values.put(Goods.GoodsLight,goods.goodsLight);
        values.put(Goods.GoodsLife,goods.goodsLife);


        long goods_Id=db.insert(Goods.TABLE,null,values);
        db.close();
        Log.i(TAG,"goods_Id="+goods_Id);
        return (int)goods_Id;
    }


    public void delete(int goods_Id){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        db.delete(Goods.TABLE,Goods.GoodsId+"=?", new String[]{String.valueOf(goods_Id)});
        db.close();
    }
    public void update(Goods goods){
        Log.i(TAG,"update………………………………………………………………");
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();

//        values.put(Goods.GoodsId,goods.goodsId);
        values.put(Goods.GoodsNum,goods.goodsNum);
        values.put(Goods.GoodsName,goods.goodsName);
        values.put(Goods.GoodsPrice,goods.goodsPrice);
        values.put(Goods.GooodsInfo,goods.gooodsInfo);

        values.put(Goods.GoodsImage,goods.goodsImage);
        values.put(Goods.GoodsType,goods.goodsType);
        values.put(Goods.GoodsStatus,goods.goodsStatus);
        values.put(Goods.GoodsNumber,goods.goodsNumber);
        values.put(Goods.GoodsCost,goods.goodsCost);

        values.put(Goods.GoodsTemperature,goods.goodsTemperature);
        values.put(Goods.GoodsLight,goods.goodsLight);
        values.put(Goods.GoodsLife,goods.goodsLife);
       Log.i(TAG,"Goods.GoodsNum="+Goods.GoodsNum+"goods.goodsNum="+goods.goodsNum);
        db.update(Goods.TABLE,values,Goods.GoodsNum+"=?",new String[] { String.valueOf(goods.goodsNum) });
        db.close();
        Goods ref =SelectGoods(goods.goodsNum);
        Log.i(TAG,"Goods.ref.goodsImage="+ref.goodsImage);


    }

    //查询该num编号的商品信息
    public  Goods SelectGoods(String num){
        SQLiteDatabase db= dbHelper.getReadableDatabase();


        String selectQuery="SELECT "
                +Goods.GoodsId+","
                +Goods.GoodsNum+","
                +Goods.GoodsName+","
                +Goods.GoodsPrice+","
                +Goods.GooodsInfo+","

                +Goods.GoodsImage+","
                +Goods.GoodsType+","
                +Goods.GoodsStatus+","
                +Goods.GoodsNumber+","
                +Goods.GoodsCost+","

                +Goods.GoodsTemperature+","
                +Goods.GoodsLight+","
                +Goods.GoodsLife+
                " FROM "+Goods.TABLE
                + " WHERE " +
                Goods.GoodsNum + "=?";
        int iCount=0;
        Goods goods=new Goods();


        Cursor cursor=db.rawQuery(selectQuery,new String[]{String.valueOf(num)});
        if(cursor.moveToFirst()){
            do{

                goods.goodsId = cursor.getString(cursor.getColumnIndex(Goods.GoodsId));
                goods.goodsNum = cursor.getString(cursor.getColumnIndex(Goods.GoodsNum));
                goods.goodsName = cursor.getString(cursor.getColumnIndex(Goods.GoodsName));
                goods.goodsPrice = cursor.getString(cursor.getColumnIndex(Goods.GoodsPrice));
                goods.gooodsInfo = cursor.getString(cursor.getColumnIndex(Goods.GooodsInfo));

                goods.goodsImage = cursor.getString(cursor.getColumnIndex(Goods.GoodsImage));
                goods.goodsType = cursor.getString(cursor.getColumnIndex(Goods.GoodsType));
                goods.goodsStatus = cursor.getString(cursor.getColumnIndex(Goods.GoodsStatus));
                goods.goodsNumber = cursor.getString(cursor.getColumnIndex(Goods.GoodsNumber));
                goods.goodsCost = cursor.getString(cursor.getColumnIndex(Goods.GoodsCost));

                goods.goodsTemperature = cursor.getString(cursor.getColumnIndex(Goods.GoodsTemperature));
                goods.goodsLight = cursor.getString(cursor.getColumnIndex(Goods.GoodsLight));
                goods.goodsLife = cursor.getString(cursor.getColumnIndex(Goods.GoodsLife));


            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return goods;
    }


    //查询goods表id
    public boolean getGoodsNum(String goodsNum){
        boolean rel = false;

        SQLiteDatabase db= dbHelper.getReadableDatabase();
        String selectQuery="SELECT "+
                Goods.GoodsId+

                " FROM "+Goods.TABLE +
                "  WHERE " + Goods.GoodsNum + " = '" + goodsNum + "'"+" LIMIT 1";


        System.out.println(selectQuery);
        ArrayList<HashMap<String,String>> personalList=new ArrayList<HashMap<String, String>>();
        Cursor cursor=db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            rel=true;

        }
        Log.i(TAG,"查询结果：rel="+rel);
        cursor.close();
        db.close();
        return rel;
    }
    //查询可显示goods表
    public ArrayList<HashMap<String, String>> showGoodsList(){
        boolean rel = false;

        SQLiteDatabase db= dbHelper.getReadableDatabase();
        String selectQuery="SELECT "
                +Goods.GoodsId+","
                +Goods.GoodsNum+","
                +Goods.GoodsName+","
                +Goods.GoodsPrice+","
                +Goods.GooodsInfo+","

                +Goods.GoodsImage+","
                +Goods.GoodsType+","
                +Goods.GoodsStatus+","
                +Goods.GoodsNumber+","
                +Goods.GoodsCost+","

                +Goods.GoodsTemperature+","
                +Goods.GoodsLight+","
                +Goods.GoodsLife+
                " FROM "+Goods.TABLE +
                "  WHERE " + Goods.GoodsStatus + " = '" + 0 + "'";


       Log.i(TAG,selectQuery);
        ArrayList<HashMap<String,String>> showGoodsList=new ArrayList<HashMap<String, String>>();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                HashMap<String,String> goods=new HashMap<String,String>();
                goods.put("goodsId",cursor.getString(cursor.getColumnIndex(Goods.GoodsId)));
                goods.put("goodsNum", cursor.getString(cursor.getColumnIndex(Goods.GoodsNum)));
                goods.put("goodsName", cursor.getString(cursor.getColumnIndex(Goods.GoodsName)));
                goods.put("goodsPrice", cursor.getString(cursor.getColumnIndex(Goods.GoodsPrice)));
                goods.put("gooodsInfo", cursor.getString(cursor.getColumnIndex(Goods.GooodsInfo)));

                goods.put("goodsImage", cursor.getString(cursor.getColumnIndex(Goods.GoodsImage)));
                goods.put("goodsType", cursor.getString(cursor.getColumnIndex(Goods.GoodsType)));
                goods.put("goodsStatus", cursor.getString(cursor.getColumnIndex(Goods.GoodsStatus)));
                goods.put("goodsNumber",  cursor.getString(cursor.getColumnIndex(Goods.GoodsNumber)));
                goods.put("goodsCost", cursor.getString(cursor.getColumnIndex(Goods.GoodsCost)));

                goods.put("goodsTemperature", cursor.getString(cursor.getColumnIndex(Goods.GoodsTemperature)));
                goods.put("goodsLight",  cursor.getString(cursor.getColumnIndex(Goods.GoodsLight)));
                goods.put("goodsLife", cursor.getString(cursor.getColumnIndex(Goods.GoodsLife)));

                showGoodsList.add(goods);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return showGoodsList;

    }
    //查询可管理的goods表
    public ArrayList<HashMap<String, String>> showGoodsManagerList(){
        boolean rel = false;

        SQLiteDatabase db= dbHelper.getReadableDatabase();
        String selectQuery="SELECT "
                +Goods.GoodsId+","
                +Goods.GoodsNum+","
                +Goods.GoodsName+","
                +Goods.GoodsPrice+","
                +Goods.GooodsInfo+","

                +Goods.GoodsImage+","
                +Goods.GoodsType+","
                +Goods.GoodsStatus+","
                +Goods.GoodsNumber+","
                +Goods.GoodsCost+","

                +Goods.GoodsTemperature+","
                +Goods.GoodsLight+","
                +Goods.GoodsLife+
                " FROM "+Goods.TABLE ;


        Log.i(TAG,selectQuery);
        ArrayList<HashMap<String,String>> showGoodsList=new ArrayList<HashMap<String, String>>();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                HashMap<String,String> goods=new HashMap<String,String>();
                goods.put("goodsId",cursor.getString(cursor.getColumnIndex(Goods.GoodsId)));
                goods.put("goodsNum", cursor.getString(cursor.getColumnIndex(Goods.GoodsNum)));
                goods.put("goodsName", cursor.getString(cursor.getColumnIndex(Goods.GoodsName)));
                goods.put("goodsPrice", cursor.getString(cursor.getColumnIndex(Goods.GoodsPrice)));
                goods.put("gooodsInfo", cursor.getString(cursor.getColumnIndex(Goods.GooodsInfo)));

                goods.put("goodsImage", cursor.getString(cursor.getColumnIndex(Goods.GoodsImage)));
                goods.put("goodsType", cursor.getString(cursor.getColumnIndex(Goods.GoodsType)));
                goods.put("goodsStatus", cursor.getString(cursor.getColumnIndex(Goods.GoodsStatus)));
                goods.put("goodsNumber",  cursor.getString(cursor.getColumnIndex(Goods.GoodsNumber)));
                goods.put("goodsCost", cursor.getString(cursor.getColumnIndex(Goods.GoodsCost)));

                goods.put("goodsTemperature", cursor.getString(cursor.getColumnIndex(Goods.GoodsTemperature)));
                goods.put("goodsLight",  cursor.getString(cursor.getColumnIndex(Goods.GoodsLight)));
                goods.put("goodsLife", cursor.getString(cursor.getColumnIndex(Goods.GoodsLife)));

                showGoodsList.add(goods);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return showGoodsList;

    }


}
