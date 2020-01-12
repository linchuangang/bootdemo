package com.lin.bootdemo.utils;


import com.lin.bootdemo.enumcode.BaseEnum;

/**
 * @author gd
 * @Date 2019/11/27 21:25
 * @Description enum utils
 */
public class CodeEnumUtils
{
    public static <E extends Enum<?> & BaseEnum> E codeOf(Class<E> enumClass, int code)
    {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e:enumConstants)
        {
            if (e.getCode()==code)
            {
                return e;
            }
        }
        return null;
    }
}
