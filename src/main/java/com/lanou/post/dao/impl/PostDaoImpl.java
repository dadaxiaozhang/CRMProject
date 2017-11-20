package com.lanou.post.dao.impl;

import com.lanou.post.dao.PostDao;
import com.lanou.post.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public List<Post> findAll() {
        List<Post> list = (List<Post>) getHibernateTemplate().find("from Post T_POST");

        return list;
    }

    @Override
    public List<Post> findPostById(String deptId) {
        String sql="from Post T_Post where dept.id = ?";
        List<Post> list = (List<Post>) getHibernateTemplate().find(sql, deptId);

        return list;
    }

    @Override
    public void saveOrUpdate(Post post) {

        if (post.getPostId().isEmpty()) {
            getHibernateTemplate().save(post);
        } else {
            getHibernateTemplate().saveOrUpdate(post);
        }

    }

    @Override
    public boolean delete(Post post) {
        return false;
    }

}
