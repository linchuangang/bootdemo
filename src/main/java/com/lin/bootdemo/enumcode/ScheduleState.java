package com.lin.bootdemo.enumcode;


public enum ScheduleState implements BaseEnum{
    // 待排产
    WAITING_SCHEDULE(0,"待排产"),
    // 待签核
    WAITING_SIGN(1,"待签核"),
    // 签核中
    SIGNING(2,"签核中"),
    // 待发布
    WAITING_ISSUE(3,"待发布"),
    // 已发布
    ISSUED(4,"已发布"),
    // 签核成功
    SIGN_SUCCESS(5,"签核成功"),
    // 签核失败
    SIGN_FAILURE(6,"签核失败");

    public final int code;
    public final String desc;

    ScheduleState(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDes() {
        return desc;
    }
}
