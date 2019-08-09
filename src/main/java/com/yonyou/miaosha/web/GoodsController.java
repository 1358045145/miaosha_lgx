package com.yonyou.miaosha.web;

import com.yonyou.miaosha.constant.RedisConstant;
import com.yonyou.miaosha.exception.GoodsException;
import com.yonyou.miaosha.model.Goods;
import com.yonyou.miaosha.model.User;
import com.yonyou.miaosha.result.CodeMessage;
import com.yonyou.miaosha.result.Result;
import com.yonyou.miaosha.service.GoodsService;
import com.yonyou.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.context.webflux.SpringWebFluxContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    RedisTemplate<String,String> redisTemplate;


    /**
     * 查看商品列表
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/to_list",produces = "text/html")
    @ResponseBody
    public String goodsList(HttpServletRequest request,HttpServletResponse response,Model model, User user){
        //从缓存中获取
        String html = redisTemplate.opsForValue().get(RedisConstant.GOODS_LIST_KEY);
        if (!StringUtils.isEmpty(html)){
            return html;
        }
        List<GoodsVo> goodsList = goodsService.getGoodsVoList();
        if(CollectionUtils.isEmpty(goodsList)){
            throw new GoodsException(CodeMessage.GOODS_NOTFOUNT);
        }
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("user",user);
        //手动渲染
        WebContext webContext = new WebContext(request,response,request.getServletContext(),request.getLocale(),model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goods_list",webContext);
        if (!StringUtils.isEmpty(html)){
            redisTemplate.opsForValue().set(RedisConstant.GOODS_LIST_KEY,html,60,TimeUnit.SECONDS);
        }
        return html;
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


    @RequestMapping(value = "/to_detail2/{goodsId}",produces = "text/html")
    @ResponseBody
    public String toDetail(HttpServletResponse response, HttpServletRequest request,
                           Model model,
                           @PathVariable("goodsId") Integer goodsId,
                           User user){
        //从缓存中取出来
        String html = redisTemplate.opsForValue().get(RedisConstant.GOODS_DETAIL_KEY);
        if (!StringUtils.isEmpty(html)){
            return html;
        }
        //缓存中获取不到，查询数据库
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
        WebContext webContext = new WebContext(request,response,request.getServletContext(),request.getLocale(),model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goods_detail",webContext);
        //将页面加入到缓存中
        if (!StringUtils.isEmpty(html)){
            redisTemplate.opsForValue().set(RedisConstant.GOODS_DETAIL_KEY,html,60, TimeUnit.SECONDS); //60s的缓存
        }
        return html;
    }
}
