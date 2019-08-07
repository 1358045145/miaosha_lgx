package com.yonyou.miaosha.model;

import lombok.Data;

import java.util.Date;

/**
 * 秒杀商品实体类
 */
@Data
public class MiaoShaGoods {

    private Integer id;
    private String goodsId;
    private Date startDate;
    private Date endDate;
    private Integer stockCount;

}
