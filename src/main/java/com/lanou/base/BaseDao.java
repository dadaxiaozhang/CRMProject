package com.lanou.base;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface BaseDao<T> {

    /**
     * 删除
     */
    boolean delete(T t);

    /**
     * 添加或修改
     * @param t
     */

    void saveOrUpdate(T t);

    /**
     * 查询所有
     */
    List<T> findAll();

//
//    T find(String loginName, String loginPwd);

    /**
     * 查询总记录数
     * @param condition
     * @param params
     * @return
     */
//    int getTotalRecord();
//    int getTotalrecord(String condition, Object[] params);

    /**
     * 获取到数据  带分页的参数的
     * @param condition
     * @param params
     * @param startIndex
     * @param pageSize
     * @return
     */
//    List<T> findAll(String condition, Object[] params,int startIndex,int pageSize);
}
