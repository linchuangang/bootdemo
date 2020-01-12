package com.lin.bootdemo.enumcode;

import java.util.Objects;

/**
 * Created by Administrator on 2019/4/30.
 */
public enum WorkDayTypeEnum {
    MOULDING(0, "成型工作日"),
    ALL(1, "都工作"),
    REST(2, "休息"),
    NO_MOULDING(3,"非成型工作日");

    public final int code;
    public final String desc;

    WorkDayTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static WorkDayTypeEnum getByCode(int code)
    {
        WorkDayTypeEnum[] values = values();
        for (WorkDayTypeEnum typeEnum:values)
        {
            if (Objects.equals(code,typeEnum.code))
            {
                return typeEnum;
            }
        }
        return null;
    }
}
