package com.lgx.miaosha.vo;

import com.lgx.miaosha.model.Goods;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsVo extends Goods {

    private BigDecimal miaoshaPrice;   //秒杀价格

    private Integer stockCount;      //秒杀数量

    private Date startDate;          //开始日期

    private Date endDate;        //结束日期




}
