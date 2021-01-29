package com.sany.email.model.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class Request<T> implements Serializable {
    private T data;

    public Request(){

    }

    public Request(T data){
        this.data = data;
    }
}
