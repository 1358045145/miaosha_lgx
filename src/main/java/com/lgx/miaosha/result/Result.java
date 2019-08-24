package com.lgx.miaosha.result;

import lombok.Data;

/**
 * 返回结果封装
 * @param <T>
 */
@Data
public class Result<T> {

     private Integer code;
     private String message;
     private T data;

    private Result(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    private Result(T data){
        this.data = data;
    }
    private Result(CodeMessage codeMessage){
        if(codeMessage != null){
            this.code = codeMessage.getCode();
            this.message = codeMessage.getMsg();
        }
    }

    /**
     * 返回成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<>(data);
    }

    /**
     * 返回失败
     * @param errormsg
     * @return
     */
    public static <T> Result<T> error(CodeMessage errormsg){
        return new Result<T>(errormsg);
    }

}
