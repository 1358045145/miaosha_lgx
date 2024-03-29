package com.lgx.miaosha.service;

import com.lgx.miaosha.model.Goods;
import com.lgx.miaosha.vo.GoodsVo;

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

    /**
     * 更新商品的库存量
     * @param goods
     * @return
     */
    public int reduceMiaoshaGoodsStock(GoodsVo goods);

    /**
     * 通过商品ID获得商品信息
     * @param goodsId
     * @return
     */
    public Goods getGoodsById(Integer goodsId);
}
