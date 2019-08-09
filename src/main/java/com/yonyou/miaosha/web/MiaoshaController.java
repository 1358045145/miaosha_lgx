package com.yonyou.miaosha.web;

import com.yonyou.miaosha.model.MiaoShaOrder;
import com.yonyou.miaosha.model.Order;
import com.yonyou.miaosha.model.User;
import com.yonyou.miaosha.result.CodeMessage;
import com.yonyou.miaosha.service.GoodsService;
import com.yonyou.miaosha.service.MiaoshaGoodsService;
import com.yonyou.miaosha.service.MiaoshaOrderService;
import com.yonyou.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    MiaoshaGoodsService miaoShaGoodsService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    MiaoshaOrderService miaoshaOrderService;

    @RequestMapping("/do_miaosha")
    public String doMiaosha(Model model, User user, @RequestParam("goodsId")Integer goodsId){
        //先去查看库存是否充足
        GoodsVo goodsVo = goodsService.getGoodsVoById(goodsId);
        Integer stockCount = goodsVo.getStockCount();
        if (stockCount < 0 ){
            model.addAttribute("errmsg",CodeMessage.GOODS_NOT_HAVE_STOCKCOUNT);//库存不足，秒杀失败
            return "miaosha_fail";
        }
         //判断是否秒杀到了
        MiaoShaOrder miaoShaOrder = miaoshaOrderService.getMiaoshaOrderByGoodsId(user.getId(),goodsId);
        if (miaoShaOrder != null){
            model.addAttribute("errmsg",CodeMessage.MIAOSHA_REPEATED);  //不能重复秒杀
            return "miaosha_fail";
        }
        //秒杀逻辑
        Order order = miaoShaGoodsService.miaosha(user,goodsVo);
        model.addAttribute("user",user);
        model.addAttribute("orderInfo",order);
        model.addAttribute("goods",goodsVo);
        return "order_detail";  //秒杀成功
    }
}
