package com.fengf.blog.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.tomcat.util.net.AprEndpoint.Handler;
//import org.apache.tomcat.util.net.SocketStatus;
//import org.apache.tomcat.util.net.SocketWrapper;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fengf.blog.pojo.Users;

public class GlobalExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("******************************************");
		ex.printStackTrace();
		Users user = (Users) request.getSession().getAttribute("current_user");
		if(user != null){
			request.getSession().invalidate();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("404");
		return modelAndView;
	}

}
