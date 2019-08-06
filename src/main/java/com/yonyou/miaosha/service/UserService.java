package com.yonyou.miaosha.service;

import com.yonyou.miaosha.model.User;
import com.yonyou.miaosha.vo.LoignVo;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    /**
     * 根据用户的ID查询用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

    User getUserByName(String name);

    Boolean checkLoginInfo(HttpServletResponse response,LoignVo loginVo);
}
