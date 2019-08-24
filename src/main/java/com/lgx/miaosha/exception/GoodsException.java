package com.lgx.miaosha.exception;

import com.lgx.miaosha.result.CodeMessage;

public class GoodsException extends RuntimeException{

    private Integer code;

    public GoodsException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public GoodsException(CodeMessage codeMessage){
        super(codeMessage.getMsg());
        this.code = codeMessage.getCode();
    }
}
