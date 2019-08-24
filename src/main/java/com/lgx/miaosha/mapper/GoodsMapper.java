package com.lgx.miaosha.mapper;

import com.lgx.miaosha.model.Goods;
import com.lgx.miaosha.model.MiaoShaGoods;
import com.lgx.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Select("select * from goods where id = #{goodsId}")
    Goods getGoodsById(@Param("goodsId")Integer goodsId);

    @Update("update miaosha_goods set stock_count=stock_count - 1 where goods_id =#{goodsId} and stock_count > 0")
    int updateByMiaoshaGoods(MiaoShaGoods g);

}
