package com.example.sjs.vendingmachine.Http;

/**
 * Created by SJS on 2017/2/8.
 */

public class GoodsBean {
    //商品id
    private  String  GOODS_ID;
    //商品编号
    private String GOODSNUM;
    //商品名称
    private  String  GOODSNAME;
    //商品价格
    private  String  GOODSPRICE;
    //商品信息
    private  String  GOODSINFO;
    //商品图片
    private  String  GOODSIMAGE;
    //商品类别
    private  String  GOODSTYPE;
    //商品状态 0为假1为真
    private  String  GOODSSTATUS;
    //商品数量
    private  String  GOODSNUMBER;
    //商品成本
    private  String  GOODSCOST;
    //商品所需温度
    private  String  GOODSTEMPERATURE;
    //商品所需光照
    private  String  GOODSLIGHT ;
    //商品保质期
    private  String  GOODSLIFE;

    public String getGOODSNAME() {
        return GOODSNAME;
    }

    public void setGOODSNAME(String GOODSNAME) {
        this.GOODSNAME = GOODSNAME;
    }

    public String getGOODS_ID() {
        return GOODS_ID;
    }

    public void setGOODS_ID(String GOODS_ID) {
        this.GOODS_ID = GOODS_ID;
    }

    public String getGOODSNUM() {
        return GOODSNUM;
    }

    public void setGOODSNUM(String GOODSNUM) {
        this.GOODSNUM = GOODSNUM;
    }
    public String getGOODSPRICE() {
        return GOODSPRICE;
    }

    public void setGOODSPRICE(String GOODSPRICE) {
        this.GOODSPRICE = GOODSPRICE;
    }

    public String getGOODSLIFE() {
        return GOODSLIFE;
    }

    public void setGOODSLIFE(String GOODSLIFE) {
        this.GOODSLIFE = GOODSLIFE;
    }

    public String getGOODSLIGHT() {
        return GOODSLIGHT;
    }

    public void setGOODSLIGHT(String GOODSLIGHT) {
        this.GOODSLIGHT = GOODSLIGHT;
    }

    public String getGOODSTEMPERATURE() {
        return GOODSTEMPERATURE;
    }

    public void setGOODSTEMPERATURE(String GOODSTEMPERATURE) {
        this.GOODSTEMPERATURE = GOODSTEMPERATURE;
    }

    public String getGOODSCOST() {
        return GOODSCOST;
    }

    public void setGOODSCOST(String GOODSCOST) {
        this.GOODSCOST = GOODSCOST;
    }

    public String getGOODSNUMBER() {
        return GOODSNUMBER;
    }

    public void setGOODSNUMBER(String GOODSNUMBER) {
        this.GOODSNUMBER = GOODSNUMBER;
    }

    public String getGOODSSTATUS() {
        return GOODSSTATUS;
    }

    public void setGOODSSTATUS(String GOODSSTATUS) {
        this.GOODSSTATUS = GOODSSTATUS;
    }

    public String getGOODSTYPE() {
        return GOODSTYPE;
    }

    public void setGOODSTYPE(String GOODSTYPE) {
        this.GOODSTYPE = GOODSTYPE;
    }

    public String getGOODSIMAGE() {
        return GOODSIMAGE;
    }

    public void setGOODSIMAGE(String GOODSIMAGE) {
        this.GOODSIMAGE = GOODSIMAGE;
    }

    public String getGOODSINFO() {
        return GOODSINFO;

    }

    public void setGOODSINFO(String GOODEINFO) {
        this.GOODSINFO = GOODEINFO;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "GOODS_ID='" + GOODS_ID + '\'' +
                ", GOODSNUM='" + GOODSNUM + '\'' +
                ", GOODSNAME='" + GOODSNAME + '\'' +
                ", GOODSPRICE='" + GOODSPRICE + '\'' +
                ", GOODSINFO='" + GOODSINFO + '\'' +
                ", GOODSIMAGE='" + GOODSIMAGE + '\'' +
                ", GOODSTYPE='" + GOODSTYPE + '\'' +
                ", GOODSSTATUS='" + GOODSSTATUS + '\'' +
                ", GOODSNUMBER='" + GOODSNUMBER + '\'' +
                ", GOODSCOST='" + GOODSCOST + '\'' +
                ", GOODSTEMPERATURE='" + GOODSTEMPERATURE + '\'' +
                ", GOODSLIGHT='" + GOODSLIGHT + '\'' +
                ", GOODSLIFE='" + GOODSLIFE + '\'' +
                '}';
    }
}
