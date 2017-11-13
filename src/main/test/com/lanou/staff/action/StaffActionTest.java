package com.lanou.staff.action;

import com.lanou.staff.service.StaffService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/13.
 */
public class StaffActionTest {
    private BeanFactory beanFactory;
    private StaffService staffService;

    @Before
    public void init() {
        beanFactory = new ClassPathXmlApplicationContext("classpath*:spring/spring-config.xml");

        staffService = (StaffService) beanFactory.getBean("staffService");
    }

    @Test
    public void test(){

        System.out.println(staffService.findAll());
    }



}