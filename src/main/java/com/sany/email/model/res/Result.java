package com.sany.email.model.res;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    /**
     * 接口状态
     */
    private Boolean success;

    /**
     * 返回内容
     */
    private T data;

    /**
     * 消息
     */
    private String message;

    public static <T> Result<T> create(){
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        return result;
    }

    public Result<T> success(){
        success(null);
        return this;
    }

    public Result<T> success(T data){
        this.setSuccess(true);
        this.data = data;
        return this;
    }

    public Result<T> fail(String message){
        this.setSuccess(false);
        this.setMessage(message);
        return this;
    }

}
