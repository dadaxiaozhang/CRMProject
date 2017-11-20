package com.lanou.post.action;

import com.lanou.base.BaseAction;
import com.lanou.base.PageBean;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.lanou.post.domain.Post;
import com.lanou.post.service.PostService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */

public class PostAction extends BaseAction<Post, PostService> {

    private DepartmentService deptService;
    private List<Department> deptList;
    private List<Post> allList;
    private String deptId;


    /**
     * 查询所有职务信息
     * @return
     */
    public String findAllPost() {
        allList = service.findAll();
        return SUCCESS;

    }

    /**
     * 添加职务
     * @return
     */
    public String addPost() {
        deptList = deptService.findAll();
        return SUCCESS;
    }


    public String getPostByDeptId(){
        allList = service.findPostById(deptId);
        return SUCCESS;
    }

    /**
     * 保存部门信息
     * @return
     */
    public String savePost() {

        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    /**
     * 修改部门信息
     * @return
     */
    public String update() {
        deptList = deptService.findAll();
        return SUCCESS;
    }

    public List<Post> getAllList() {
        return allList;
    }

    public void setAllList(List<Post> allList) {
        this.allList = allList;
    }

    public List<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setDeptService(DepartmentService deptService) {
        this.deptService = deptService;
    }
}
