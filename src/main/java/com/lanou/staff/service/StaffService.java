package com.lanou.staff.service;

import com.lanou.base.BaseDao;
import com.lanou.staff.domain.Staff;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService extends BaseDao<Staff> {

    boolean login(Staff staff);

    Staff findStaffByloginName(String loginName);

    @Override
    boolean delete(Staff staff);

    @Override
    List<Staff> findAll();

    List<Staff> findByConditon(Staff staff);

    @Override
    void saveOrUpdate(Staff staff);


}
