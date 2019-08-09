package com.yonyou.miaosha.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.Date;

/**
 * 秒杀商品实体类
 */
@Data
public class MiaoShaGoods {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String goodsId;
    private Date startDate;
    private Date endDate;
    private Integer stockCount;

}
