package com.lanou.department.dao;

import com.lanou.base.BaseDao;
import com.lanou.department.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface DepartmentDao extends BaseDao<Department> {

    @Override
    boolean delete(Department department );

    @Override
    List<Department> findAll();

    @Override
    void saveOrUpdate(Department department);

    List<Department> findAllDept(int startIndex, int pageSize);

    int getTotalRecord();
}
