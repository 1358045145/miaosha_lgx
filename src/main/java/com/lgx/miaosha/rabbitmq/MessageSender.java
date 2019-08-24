package com.lgx.miaosha.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.lgx.miaosha.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送方
 */
@Component
public class MessageSender {

    private Logger logger = LoggerFactory.getLogger(MessageSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;


    /**
     * 发送消息
     * @param message
     */
    public void send(MiaoshaMessage message){
        String miaoshaMessage = JSONObject.toJSONString(message);
        logger.info("send message" + miaoshaMessage);
        amqpTemplate.convertAndSend(RabbitMqConfig.MIAOSHA_QUEUE,miaoshaMessage);
    }
}
