package com.lin.bootdemo.common;

import java.util.Date;

public class ResultDtO<T> {
    private boolean success;
    private String msg;
    private String errMsg;
    private T result;
    private Integer code;
    private Date timestamp; // 服务器当前时间

    public ResultDtO() {
    }

    public ResultDtO(boolean success, String msg, String errMsg, T result, Integer code, Date timestamp) {
        this.success = success;
        this.msg = msg;
        this.errMsg = errMsg;
        this.result = result;
        this.code = code;
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
