package com.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestBean<T>{

    int code;

    String reason;

    T data;

    String token;

    public RestBean(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }
}