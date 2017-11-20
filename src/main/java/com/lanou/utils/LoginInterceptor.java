package com.lanou.utils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/11/18.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object loginName = ServletActionContext.getRequest().getSession().getAttribute("login");
        if (loginName == null){

            return "login";
        }
        return actionInvocation.invoke();
    }
}
