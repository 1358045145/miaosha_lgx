package com.lgx.miaosha.web;

import com.alibaba.fastjson.JSONObject;
import com.lgx.miaosha.constant.RedisConstant;
import com.lgx.miaosha.rabbitmq.MessageSender;
import com.lgx.miaosha.rabbitmq.MiaoshaMessage;
import com.lgx.miaosha.result.CodeMessage;
import com.lgx.miaosha.service.GoodsService;
import com.lgx.miaosha.service.MiaoshaOrderService;
import com.lgx.miaosha.vo.GoodsVo;
import com.lgx.miaosha.model.Order;
import com.lgx.miaosha.model.User;
import com.lgx.miaosha.service.MiaoshaGoodsService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController implements InitializingBean {

    Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();

    @Autowired(required = false)
    RedisTemplate redisTemplate;

    @Autowired
    MiaoshaGoodsService miaoShaGoodsService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    MiaoshaOrderService miaoshaOrderService;

    @Autowired
    MessageSender messageSender;


    @Override
    public void afterPropertiesSet() throws Exception {
         //将所有商品的库存都加入到Redis中
        List<GoodsVo> goodsVoList = goodsService.getGoodsVoList();
        if (CollectionUtils.isEmpty(goodsVoList)){
            return;
        }
        for (GoodsVo goodsVo : goodsVoList) {
            redisTemplate.opsForValue().set(RedisConstant.GOODSIDKEY + "_" + goodsVo.getId(),+ goodsVo.getStockCount());
            redisTemplate.opsForValue().set(RedisConstant.GOODSKEY,JSONObject.toJSONString(goodsVo));
            map.put(goodsVo.getId(),false);
        }
    }

    /**
     * 秒杀
     * @param model
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping("/do_miaosha")
    public String doMiaosha(Model model, User user, @RequestParam("goodsId")Integer goodsId){
        //增加内存标记，减少Redis的访问
        if (map.get(goodsId)){
            model.addAttribute("errmsg", CodeMessage.MIAOSHA_OVER); //秒杀结束
            return "miaosha_fail";
        }
        //redis实现预减库存
        Long stock = redisTemplate.opsForValue().decrement(RedisConstant.GOODSIDKEY + "_" + goodsId);
        if (stock < 0){
            map.put(goodsId,true);
            model.addAttribute("errmsg",CodeMessage.MIAOSHA_OVER); //秒杀结束
            return "miaosha_fail";
        }
        MiaoshaMessage miaoshaMessage = new MiaoshaMessage();
        miaoshaMessage.setUser(user);
        miaoshaMessage.setGoodsId(goodsId);
        messageSender.send(miaoshaMessage);
        model.addAttribute("user",user);
        String orderStr = (String) redisTemplate.opsForValue().get(RedisConstant.ORDERKEY);
        String jsonGoods = (String) redisTemplate.opsForValue().get(RedisConstant.GOODSKEY);
        GoodsVo goodsVo = JSONObject.parseObject(jsonGoods,GoodsVo.class);
        Order order = JSONObject.parseObject(orderStr,Order.class);
        model.addAttribute("orderInfo",order);
        model.addAttribute("goods",goodsVo);
        return "order_detail";  //秒杀成功
    }


}
