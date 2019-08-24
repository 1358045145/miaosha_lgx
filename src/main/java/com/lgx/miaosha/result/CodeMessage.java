package com.lgx.miaosha.result;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.Data;
import lombok.Getter;

public enum CodeMessage {

    USER_NOTFOUND(40001,"用户找不到"),
    MOBILE_NOTFOUND(40002,"手机号找不到"),
    PASSWORD_NOTRIGHT(40003,"密码不正确"),

    GOODS_NOTFOUNT(50001,"商品列表找不到"),
    GOODS_DEATIL_NOTFOUNT(50002,"商品详情不存在"),
    GOODS_UPDATE_FAIL(50003,"商品更新失败"),
    GOODS_NOT_HAVE_STOCKCOUNT(50004,"商品库存不足"),

    ORDER_INSERT_FAIL(60001,"订单插入失败"),
    MIAOASH_ORDER_INSERT_FAIL(60002,"秒杀订单插入失败"),
    ORDER_CREATE_FAIL(60003,"订单创建失败"),


    MIAOSHA_REPEATED(70001,"不能重复秒杀"),
    MIAOSHA_OVER(70002,"秒杀结束了");



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
