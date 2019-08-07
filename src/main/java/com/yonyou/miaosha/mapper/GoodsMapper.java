package com.yonyou.miaosha.mapper;

import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodsMapper extends Mapper<Goods> {

    /**
     * 获得商品列表
     * @return
     */
    @Select("select g.*,mg.miaosha_price,mg.stock_count,mg.end_date,mg.start_date from miaosha_goods mg left join goods g on g.id = mg.goods_id")
    List<GoodsVo> getGoodsVoList();

    @Select("select g.*,mg.miaosha_price,mg.stock_count,mg.end_date,mg.start_date from miaosha_goods mg left join goods g on g.id = mg.goods_id where g.id = #{goodId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId")Integer goodsId);
}
