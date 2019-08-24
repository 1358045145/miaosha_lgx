package com.lgx.miaosha.service;

import com.lgx.miaosha.model.Goods;
import com.lgx.miaosha.model.Order;
import com.lgx.miaosha.model.User;

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
