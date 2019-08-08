package com.yonyou.miaosha.service;

import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.model.Order;
import com.yonyou.miaosha.model.User;

/**
 * 订单模块的service
 */
public interface OrderService {

    /**
     * 创建订单
     * @param user
     * @param goods
     * @return
     */
    public Order createOrder(User user, Goods goods);
}
