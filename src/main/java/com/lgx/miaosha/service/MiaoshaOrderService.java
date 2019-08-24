package com.lgx.miaosha.service;

import com.lgx.miaosha.model.MiaoShaOrder;

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
