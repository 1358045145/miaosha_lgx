package com.yonyou.miaosha.service;

import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.vo.GoodsVo;

import java.util.List;

/**
 * 商品接口
 */
public interface GoodsService {

    /**
     * 获得商品列表
     * @return
     */
    List<GoodsVo> getGoodsVoList();

    /**
     * 获得单个商品
     * @param id
     * @return
     */
    GoodsVo getGoodsVoById(Integer id);
}