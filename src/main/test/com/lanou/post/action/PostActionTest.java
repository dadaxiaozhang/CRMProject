package com.lanou.post.action;

import com.lanou.post.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/13.
 */
public class PostActionTest {
    private BeanFactory beanFactory;
    private PostService postService;

    @Before
    public void init() {
        beanFactory = new ClassPathXmlApplicationContext("classpath*:spring/*.xml");

        postService = (PostService) beanFactory.getBean("postService");
    }

    @Test
    public void test(){
//        postService.save(new Post("网络部"));
        System.out.println(postService.findAll());
    }


}