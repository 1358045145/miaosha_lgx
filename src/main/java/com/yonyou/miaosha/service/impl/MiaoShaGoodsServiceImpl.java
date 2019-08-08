package com.yonyou.miaosha.service.impl;

import com.yonyou.miaosha.exception.GoodsException;
import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.model.Order;
import com.yonyou.miaosha.model.User;
import com.yonyou.miaosha.result.CodeMessage;
import com.yonyou.miaosha.service.GoodsService;
import com.yonyou.miaosha.service.MiaoShaGoodsService;
import com.yonyou.miaosha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 秒杀模块的service实现类
 */
@Service
public class MiaoShaGoodsServiceImpl implements MiaoShaGoodsService {

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
    public Order miaosha(User user, Goods goods) {
        //减少库存
        int updateCount = goodsService.updateGoodsStock(goods);
        if(updateCount != 0){
            throw new GoodsException(CodeMessage.GOODS_UPDATE_FAIL);
        }
        //下订单
        Order order = orderService.createOrder(user, goods);
        return order;
    }
}
