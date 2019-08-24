package com.lgx.miaosha.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 */
@Data
public class Order {
    @Id
    @KeySql(useGeneratedKeys = true)
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
