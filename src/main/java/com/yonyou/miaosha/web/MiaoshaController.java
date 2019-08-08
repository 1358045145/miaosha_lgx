package com.yonyou.miaosha.web;

import com.yonyou.miaosha.model.User;
import com.yonyou.miaosha.result.Result;
import com.yonyou.miaosha.service.MiaoShaGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    MiaoShaGoodsService miaoShaGoodsService;

    @RequestMapping("/do_miaosha")
    public String doMiaosha(Model model, User user, @RequestParam("goodsId")Integer goodsId){


        return "order_detail";  //秒杀成功
    }
}
