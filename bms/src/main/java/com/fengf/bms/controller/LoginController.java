package com.fengf.bms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class LoginController {
//    @RequestMapping(value="/gologin.html",method = RequestMethod.GET)
//    public String gologin(){
//        System.out.println("/test/gologin.html");
//        return "/test/login";
//    }
//    @RequestMapping(value="/logout.html",method = RequestMethod.GET)
//    public String logout(){
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//        return "/test/login";
//    }
//    @RequestMapping(value="/login.html",method = RequestMethod.POST)
//    public String login(String username, String password, HttpServletRequest req){
//        System.out.println("login.html");
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        try {
//            subject.login(token);
//            return  "redirect:/test/index.html";
//        }catch (AuthenticationException e){
//            e.printStackTrace();
//            req.setAttribute("error","用户名或密码错误");
//            return "/test/login";
//        }
//    }
}
