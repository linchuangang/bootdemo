package com.lin.bootdemo.enumcode;

/**
 * Created by Administrator on 2019/4/30.
 */
public enum WorkRegion implements BaseEnum{
    ML(0,"大陆"),
    HK(1,"香港");

    public final int code;
    public final String des;

    WorkRegion(int code, String des) {
        this.code = code;
        this.des = des;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDes() {
        return des;
    }
}
