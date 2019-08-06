package com.yonyou.miaosha.result;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.Data;
import lombok.Getter;

public enum CodeMessage {

    USER_NOTFOUND(40001,"用户找不到"),
    MOBILE_NOTFOUND(40002,"手机号找不到"),
    PASSWORD_NOTRIGHT(40003,"密码不正确");


    private String msg;
    private Integer code;
    private CodeMessage(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
