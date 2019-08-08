package com.yonyou.miaosha.service.impl;

import com.yonyou.miaosha.mapper.MiaoshaOrderMapper;
import com.yonyou.miaosha.model.MiaoShaOrder;
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
}
