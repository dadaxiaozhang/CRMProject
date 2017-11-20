package com.lanou.staff.dao.impl;

import com.lanou.post.domain.Post;
import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.domain.Staff;
import com.lanou.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    @Override
    public boolean login(Staff staff) {
        staff.setLoginPwd(MD5Utils.md5(staff.getLoginPwd()));
        List<Staff> staffs = getHibernateTemplate().findByExample(staff);

        if (staffs != null && staffs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Staff staff) {
        staff.setStaffId(1);
        getHibernateTemplate().delete(staff);
        return true;
    }

    @Override
    public List<Staff> findAll() {
        List<Staff> list = (List<Staff>) getHibernateTemplate().find("from Staff T_STAFF");
        return list;
    }

    public Staff findStaffByloginName(String loginName){
        List<Staff> list = (List<Staff>) getHibernateTemplate().find("from Staff where loginName = ?", loginName);

        return list.get(0);
    }

    @Override
    public void saveOrUpdate(Staff staff) {
        staff.setLoginPwd(MD5Utils.md5(staff.getLoginPwd()));
        if (staff.getStaffId()==0) {
            getHibernateTemplate().save(staff);
        } else {
            getHibernateTemplate().saveOrUpdate(staff);
        }

    }

    @Override
    public List<Staff> findByConditon(Staff staff) {
        List<Staff> list = new ArrayList<Staff>();
        boolean deptId = StringUtils.isBlank(staff.getPost().getDept().getDeptId());
        boolean postId = StringUtils.isBlank(staff.getPost().getPostId());
        boolean staffName = StringUtils.isBlank(staff.getStaffName());
        //根据部门查询
        if (!deptId && postId && staffName) {
            List<Post> posts = (List<Post>) getHibernateTemplate().find("from Post where dept.deptId = ?", staff.getPost().getDept().getDeptId());
            for (int i = 0; i < posts.size(); i++) {
                List<Staff> staffs = (List<Staff>) getHibernateTemplate().find("from Staff where post.postId = ?", posts.get(i).getPostId());
                list.addAll(staffs);
            }
            return list;
            //根据职务查询
        } else if (!postId && staffName) {
            return (List<Staff>) getHibernateTemplate().find("from Staff where post.postId = ?", staff.getPost().getPostId());

            //根据名字查询
        } else if (deptId && !staffName) {
            return(List<Staff>) getHibernateTemplate().find("from Staff where staffName like ?", "%" + staff.getStaffName() + "%");

            //根据职务和名字查询

        } else if (!postId && !staffName) {
            return (List<Staff>) getHibernateTemplate().find("from Staff where post.postId = ? and staffName like ?", staff.getPost().getPostId(), "%" + staff.getStaffName() + "%");

            //根据部门和名字查询
        } else if (!deptId && postId && !staffName) {
            List<Post> posts = (List<Post>) getHibernateTemplate().find("from Post where dept.deptId = ?", staff.getPost().getDept().getDeptId());
            for (int i = 0; i < posts.size(); i++) {
                List<Staff> staffs = (List<Staff>) getHibernateTemplate().find("from Staff where post.postId = ? and staffName like ?", posts.get(i).getPostId(),"%" + staff.getStaffName() + "%");
                list.addAll(staffs);
            }
            return list;
        } else {
            return (List<Staff>) getHibernateTemplate().find("from Staff");

        }
    }

}
