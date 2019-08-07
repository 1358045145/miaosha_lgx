package com.yonyou.miaosha.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品实体类
 */
@Data
public class Goods {
    private Integer id;
    private String goodsName;
    private String goodsImg;
    private BigDecimal goodsPrice;
    private String goodsDetail;
    private Integer goodsStock;


}
