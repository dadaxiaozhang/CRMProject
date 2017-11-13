package com.lanou.department.action;

import com.lanou.base.BaseAction;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.lanou.department.service.impl.DepartmentServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Controller("deptAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department,DepartmentServiceImpl> {

    private Department department = getModel();

    private List<Department> allList;

    @Resource
    private DepartmentService departmentService;

    public String findAllDepartment(){
        allList = departmentService.findAll();
        return SUCCESS;
    }


    public String addDept(){
        departmentService.save(department);

        return SUCCESS;
    }

    public String update(){
        departmentService.saveOrUpdate(department);
        return SUCCESS;
    }




    public List<Department> getAllList() {
        return allList;
    }

    public void setAllList(List<Department> allList) {
        this.allList = allList;
    }

}
