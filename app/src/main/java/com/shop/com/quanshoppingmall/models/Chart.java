package com.shop.com.quanshoppingmall.models;

import android.graphics.Bitmap;

/**
 * Created by caowenjuan on 16/10/27.
 * <p/>
 * 购物车数据模型
 */
public class Chart {
    private String chartShopName;
    private Bitmap chartGoodsLogo;
    private String chartGoodsName;
    private String chartGoodsInfo;
    private int chartGoodsMoney;
    private boolean isSelected;

    public String getChartShopName() {
        return chartShopName;
    }

    public Bitmap getChartGoodsLogo() {
        return chartGoodsLogo;
    }

    public String getChartGoodsName() {
        return chartGoodsName;
    }

    public String getChartGoodsInfo() {
        return chartGoodsInfo;
    }

    public int getChartGoodsMoney() {
        return chartGoodsMoney;
    }
    public boolean isSelected() {
        return isSelected;
    }

    public void setChartShopName(String chartShopName) {
        this.chartShopName = chartShopName;
    }

    public void setChartGoodsLogo(Bitmap chartGoodsLogo) {
        this.chartGoodsLogo = chartGoodsLogo;
    }

    public void setChartGoodsName(String chartGoodsName) {
        this.chartGoodsName = chartGoodsName;
    }

    public void setChartGoodsInfo(String chartGoodsInfo) {
        this.chartGoodsInfo = chartGoodsInfo;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setChartGoodsMoney(int chartGoodsMoney) {
        this.chartGoodsMoney = chartGoodsMoney;
    }

}
