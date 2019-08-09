package com.yonyou.miaosha.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.Date;

/**
 * 秒杀的用户实体类
 */
@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
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
