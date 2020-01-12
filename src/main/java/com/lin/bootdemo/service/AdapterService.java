/*
 * @(#)AdapterService.java    Created on 2018-08-31
 * Copyright (c) 2018 Inrevo. All rights reserved.
 */
package com.lin.bootdemo.service;



import com.lin.bootdemo.model.Adapter;

import java.util.List;

/**
 * 表 adapter 对应的 Servcie 接口。
 *
 * @author (Inrevo Code Generator)
 */
public interface AdapterService {
    /**
     * 增加 Adapter
     */
    void addAdapter(Adapter adapter);


    /**
     * 通过ID查找 Adapter
     */
    Adapter getAdapterById(Integer id);

    /**
     * 通过ID删除对象 Adapter
     */
    void removeAdapterById(Integer id);

    /**
     * 通过对象查找 List<Adapter>
     */
    List<Adapter> listByEntity(Adapter adapter);

    /**
     * 更新 Adapter
     */
    void modifyAdapter(Adapter adapter);

    /**
     * 通过factoryId查找 List<Adapter>
     */
    List<Adapter> listByFactoryId(Integer factoryId);

    /**
     * 更新agentId
     *
     * @param adapters ——要更新的列表
     * @param agentId  ——adapter对应的agentId
     */
    void updateAgentIdWithList(List<Adapter> adapters, int agentId);

    List<Adapter> listByFactoryIdAndName(Integer factoryId, String name);

    List<Adapter> findByIds(String[] ids);

    List<Adapter> findByAgentId(int factoryId, int agentId);
}
