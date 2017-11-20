package com.lanou.post.service.impl;

import com.lanou.post.dao.PostDao;
import com.lanou.post.domain.Post;
import com.lanou.post.service.PostService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    @Override
    public List<Post> findAll() {
       return postDao.findAll();

    }

    @Override
    public List<Post> findPostById(String deptId) {
        return postDao.findPostById(deptId);
    }

    @Override
    public void saveOrUpdate(Post post) {
        postDao.saveOrUpdate(post);

    }

    @Override
    public boolean delete(Post post) {
        return false;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
