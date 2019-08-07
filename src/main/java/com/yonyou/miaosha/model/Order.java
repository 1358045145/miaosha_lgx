package com.yonyou.miaosha.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 */
@Data
public class Order {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String address;
    private String goodsName;
    private Integer goodsCount;
    private BigDecimal goodsPrice;
    private Date createDate;
    private Date payDate;
    private Integer status;

}
