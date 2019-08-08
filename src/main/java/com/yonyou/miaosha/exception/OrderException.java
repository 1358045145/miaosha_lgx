package com.yonyou.miaosha.exception;

import com.yonyou.miaosha.result.CodeMessage;

public class OrderException extends RuntimeException {
    private Integer code;
    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public OrderException(CodeMessage codeMessage){
        super(codeMessage.getMsg());
        this.code = codeMessage.getCode();
    }
}
