package com.lanou.post.dao;

import com.lanou.base.BaseDao;
import com.lanou.post.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostDao extends BaseDao<Post> {
    List<Post> findAll();

    void save(Post post);

    @Override
    boolean update(Post post);

    @Override
    boolean saveOrUpdate(Post post);
}
