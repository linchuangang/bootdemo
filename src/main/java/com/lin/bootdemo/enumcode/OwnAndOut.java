package com.lin.bootdemo.enumcode;

/**
 * @author gd
 * @Date 2019/5/21 11:21
 * @Description 自制与委外
 */
public enum  OwnAndOut {
    OWN(0,"自製"),
    OUT(1,"委外");
    public int code;
    private String desc;
    OwnAndOut(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getDesc(int code)
    {
        OwnAndOut[] values = OwnAndOut.values();
        for(OwnAndOut value:values)
        {
            if(value.code==code)
            {
                return value.desc;
            }
        }
        return null;
    }

    public static int getCode(String desc)
    {
        OwnAndOut[] values = OwnAndOut.values();
        for(OwnAndOut value:values)
        {
            if(value.desc.equals(desc))
            {
                return value.code;
            }
        }
        if("是".equals(desc))
        {
            return OWN.code;
        }
        if("否".equals(desc))
        {
            return OUT.code;
        }
        return OWN.code;
    }
}
