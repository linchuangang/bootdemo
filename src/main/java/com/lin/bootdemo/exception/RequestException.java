package com.lin.bootdemo.exception;

/**
 * Created by Administrator on 2018/12/13.
 */
public class RequestException extends RuntimeException {
    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
