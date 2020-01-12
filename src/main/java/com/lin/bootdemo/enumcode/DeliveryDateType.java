package com.lin.bootdemo.enumcode;

public enum DeliveryDateType {

    /**
     *  交付日期
     */
    DELIVERY(0),
    /**
     *  非交付日期
     */
    NON_DELIVERY(1),
    /**
     *  节假日交货
     */
    HOLIDAY_DELIVERY(2),
    /**
     *  节假日交货
     */
    HOLIDAY_NON_DELIVERY(3);

    private int code;

    DeliveryDateType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
