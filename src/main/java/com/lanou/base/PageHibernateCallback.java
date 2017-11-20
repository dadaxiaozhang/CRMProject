package com.lanou.base;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

    private String hql;   //hql语句
    private int startIndex;  //开始索引
    private int pageSize;  // 每页显示的数目是


    public PageHibernateCallback(String hql, int startIndex, int pageSize) {
        this.hql = hql;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        //1. 通过hql语句获取query对象
        Query queryObject = session.createQuery(hql);
        //2.条件设置

        //3.分页
        queryObject.setFirstResult(startIndex);
        queryObject.setMaxResults(pageSize);
        //4.页面查询
        return queryObject.list();
    }
}
