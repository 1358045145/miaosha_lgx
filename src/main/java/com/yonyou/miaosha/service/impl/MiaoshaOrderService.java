package com.yonyou.miaosha.service.impl;

import com.yonyou.miaosha.model.MiaoShaOrder;

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

}
