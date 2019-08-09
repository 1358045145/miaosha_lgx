package com.yonyou.miaosha.service.impl;

import com.yonyou.miaosha.exception.OrderException;
import com.yonyou.miaosha.mapper.OrderMapper;
import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.model.MiaoShaOrder;
import com.yonyou.miaosha.model.Order;
import com.yonyou.miaosha.model.User;
import com.yonyou.miaosha.result.CodeMessage;
import com.yonyou.miaosha.service.MiaoshaOrderService;
import com.yonyou.miaosha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    OrderMapper orderMapper;

    @Autowired
    MiaoshaOrderService miaoshaOrderService;
    /**
     * 创建订单
     * @param user
     * @param goods
     * @return
     */
    @Override
    public Order createOrder(User user, Goods goods) {
        Order order = new Order();
        order.setCreateDate(new Date());
        order.setGoodsCount(1);
        order.setGoodsId(goods.getId());
        order.setUserId(user.getId());
        order.setGoodsName(goods.getGoodsName());
        order.setGoodsPrice(goods.getGoodsPrice());
        order.setAddress(user.getAddress());
        order.setStatus(0);
        int insertOrder = orderMapper.insert(order);
        if (insertOrder != 1){
            throw new OrderException(CodeMessage.ORDER_INSERT_FAIL); //订单插入失败
        }
        MiaoShaOrder miaoShaOrder = new MiaoShaOrder();
        miaoShaOrder.setGoodsId(goods.getId());
        miaoShaOrder.setOrderId(user.getId());
        miaoShaOrder.setOrderId(order.getId());
        int insertMiaoshaOrder = miaoshaOrderService.insertMiaoshaOrder(miaoShaOrder);
        if (insertMiaoshaOrder != 1){
            throw new OrderException(CodeMessage.MIAOASH_ORDER_INSERT_FAIL); //秒杀订单插入失败
        }
        return order;
    }
}
