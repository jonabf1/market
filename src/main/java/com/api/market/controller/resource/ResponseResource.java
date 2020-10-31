package com.api.market.controller.resource;

import lombok.Data;

@Data
public class ResponseResource<T> {

    private T data;

    public ResponseResource(T data){
        this.data = data;
    }

}
