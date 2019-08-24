package com.lgx.miaosha.service;

import com.lgx.miaosha.vo.LoignVo;
import com.lgx.miaosha.model.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    /**
     * 根据用户的ID查询用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

    User getUserByName(String name);

    Boolean checkLoginInfo(HttpServletResponse response, LoignVo loginVo);
}
