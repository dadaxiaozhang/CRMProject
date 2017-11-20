package com.lanou.staff.dao;

import com.lanou.base.BaseDao;
import com.lanou.staff.domain.Staff;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public interface StaffDao extends BaseDao<Staff> {

    boolean login(Staff staff);


    @Override
    boolean delete(Staff staff);

    @Override
    List<Staff> findAll();

    @Override
    void saveOrUpdate(Staff staff);

    List<Staff> findByConditon(Staff staff);

    Staff findStaffByloginName(String loginName);

}
