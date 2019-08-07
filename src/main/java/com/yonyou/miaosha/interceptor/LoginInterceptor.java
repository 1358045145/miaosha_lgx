package com.yonyou.miaosha.interceptor;

import com.yonyou.miaosha.constant.CookieConstant;
import com.yonyou.miaosha.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired(required = false)
    RedisService redisService;

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

        }
        request.getRequestDispatcher("/login.html").forward(request,response);
        return false;
    }
}
