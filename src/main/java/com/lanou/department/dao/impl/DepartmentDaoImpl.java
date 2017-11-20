package com.lanou.department.dao.impl;

import com.lanou.base.PageHibernateCallback;
import com.lanou.department.dao.DepartmentDao;
import com.lanou.department.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    @Override
    public boolean delete(Department department) {
        return false;
    }

    @Override
    public List<Department> findAll() {
        List<Department> list = (List<Department>) getHibernateTemplate().find("from Department T_DEPT");
        return list;
    }

    @Override
    public void saveOrUpdate(Department department) {
        if (department.getDeptId().isEmpty()) {
                getHibernateTemplate().save(department);
        } else {
            getHibernateTemplate().saveOrUpdate(department);
        }
    }

    /**
     *
     * @param startIndex 开始索引
     * @param pageSize  每页显示记录数
     * @return
     */
    @Override
    public List<Department> findAllDept(int startIndex, int pageSize) {
        String hql = "from Department where 1 = 1";
        return getHibernateTemplate().execute(new PageHibernateCallback<Department>(hql,startIndex,pageSize));

    }

    /**
     *获取总的数据数
     * @return
     */
    @Override
    public int getTotalRecord() {

        String hql = "select count(c) from Department c where 1=1";
        List<Long> find = (List<Long>) getHibernateTemplate().find(hql);
        if (find != null){
            return find.get(0).intValue();
        }
        return 0;
    }

}
