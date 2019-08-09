package com.yonyou.miaosha.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品实体类
 */
@Data
public class Goods {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String goodsName;
    private String goodsImg;
    private BigDecimal goodsPrice;
    private String goodsDetail;
    private Integer goodsStock;


}
