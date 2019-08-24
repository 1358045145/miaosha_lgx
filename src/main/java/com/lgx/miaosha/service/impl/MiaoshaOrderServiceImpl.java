package com.lgx.miaosha.service.impl;

import com.lgx.miaosha.mapper.MiaoshaOrderMapper;
import com.lgx.miaosha.model.MiaoShaOrder;
import com.lgx.miaosha.service.MiaoshaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiaoshaOrderServiceImpl implements MiaoshaOrderService {

    @Autowired(required = false)
    MiaoshaOrderMapper miaoshaOrderMapper;

    /**
     * 新增订单
     * @param miaoShaOrder
     * @return
     */
    @Override
    public int insertMiaoshaOrder(MiaoShaOrder miaoShaOrder) {
        return miaoshaOrderMapper.insert(miaoShaOrder);
    }

    /**
     * 获取秒杀订单
     * @param goodsId
     * @return
     */
    @Override
    public MiaoShaOrder getMiaoshaOrderByGoodsId(Integer userId,Integer goodsId) {
        MiaoShaOrder miaoShaOrder = new MiaoShaOrder();
        miaoShaOrder.setUserId(userId);
        miaoShaOrder.setGoodsId(goodsId);
        return miaoshaOrderMapper.selectOne(miaoShaOrder);
    }
}
