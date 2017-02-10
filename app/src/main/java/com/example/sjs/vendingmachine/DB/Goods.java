package com.example.sjs.vendingmachine.DB;

/**
 * Created by SJS on 2017/2/8.
 */

public class Goods {
    //表名
    public static final String TABLE="TB_Goods";

    //表的各域名

    //记录主键
    //商品id
    public static final  String  GoodsId="goodsId";
    //商品编号
    public static final  String  GoodsNum="goodsNum";
    //商品名称
    public static final  String  GoodsName="goodsName";
    //商品价格 double
    public static final  String  GoodsPrice="goodsPrice";
    //商品信息
    public static final  String  GooodsInfo="goodsInfo";
    //商品图片
    public static final  String  GoodsImage="goodsImage";
    //商品类别
    public static final  String  GoodsType="goodsType";
    //商品状态 0为假1为真
    public static final  String  GoodsStatus="goodsStatus";
    //商品数量
    public static final  String  GoodsNumber="goodsNumber";
    //商品成本
    public static final  String  GoodsCost="goodsCost";
    //商品所需温度
    public static final  String  GoodsTemperature="goodsTemperature";
    //商品所需光照
    public static final  String  GoodsLight="goodsLight";
    //商品保质期
    public static final  String  GoodsLife="goodsLife";



    //属性

    //商品id
    public  String  goodsId;
    //商品编号
    public String goodsNum;
    //商品名称
    public  String  goodsName;
    //商品价格
    public  String  goodsPrice;
    //商品信息
    public  String  gooodsInfo;
    //商品图片
    public  String  goodsImage;
    //商品类别
    public  String  goodsType;
    //商品状态
    public  String  goodsStatus;
    //商品数量
    public  String  goodsNumber;
    //商品成本
    public  String  goodsCost;
    //商品所需温度
    public  String  goodsTemperature;
    //商品所需光照
    public  String  goodsLight ;
    //商品保质期
    public  String  goodsLife;





}
