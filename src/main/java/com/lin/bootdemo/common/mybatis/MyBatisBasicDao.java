package com.lin.bootdemo.common.mybatis;


import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * MyBatis 基础 DAO 接口。
 *
 * @author akuma
 */
@Repository
public interface MyBatisBasicDao<T> {

    <PK> T find(PK id);

    List<T> findAll();

    @SuppressWarnings("unchecked")
    <PK> List<T> findByIds(PK... ids);

    List<T> findByEntity(T entity);


    List<T> findByParam(Object param);


    @SuppressWarnings("unchecked")
    @MapKey("id")
    <PK> Map<PK, T> findMap(PK... ids);

    void insert(T entity);

    void update(T entity);

    void updateIfPossible(T entity);

    @SuppressWarnings("unchecked")
    <PK> void delete(PK... ids);

}
