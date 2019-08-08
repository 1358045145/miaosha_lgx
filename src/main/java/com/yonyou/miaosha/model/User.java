package com.yonyou.miaosha.model;

import lombok.Data;

import java.util.Date;

/**
 * 秒杀的用户实体类
 */
@Data
public class User {
    private Integer id;
    private String address;
    private String nickName;
    private String password;
    private String salt;
    private String head;
    private Integer loginCount;
    private Date lastLoginDate;
    private Date registerDate;

}
