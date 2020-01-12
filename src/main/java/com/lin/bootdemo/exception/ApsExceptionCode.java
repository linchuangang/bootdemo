package com.lin.bootdemo.exception;

/**
 * Created by Administrator on 2018/11/26.
 * @author
 */
public enum ApsExceptionCode {

    NO_UPDATE_PROGRAM(0, "没有更新程序"),
    NO_PROGRAM_IS_RUNNING(1, "没有程序运行中"),
    INITIALIZATION_ABNORMAL_TERMINATED(2, "初始化出现异常,已终止");


    public final int code;
    public final String desc;

    ApsExceptionCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
