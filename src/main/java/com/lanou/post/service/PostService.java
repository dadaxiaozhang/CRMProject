package com.lanou.post.service;

import com.lanou.base.BaseDao;
import com.lanou.post.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostService extends BaseDao<Post> {

    @Override
    List<Post> findAll();

    List<Post> findPostById(String deptId);

    @Override
    void saveOrUpdate(Post post);
}
