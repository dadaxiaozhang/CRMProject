package com.lanou.department.service.impl;

import com.lanou.base.PageBean;
import com.lanou.department.dao.DepartmentDao;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;


    @Override
    public boolean delete(Department department) {
        return false;
    }

    @Override
    public List<Department> findAll() {

        return departmentDao.findAll();
    }

    /**
     * @param dept     部门
     * @param pageNum  当前页
     * @param pageSize 每页显示条数
     * @return
     */
    @Override
    public PageBean<Department> findAllDept(Department dept, int pageNum, int pageSize) {

        //获取总记录数
        int totalRecord = departmentDao.getTotalRecord();
        //创建对象
        PageBean<Department> pageBean = new PageBean<Department>(pageNum, pageSize, totalRecord);
        //分页数据
        List<Department> allDept = departmentDao.findAllDept(pageBean.getStartIndex(), pageBean.getPageSize());
        //将获取到的分页数据封装到PageBean中
        pageBean.setData(allDept);
        return pageBean;
    }

    @Override
    public void saveOrUpdate(Department department) {
        departmentDao.saveOrUpdate(department);
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
