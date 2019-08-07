package com.yonyou.miaosha.service.impl;

import com.yonyou.miaosha.mapper.GoodsMapper;
import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.service.GoodsService;
import com.yonyou.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    /**
     * 获得商品列表
     */
    @Autowired(required = false)
    GoodsMapper goodsMapper;
    @Override
    public List<GoodsVo> getGoodsVoList() {
        return goodsMapper.getGoodsVoList();
    }

    /**
     * 获得单个商品
     * @param id
     * @return
     */
    @Override
    public GoodsVo getGoodsVoById(Integer id) {
        return goodsMapper.getGoodsVoByGoodsId(id);
    }
}
