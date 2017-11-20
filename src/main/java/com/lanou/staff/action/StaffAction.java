package com.lanou.staff.action;

import com.lanou.base.BaseAction;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.lanou.post.domain.Post;
import com.lanou.post.service.PostService;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.lanou.staff.service.impl.StaffServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public class StaffAction extends BaseAction<Staff, StaffService> {

    private DepartmentService deptService;
    private PostService postService;
    private String deptId;
    private List<Staff> staffList;
    private String staffId;
    private List<Department> departmentList;
    private List<Post> posts;
    private String loginPwd;
    private String loginName;
    private String newPassword;
    private String reNewPassword;
    private Staff staff;

    // 退出登录的时候，需要清空session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    /**
     * 登录
     * @return
     */
    public String login() {
        boolean result = service.login(getModel());
        if (result == true) {
            sessionPut("login", getModel().getLoginName());
            sessionPut("loginPwd", getModel().getLoginPwd());
            return SUCCESS;
        } else {
            addFieldError("msg", "请输入正确的用户名和密码");
            return INPUT;
        }

    }

    /**
     * 查询所有员工
     * @return
     */
    public String findAllStaff() {
        staffList = service.findAll();
        departmentList = deptService.findAll();
        return SUCCESS;
    }

    /**
     * 获取所有部门信息
     * @return
     */
    public String getDept() {
        departmentList = deptService.findAll();
        return SUCCESS;
    }

    /**
     * 保存所有员工信息
     * @return
     */
    public String saveStaff() {
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    public String getPostByDeptId() {
        //根据部门id获取对应的职位
        posts = postService.findPostById(deptId);
        return SUCCESS;
    }

    /**
     * 高级查询员工信息
     * @return
     */
    public String getStaffByCondition() {
        departmentList = deptService.findAll();
        posts = postService.findAll();
        staffList = service.findByConditon(getModel());
        return SUCCESS;
    }

    public String update() {
        departmentList = deptService.findAll();
        return SUCCESS;
    }

    /**
     * 重新登录
     * @return
     */
    public String loginout() {

        session.invalidate();
        return SUCCESS;
    }

    /**
     * 修改密码
     * @return
     */
    public String editPwd() {
        if (newPassword.equals(reNewPassword)) {
            staff = service.findStaffByloginName(session.getAttribute("login").toString());
            staff.setLoginPwd(newPassword);
            service.saveOrUpdate(staff);
        }

        return SUCCESS;
    }



    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setDeptService(DepartmentService deptService) {
        this.deptService = deptService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

}
