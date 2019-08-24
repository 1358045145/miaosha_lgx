package com.lgx.miaosha.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.lgx.miaosha.service.MiaoshaOrderService;
import com.lgx.miaosha.config.RabbitMqConfig;
import com.lgx.miaosha.model.MiaoShaOrder;
import com.lgx.miaosha.model.Order;
import com.lgx.miaosha.model.User;
import com.lgx.miaosha.service.GoodsService;
import com.lgx.miaosha.service.MiaoshaGoodsService;
import com.lgx.miaosha.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息接收方
 */
@Component
public class MessageReceiver {

    private Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    @Autowired
    GoodsService goodsService;

    @Autowired
    MiaoshaOrderService miaoshaOrderService;

    @Autowired
    MiaoshaGoodsService miaoshaGoodsService;

    @Autowired
    RedisTemplate redisTemplate;

    @RabbitListener(queues = RabbitMqConfig.MIAOSHA_QUEUE)
    public void reveive(String message){
        MiaoshaMessage miaoshaMessage = (MiaoshaMessage) JSON.parse(message);
        logger.info("接收到 message" + miaoshaMessage);
        User user = miaoshaMessage.getUser();
        Integer goodsId = miaoshaMessage.getGoodsId();

        GoodsVo goodsVo = goodsService.getGoodsVoById(goodsId);
        //判断库存
        if (goodsVo.getStockCount() < 0){
            return;
        }
        //库存充足的话判断是否是重复秒杀
        MiaoShaOrder miaoShaOrder = miaoshaOrderService.getMiaoshaOrderByGoodsId(user.getId(), goodsId);
        if (miaoShaOrder != null){
            return;
        }
        //秒杀 ：  减库存，下订单，写入数据库
        Order order = miaoshaGoodsService.miaosha(user,goodsVo);
        String orderStr = JSON.toJSONString(order);
        redisTemplate.opsForValue().set("",orderStr);
    }
}
