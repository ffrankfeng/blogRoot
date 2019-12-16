package com.fengf.bms.controller;

import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.AdminQueryVo;
import com.fengf.bms.pojo.UserQueryVo;
import com.fengf.bms.pojo.Users;
import com.fengf.bms.service.AdminService;
import com.fengf.common.utils.Page;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;



    @RequestMapping(value="/blog-manager/manage-user")
    public String hotuser(AdminQueryVo vo, Model model){
        Page<Admin> page = adminService.selectAllPage(vo);
        model.addAttribute("page", page);
        return "manage-user";
    }
    @RequestMapping(value = {"/bms","/bms/login.html"},method = RequestMethod.GET)
    public String login(){

        return "login";
    }
    @RequestMapping(value = "/logout.html")
    public String logout(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        request.getSession().invalidate();
        return "redirect:/bms/login.html";
    }
    @RequestMapping(value = "/userlogin",method = RequestMethod.POST)
    public String login( @RequestParam(name="username", defaultValue="0")String userName ,
                         @RequestParam(name="userpwd", defaultValue="0")String userPwd ,
                         HttpServletRequest request){
        String ip = request.getRemoteAddr();
        Admin USER = adminService.login(userName,userPwd,ip);
        if(USER != null){
            HttpSession session = request.getSession();
            session.setAttribute("USER", USER);
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName,userPwd);
            try {
                subject.login(token);

            }catch (AuthenticationException e){
                e.printStackTrace();

                return "login";
            }
//            System.out.println("yes");
            return "redirect:/blog-manager/index.html";
        }
        else
            return "login";
    }

}
