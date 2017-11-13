package com.lanou.post.service.impl;

import com.lanou.post.domain.Post;
import com.lanou.post.service.PostService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostServiceImpl implements PostService {

    @Override
    public void save(Post post) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public List<Post> findAll(String condition, Object... params) {
        return null;
    }

    @Override
    public int getTotalrecord(String condition, Object[] params) {
        return 0;
    }

    @Override
    public boolean update(Post post) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Post post) {
        return false;
    }

    @Override
    public boolean delete(Post post) {
        return false;
    }

    @Override
    public Post findById(Serializable id) {
        return null;
    }
}
