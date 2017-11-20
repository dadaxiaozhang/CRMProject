package com.lanou.department.service;

import com.lanou.base.BaseDao;
import com.lanou.base.PageBean;
import com.lanou.department.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface DepartmentService extends BaseDao<Department> {

    @Override
    List<Department> findAll();

    @Override
    void saveOrUpdate(Department department);
    @Override
    boolean delete(Department department );

    PageBean<Department> findAllDept(Department dept, int pageNum, int pageSize);
}
