package com.lgx.miaosha.web;

import com.lgx.miaosha.result.Result;
import com.lgx.miaosha.service.UserService;
import com.lgx.miaosha.vo.LoignVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 用户模块的表现层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping("to_login")
    public String to_login(){
        return "login";
    }

    /**
     * 登陆验证
     * @param response
     * @param loginVo
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Result<Boolean> login(HttpServletResponse response, @Valid LoignVo loginVo){
        //校验逻辑在service层
        userService.checkLoginInfo(response,loginVo);
        return Result.success(true);
    }

}
