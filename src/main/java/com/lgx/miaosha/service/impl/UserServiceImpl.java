package com.lgx.miaosha.service.impl;

import com.alibaba.fastjson.JSON;
import com.lgx.miaosha.constant.CookieConstant;
import com.lgx.miaosha.exception.UserException;
import com.lgx.miaosha.result.CodeMessage;
import com.lgx.miaosha.utils.MD5Util;
import com.lgx.miaosha.vo.LoignVo;
import com.lgx.miaosha.mapper.UserMapper;
import com.lgx.miaosha.model.User;
import com.lgx.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 用户模块服务层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    RedisTemplate<String,Object> redisTemplate;

    /**
     * 根据用户的ID查询用户
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    //生成token
    String token = UUID.randomUUID().toString().replace("-","");
    /**
     * 根据用户的登陆信息做检验
     * @param loginVo
     * @return
     */
    @Override
    public Boolean checkLoginInfo(HttpServletResponse response, LoignVo loginVo) {
        //直接从token中取
        String userStr = (String) redisTemplate.opsForValue().get(token);
        if (token != null){
            User tokenUser = (User) JSON.parse(userStr);
            //重置时间
            addCookie(response,token,tokenUser);
            return true;
        }
        //token没有，走下面的环节
        if(loginVo == null){
            throw new UserException(CodeMessage.USER_NOTFOUND); //用户找不到
        }
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        //对手机号做检验
        User user = userMapper.selectByPrimaryKey(mobile);
        if (user == null){
            throw new UserException(CodeMessage.MOBILE_NOTFOUND); //手机号找不到
        }
        //对密码进行校验
        String DbPass = user.getPassword();
        String DbSalt = user.getSalt();
        String formPass = MD5Util.formPassToDB(loginVo.getPassword(),DbSalt);
        if (!DbPass.equals(formPass)){
            throw new UserException(CodeMessage.PASSWORD_NOTRIGHT); //密码不对
        }
        //校验成功
        //生成cookie
        addCookie(response,token,user);
        return true;
    }


    private void addCookie(HttpServletResponse response,String token,User user){
        //写入Redis中
        String userStr = (String)JSON.toJSON(user);
        redisTemplate.opsForValue().set(token,userStr);
        Cookie cookie = new Cookie(CookieConstant.COOKIE_NAME, token);
        cookie.setPath("/");
        cookie.setMaxAge(CookieConstant.EXPIRE);
        response.addCookie(cookie);
    }
}
