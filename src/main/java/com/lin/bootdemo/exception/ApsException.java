package com.lin.bootdemo.exception;

/**
 * Created by Administrator on 2018/11/26.
 */
public class ApsException extends RuntimeException {
    ApsExceptionCode code;

    public ApsException(String msg) {
        super(msg);
    }

    public ApsException(ApsExceptionCode code) {
        this.code = code;
    }

    public ApsException(String message, ApsExceptionCode code) {
        super(message);
        this.code = code;
    }

    public ApsException(String message, Throwable cause, ApsExceptionCode code) {
        super(message, cause);
        this.code = code;
    }

    public ApsException(Throwable cause, ApsExceptionCode code) {
        super(cause);
        this.code = code;
    }
    public ApsException(ApsExceptionCode code, Exception cause) {
        super(code.desc, cause);
        this.code = code;
    }
    public ApsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ApsExceptionCode code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public ApsExceptionCode getCode() {
        return code;
    }

    public void setCode(ApsExceptionCode code) {
        this.code = code;
    }
}
