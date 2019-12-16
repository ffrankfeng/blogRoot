package com.fengf.bms.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyShiroFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object object) throws Exception {
//        System.out.println("filter");
        Subject subject = getSubject(servletRequest,servletResponse);
        String[] roles = (String[])object;
        if (roles ==null || roles.length ==0){
            return true;
        }
        for (String role :roles){
            if (subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
