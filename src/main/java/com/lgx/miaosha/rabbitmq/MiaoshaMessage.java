package com.lgx.miaosha.rabbitmq;

import com.lgx.miaosha.model.User;
import lombok.Data;

@Data
public class MiaoshaMessage {

    private User user;
    private Integer goodsId;


}
