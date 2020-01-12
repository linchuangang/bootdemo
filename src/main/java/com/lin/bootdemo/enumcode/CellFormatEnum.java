package com.lin.bootdemo.enumcode;

public enum CellFormatEnum
{
    HEAD("head"),
    PERCENT("percent"),
    DECIMAL("decimal"),
    DATE("date"),
    DEFAULT("default");

    private String value;

    CellFormatEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
