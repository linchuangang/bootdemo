package com.lin.bootdemo.model;

import java.util.Date;

/**
 * ID 为 Long 类型的 Entity 基类。
 *
 * @author Jeesea
 */
public abstract class IntegerIdEntity {

    private static final long serialVersionUID = 1;

    private Integer id;
    private Date modifyTime;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
