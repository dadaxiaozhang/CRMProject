package com.lanou.department.action;

import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/13.
 */
public class DepartmentActionTest {

    private BeanFactory beanFactory;
    private DepartmentService departmentService;


    @Before
    public void init() {
        beanFactory = new ClassPathXmlApplicationContext("classpath*:spring/*.xml");

        departmentService= (DepartmentService) beanFactory.getBean("departmentService");
    }
    @Test
    public void test(){
        System.out.println(departmentService.findAll());

    }
    @Test
    public void save(){
        departmentService.saveOrUpdate(new Department("按摩部1"));
    }

}