package com.yonyou.miaosha.exception;

import com.yonyou.miaosha.result.CodeMessage;
import lombok.Data;

/**
 * 用户信息异常类
 */
@Data
public class UserException extends RuntimeException{
    private Integer code;

    public UserException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public UserException(CodeMessage codeMessage){
        super(codeMessage.getMsg());
        this.code = codeMessage.getCode();
    }

}
