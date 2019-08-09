package com.yonyou.miaosha.interceptor;

import com.alibaba.fastjson.JSON;
import com.yonyou.miaosha.constant.CookieConstant;
import com.yonyou.miaosha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired(required = false)
    RedisTemplate<String,Object> redisTemplate;

    /**
     * 前置拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //在cookie中查找是否存在
        Cookie[] cookies = request.getCookies();
        String tokenValue = "";
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(CookieConstant.COOKIE_NAME)){
                tokenValue = cookie.getValue();
            }
        }
        //在Redis中查找是否有该用户存在
        if(!StringUtils.isEmpty(tokenValue)){
            //从Redis中验证，Redis有的话返回true，放行
            String userJson = (String) redisTemplate.opsForValue().get(tokenValue);
            if (userJson != null){
                User user = (User) JSON.parse(userJson);
                if (user != null){
                    return true;
                }
            }
        }
        request.getRequestDispatcher("/login.html").forward(request,response);
        return false;
    }
}
