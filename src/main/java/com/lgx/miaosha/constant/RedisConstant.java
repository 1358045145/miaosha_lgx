package com.lgx.miaosha.constant;

import java.util.UUID;

public interface RedisConstant {

    public static final Integer EXPIRE = 30 *3600;

    String GOODS_DETAIL_KEY = UUID.randomUUID().toString().replace("-"," "); //商品详情页的KEY
    String GOODS_LIST_KEY = UUID.randomUUID().toString().replace("-"," "); //商品列表的KEY

    String GOODSIDKEY = "goodsIdKey";
    String GOODSKEY = "goodsKey";

    String ORDERKEY = "orderKey";



}
