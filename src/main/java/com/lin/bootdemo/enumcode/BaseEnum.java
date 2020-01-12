package com.lin.bootdemo.enumcode;

public interface BaseEnum<E extends Enum<?>,T> {
    public Integer getCode();
    public String getDes();
}
