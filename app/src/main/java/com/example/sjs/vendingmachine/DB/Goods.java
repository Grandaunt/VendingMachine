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
    //商品编号 设备编号_商品编号 a1_01
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
    //商品状态 0为真1为假
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


    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGooodsInfo() {
        return gooodsInfo;
    }

    public void setGooodsInfo(String gooodsInfo) {
        this.gooodsInfo = gooodsInfo;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(String goodsCost) {
        this.goodsCost = goodsCost;
    }

    public String getGoodsTemperature() {
        return goodsTemperature;
    }

    public void setGoodsTemperature(String goodsTemperature) {
        this.goodsTemperature = goodsTemperature;
    }

    public String getGoodsLight() {
        return goodsLight;
    }

    public void setGoodsLight(String goodsLight) {
        this.goodsLight = goodsLight;
    }

    public String getGoodsLife() {
        return goodsLife;
    }

    public void setGoodsLife(String goodsLife) {
        this.goodsLife = goodsLife;
    }

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


    @Override
    public String toString() {
        return "Goods{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", gooodsInfo='" + gooodsInfo + '\'' +
                ", goodsImage='" + goodsImage + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsStatus='" + goodsStatus + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", goodsCost='" + goodsCost + '\'' +
                ", goodsTemperature='" + goodsTemperature + '\'' +
                ", goodsLight='" + goodsLight + '\'' +
                ", goodsLife='" + goodsLife + '\'' +
                '}';
    }
}
