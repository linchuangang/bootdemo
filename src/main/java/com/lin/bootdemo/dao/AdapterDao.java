/*
 * @(#)AdapterDao.java    Created on 2018-08-31
 * Copyright (c) 2018 Inrevo. All rights reserved.
 */
package com.lin.bootdemo.dao;



import com.lin.bootdemo.common.mybatis.MyBatisBasicDao;
import com.lin.bootdemo.model.Adapter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 表 adapter 对应的 DAO 接口。
 *
 * @author (Inrevo Code Generator)
 */
@Repository
public interface AdapterDao extends MyBatisBasicDao<Adapter> {
    List<Adapter> findByIds(String[] ids);
}
