package com.lgx.miaosha.service;

import com.lgx.miaosha.vo.GoodsVo;
import com.lgx.miaosha.model.Order;
import com.lgx.miaosha.model.User;

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
    public Order miaosha(User user, GoodsVo goods);


}
