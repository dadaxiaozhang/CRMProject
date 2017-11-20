package com.lanou.department.action;

import com.lanou.base.BaseAction;
import com.lanou.base.PageBean;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */

public class DepartmentAction extends BaseAction<Department,DepartmentService> {

    //查询出的部门信息
    private List<Department> allList;
    private List<Department> listByPage;

    /**
     * 查询所有部门信息
     * @return 所有部门信息
     */
    public String findAllDepartment(){
        allList = service.findAll();
        return SUCCESS;
    }

    /**
     * 保存部门信息 根据员工信息中有无staffId判断添加或修改
     * @return
     */
    public String saveDept(){
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    //分页 pageNum, pageSize 并设置默认值
    private int pageNum = 1;

    public void setPageNum(int pageNum
    ) {
        this.pageNum = pageNum;
    }

    private int pageSize = 4;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 部门分页
     * @return
     */
    public String findAllDept() {
        PageBean<Department> allDept = service.findAllDept(getModel(), pageNum, pageSize);
        ActionContext.getContext().put("pageBean",allDept);
        return "success";
    }


    public List<Department> getAllList() {
        return allList;
    }

    public void setAllList(List<Department> allList) {
        this.allList = allList;
    }

    public List<Department> getListByPage() {
        return listByPage;
    }

    public void setListByPage(List<Department> listByPage) {
        this.listByPage = listByPage;
    }

}
