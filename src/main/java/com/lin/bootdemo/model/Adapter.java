/* 
 * @(#)Adapter.java    Created on 2018-08-31
 * Copyright (c) 2018 Inrevo. All rights reserved.
 */
package com.lin.bootdemo.model;



import java.util.Date;
import java.util.List;

/**
 * 表 adapter 对应的实体类。
 *
 * @author (Inrevo Code Generator)
 */
public class Adapter extends IntegerIdEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer factoryId;

    private String version;

    private Date createTime;


    private Integer pingSuccessCount;

    private Integer availableCount;

    private Integer allDeviceCount;

    private Integer agentId;

    private String status;

    private String lastStartUpDate;

    private String agentName;

    public Adapter() {
    }

    public String getLastStartUpDate() {
        return lastStartUpDate;
    }

    public void setLastStartUpDate(String lastStartUpDate) {
        this.lastStartUpDate = lastStartUpDate;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getAllDeviceCount() {
        return allDeviceCount;
    }

    public void setAllDeviceCount(Integer allDeviceCount) {
        this.allDeviceCount = allDeviceCount;
    }

    public Integer getPingSuccessCount() {
        return pingSuccessCount;
    }

    public void setPingSuccessCount(Integer pingSuccessCount) {
        this.pingSuccessCount = pingSuccessCount;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
}
