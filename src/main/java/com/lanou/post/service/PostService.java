package com.lanou.post.service;

import com.lanou.base.BaseDao;
import com.lanou.post.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostService extends BaseDao<Post> {
    @Override
    void save(Post post);


    @Override
    List<Post> findAll();


    @Override
    boolean update(Post post);

    @Override
    boolean saveOrUpdate(Post post);
}
