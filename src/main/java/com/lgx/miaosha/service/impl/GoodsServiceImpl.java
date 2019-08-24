package com.lgx.miaosha.service.impl;

import com.lgx.miaosha.model.Goods;
import com.lgx.miaosha.model.MiaoShaGoods;
import com.lgx.miaosha.mapper.GoodsMapper;
import com.lgx.miaosha.service.GoodsService;
import com.lgx.miaosha.vo.GoodsVo;
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

    /**
     * 更新商品库存
     * @param goods
     * @return
     */
    @Override
    public int reduceMiaoshaGoodsStock(GoodsVo goods) {
        MiaoShaGoods miaoShaGoods = new MiaoShaGoods();
        miaoShaGoods.setGoodsId(goods.getId());
        return goodsMapper.updateByMiaoshaGoods(miaoShaGoods);
    }

    /**
     * 根据商品的ID查询商品
     * @param goodsId
     * @return
     */
    @Override
    public Goods getGoodsById(Integer goodsId) {
        return goodsMapper.getGoodsById(goodsId);
    }
}
