package com.lanou.department.service.impl;

import com.lanou.department.dao.DepartmentDao;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentDao departmentDao;

    @Override
    public void save(Department department) {
        departmentDao.saveOrUpdate(department);
    }

    @Override
    public boolean delete(Department department) {
        return false;
    }

    @Override
    public List<Department> findAll() {

        return departmentDao.findAll();
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
        departmentDao.saveOrUpdate(department);
        return true;

    }

    @Override
    public List<Department> findAll(String condition, Object... params) {
        return null;
    }

    @Override
    public int getTotalrecord(String condition, Object[] params) {
        return 0;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
