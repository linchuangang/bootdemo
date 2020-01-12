package com.lin.bootdemo.enumcode;

/**
 * @author gd
 * @Date 2019/12/10 14:53
 * @Description holiday
 */
public enum Holiday implements BaseEnum {

    NONE(0,"非节假日"),
    NEW_YEAR(1,"元旦节"),
    SPRING(2,"春节"),
    TOMB_SWEEPING(3,"清明节"),
    LABOUR_DAY(4,"劳动节"),
    DRAGON_BOAT(5,"端午节"),
    NATIONAL_DAY(6,"国庆节"),
    MID_AUTUMN(7,"中秋节");

    private Integer code;
    private String des;

    Holiday(Integer code, String des) {
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
