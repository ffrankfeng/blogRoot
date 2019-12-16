package com.fengf.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatroomController {

    //首页
    @RequestMapping(value="/forward.html")
    public String forward(Model model){
        return "forward";
    }
}
