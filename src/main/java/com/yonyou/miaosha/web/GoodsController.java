package com.yonyou.miaosha.web;

import com.yonyou.miaosha.exception.GoodsException;
import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.model.User;
import com.yonyou.miaosha.result.CodeMessage;
import com.yonyou.miaosha.result.Result;
import com.yonyou.miaosha.service.GoodsService;
import com.yonyou.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 查看商品列表
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/list")
    public String goodsList(Model model, User user){
        List<GoodsVo> goodsList = goodsService.getGoodsVoList();
        if(CollectionUtils.isEmpty(goodsList)){
            throw new GoodsException(CodeMessage.GOODS_NOTFOUNT);
        }
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("user",user);
        return "goods_list";
    }

    /**
     * 查看商品详情
     * @param model
     * @param goodsId
     * @param user
     * @return
     */
    @RequestMapping("/detail/{goodsId}")
    public String toDetail(Model model,@PathVariable("goodsId") Integer goodsId,User user){

        GoodsVo goodsVo = goodsService.getGoodsVoById(goodsId);
        if (goodsVo == null){
            throw new GoodsException(CodeMessage.GOODS_DEATIL_NOTFOUNT);
        }
        //判断秒杀时间是否已经到了
        long begin = goodsVo.getStartDate().getTime();
        long end = goodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();  //当前时间
        int miaoshaStatus = 0;     //秒杀状态
        int remainSeconds  = 0;   //倒计时
        if (now < begin){
            miaoshaStatus = 0;//秒杀还没开始
            remainSeconds = (int)(begin - now) / 1000;  //倒计时
        }else if(now > end){
            miaoshaStatus = -1; //秒杀结束了
            remainSeconds = -1;
        }else {
            miaoshaStatus = 1;  //秒杀进行时
            remainSeconds = 0;
        }
        model.addAttribute("goodsVo",goodsVo);
        model.addAttribute("user",user);
        model.addAttribute("miaoshaStatus",miaoshaStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        return "goods_detail";
    }
}
