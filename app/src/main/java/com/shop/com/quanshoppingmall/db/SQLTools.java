package com.shop.com.quanshoppingmall.db;

/**
 * Created by caowenjuan on 16/10/28.
 * SQL语句管理
 */
public class SQLTools {

    // 创建商家表
    public static class Business {
        // 表名称
        public static final String BUSINESS_TABLE_NAME = "business";
        // 商家ID
        public static final String BUSINESS_ID = "_business_id";
        // 商家名称
        public static final String BUSINESS_NAME = "business_name";
        // 商家地址
        public static final String BUSINESS_ADDRESS = "business_address";
        // 商家是否属于推荐的商家
        public static final String BUSINESS_TYPE = "business_type";
        public static final int BUSINESS_TYPE_YES = 1000;
        public static final int BUSINESS_TYPE_NO = 1001;
        // 关注人数
        public static final String BUSINESS_FANS_NUM = "fans_num";
        // 快递费用
        static final String BUSINESS_EMS_MONEY = "ems_money";
        static final String CREATE_BUSINESS_TABLE = "create table business(" +
                "_business_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",business_name VARCHAR(30)" +
                ",business_address VARCHAR(10)" +
                ",business_type INTEGER" +
                ",fans_num INTEGER" +
                ",ems_money VARCHAR(10))";

        // 初始化商家数据
        static final String BUSINESS_INSERT[] = {
                "insert into business values(null,'蓝山咖啡','广东东莞',1000,34,'0:00') ",
                "insert into business values(null,'初页','上海虹桥',1000,633,'0:00') ",
                "insert into business values(null,'小妮子家的衣橱','河北沧州',1000,3,'0:00') ",
                "insert into business values(null,'韩都衣舍','北京海淀',1000,788,'0:00') ",
        };
    }

    // 创建商品表
    public static class Goods {
        // 商品ID
        public static final String GOODS_ID = "_id";
        // 商品名称
        public static final String GOODS_NAME = "goods_name";
        // 商品价格
        public static final String GOODS_MONEY = "goods_money";
        // 商品信息
        public static final String GOODS_INFO = "goods_info";
        // 商品月销量
        public static final String GOODS_MONTH_SALES = "goods_month_sales";
        // 商品是否被收藏
        public static final String GOODS_IS_COLLECTED = "goods_is_collected";
        public static final int GOODS_IS_COLLECTED_YES = 1002;
        public static final int GOODS_IS_COLLECTED_NO = 1001;

        static final String CREATE_TABLE_GOODS = "create table goods(" +
                "_id  INTEGER KEY AUTOINCREMENT" +
                ",business_id INTEGER" +
                ",goods_name VARCHAR(30)" +
                ",goods_money INTEGER" +
                ",goods_info VARCHAR(30)" +
                ",goods_month_sales INTEGER" +
                ",goods_is_collected INTEGER)";
    }

}
