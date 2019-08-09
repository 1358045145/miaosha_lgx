package com.yonyou.miaosha.service;

import com.yonyou.miaosha.model.MiaoShaOrder;
import com.yonyou.miaosha.model.Order;
import com.yonyou.miaosha.model.User;

/**
 * 秒杀订单模块的service
 */
public interface MiaoshaOrderService {

    /**
     * 秒杀订单
     * @param miaoShaOrder
     * @return
     */
    int insertMiaoshaOrder(MiaoShaOrder miaoShaOrder);

    /**
     * 获取秒杀订单
     * @param goodsId
     * @return
     */
    MiaoShaOrder getMiaoshaOrderByGoodsId(Integer userId,Integer goodsId);

}
