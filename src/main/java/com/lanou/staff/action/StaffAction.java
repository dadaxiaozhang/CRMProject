package com.lanou.staff.action;

import com.lanou.base.BaseAction;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.lanou.staff.service.impl.StaffServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffServiceImpl> {

    private String loginName, loginPwd;
    @Resource
    private StaffService staffService;

    private List<Staff> allList;
    private String staffId;


    public String login() {
        boolean result = staffService.login(getModel());
        if (result == true) {
            sessionPut("login", getModel().getLoginName());
            return SUCCESS;
        } else {
            addFieldError("msg", "请输入正确的用户名和密码");
            return INPUT;
        }

    }


    public String findAllStaff() {
        allList = staffService.findAll();
        System.out.println(allList);
        return SUCCESS;
    }





    public String saveOrUpdate() {
        List<Staff> list = staffService.findAll();
        staffService.saveOrUpdate(getModel());
        return SUCCESS;

    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }


    public List<Staff> getAllList() {
        return allList;
    }

    public void setAllList(List<Staff> allList) {
        this.allList = allList;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }
}
