package com.lanou.department.dao.impl;

import com.lanou.department.dao.DepartmentDao;
import com.lanou.department.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    @Override
    public void save(Department department) {
        getHibernateTemplate().save(department);
    }

    @Override
    public boolean delete(Department department) {
        return false;
    }

    @Override
    public List<Department> findAll() {
        List<Department> list = (List<Department>) getHibernateTemplate().find("from Department T_DEPT");
        return list;
    }

    @Override
    public Department findById(Serializable id) {
        return null;
    }


    @Override
    public boolean update(Department department) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Department department) {
        if (department.getDeptId().isEmpty()) {
            getHibernateTemplate().save(department);
        } else {
            getHibernateTemplate().saveOrUpdate(department);
        }
        return true;
    }

    @Override
    public List<Department> findAll(String condition, Object... params) {
        return null;
    }


    @Override
    public int getTotalrecord(String condition, Object[] params) {
        getHibernateTemplate().find(condition, params);
        return 0;
    }
}
