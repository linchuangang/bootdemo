/*
 * @(#)AdapterDao.java    Created on 2018-08-31
 * Copyright (c) 2018 Inrevo. All rights reserved.
 */
package com.lin.bootdemo.dao;



import com.inrevo.shared.framework.common.annotation.MyBatisRepository;
import com.inrevo.shared.framework.common.mybatis.MyBatisBasicDao;
import com.lin.bootdemo.model.Adapter;

import java.util.List;

/**
 * 表 adapter 对应的 DAO 接口。
 *
 * @author (Inrevo Code Generator)
 */
@MyBatisRepository
public interface AdapterDao extends MyBatisBasicDao<Adapter> {
    List<Adapter> findByIds(String[] ids);
}
