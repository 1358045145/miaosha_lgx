package com.lgx.miaosha.service.impl;

import com.lgx.miaosha.exception.OrderException;
import com.lgx.miaosha.model.Goods;
import com.lgx.miaosha.result.CodeMessage;
import com.lgx.miaosha.service.MiaoshaOrderService;
import com.lgx.miaosha.mapper.OrderMapper;
import com.lgx.miaosha.model.MiaoShaOrder;
import com.lgx.miaosha.model.Order;
import com.lgx.miaosha.model.User;
import com.lgx.miaosha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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
