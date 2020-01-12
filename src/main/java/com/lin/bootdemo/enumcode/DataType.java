package com.lin.bootdemo.enumcode;

public enum DataType implements BaseEnum {
    DAY(0,"天对应数据"),
    WEEK(1,"周对应数据");


    private final int code;
    private final String desc;

    DataType(int code, String desc) {
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
