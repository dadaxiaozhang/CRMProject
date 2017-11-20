package com.lanou.staff.service.impl;

import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    @Override
    public boolean login(Staff staff) {
        return staffDao.login(staff);
    }

    @Override
    public boolean delete(Staff staff) {
        staffDao.delete(staff);
        return true;
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public List<Staff> findByConditon(Staff staff) {
        return staffDao.findByConditon(staff);
    }

    public Staff findStaffByloginName(String loginName){
        return staffDao.findStaffByloginName(loginName);
    }

    @Override
    public void saveOrUpdate(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
