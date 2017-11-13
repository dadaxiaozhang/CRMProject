package com.lanou.department.service;

import com.lanou.base.BaseDao;
import com.lanou.department.domain.Department;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface DepartmentService extends BaseDao<Department> {
    @Override
    void save(Department department);


    @Override
    List<Department> findAll();


    @Override
    boolean update(Department department);

    @Override
    boolean saveOrUpdate(Department department);
    @Override
    boolean delete(Department department );
    @Override
    Department findById(Serializable id);

    @Override
    List<Department> findAll(String condition, Object... params);

    @Override
    int getTotalrecord(String condition, Object[] params);


}
