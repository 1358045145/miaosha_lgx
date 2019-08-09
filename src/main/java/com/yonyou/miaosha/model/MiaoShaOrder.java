package com.yonyou.miaosha.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

/**
 * 秒杀订单实体类
 */
@Data
public class MiaoShaOrder {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Integer orderId;

}
