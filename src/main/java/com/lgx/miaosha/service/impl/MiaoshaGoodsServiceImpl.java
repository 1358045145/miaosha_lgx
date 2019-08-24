package com.lgx.miaosha.service.impl;

import com.lgx.miaosha.exception.GoodsException;
import com.lgx.miaosha.result.CodeMessage;
import com.lgx.miaosha.service.GoodsService;
import com.lgx.miaosha.service.OrderService;
import com.lgx.miaosha.vo.GoodsVo;
import com.lgx.miaosha.model.Order;
import com.lgx.miaosha.model.User;
import com.lgx.miaosha.service.MiaoshaGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 秒杀模块的service实现类
 */
@Service
public class MiaoshaGoodsServiceImpl implements MiaoshaGoodsService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    /**
     * 具体秒杀
     * @param user
     * @param goods
     * @return
     */
    @Transactional
    @Override
    public Order miaosha(User user, GoodsVo goods) {
        //减少库存
        int updateCount = goodsService.reduceMiaoshaGoodsStock(goods);
        if(updateCount != 1){
            throw new GoodsException(CodeMessage.GOODS_UPDATE_FAIL);
        }
        //下订单
        Order order = orderService.createOrder(user, goods);
        return order;
    }
}
