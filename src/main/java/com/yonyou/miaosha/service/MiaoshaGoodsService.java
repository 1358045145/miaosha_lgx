package com.yonyou.miaosha.service;

import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.model.Order;
import com.yonyou.miaosha.model.User;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 秒杀模块的service
 */
public interface MiaoshaGoodsService {

    /**
     * 秒杀
     * @param user
     * @param goods
     * @return
     */
    public Order miaosha(User user, Goods goods);


}
