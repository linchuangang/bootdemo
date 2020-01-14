/*
 * @(#)AdapterServiceImpl.java    Created on 2018-08-31
 * Copyright (c) 2018 Inrevo. All rights reserved.
 */
package com.lin.bootdemo.service.impl;


import com.lin.bootdemo.dao.AdapterDao;
import com.lin.bootdemo.model.Adapter;
import com.lin.bootdemo.service.AdapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 表 adapter 对应的 Servcie 接口实现。
 *
 * @author (Inrevo Code Generator)
 */
@Service
public class AdapterServiceImpl implements AdapterService {
    @Resource
    private AdapterDao adapterDao;

    @Override
    public void addAdapter(Adapter adapter) {
        adapterDao.insert(adapter);
    }


    @Override
    public Adapter getAdapterById(Integer id) {
        return adapterDao.find(id);
    }

    @Override
    public void removeAdapterById(Integer id) {
        adapterDao.delete(id);
    }

    @Override
    public List<Adapter> listByEntity(Adapter adapter) {
        return adapterDao.findByEntity(adapter);
    }

    @Override
    public void modifyAdapter(Adapter adapter) {
        adapterDao.updateIfPossible(adapter);
    }

    @Override
    public List<Adapter> listByFactoryId(Integer factoryId) {
        Adapter adapter = new Adapter();
        adapter.setFactoryId(factoryId);
        return listByEntity(adapter);
    }

    @Override
    public void updateAgentIdWithList(List<Adapter> adapters, int agentId) {
        adapters.forEach(item -> {
            Adapter adapter = new Adapter();
            adapter.setAgentId(agentId);
            adapter.setId(item.getId());

            modifyAdapter(adapter);
        });
    }

    @Override
    public List<Adapter> listByFactoryIdAndName(Integer factoryId, String name) {
        Adapter adapter = new Adapter();
        adapter.setName(name);
        adapter.setFactoryId(factoryId);
        return listByEntity(adapter);
    }

    @Override
    public List<Adapter> findByIds(String[] ids) {
        return adapterDao.findByIds(ids);
    }

    @Override
    public List<Adapter> findByAgentId(int factoryId, int agentId) {
        Adapter adapter = new Adapter();
        adapter.setFactoryId(factoryId);
        adapter.setAgentId(agentId);
        return adapterDao.findByEntity(adapter);
    }
}
