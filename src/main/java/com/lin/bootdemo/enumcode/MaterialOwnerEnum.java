package com.lin.bootdemo.enumcode;

/**
 * @Author: wubo
 * @Date: 2019/11/30 15:30
 * @Description:
 */
public enum MaterialOwnerEnum {
    //原材料
    RAW_MATERIAL("原材料"),
    //外购件
    PURCHASED_PART("外购件"),
    //包材
    COVER_MATERIAL("包材"),
    //裁切
    TRIM("裁切"),
    //委外交货
    OUTSOURCING_DELIVERY("委外交货"),
    //委外素材
    OUTSOURCING_MATERIAL("委外素材");


    public String value;

    MaterialOwnerEnum(String value) {
        this.value = value;
    }
}
