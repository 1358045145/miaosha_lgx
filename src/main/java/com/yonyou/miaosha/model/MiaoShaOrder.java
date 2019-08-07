package com.yonyou.miaosha.model;

import lombok.Data;

/**
 * 秒杀订单实体类
 */
@Data
public class MiaoShaOrder {

    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Integer orderId;

}
