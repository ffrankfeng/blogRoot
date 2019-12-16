package com.fengf.bms.controller;

import com.fengf.bms.filter.MyShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/test")
public class PageController {

    @RequestMapping(value="/index.html",method = RequestMethod.GET)
    String index(){
        return "/test/index";
    }
    @RequestMapping(value="/error.html",method = RequestMethod.GET)
    String error(){
        return "/test/error";
    }
    @RequestMapping(value="/do{path}.html")
    String page(@PathVariable(value = "path")String path, Model model){
        model.addAttribute("path",path);
        return "/test/test";
    }
    @Autowired
    private MyShiroFilterFactoryBean myShiroFilterFactoryBean;
    @RequestMapping(value="/update.html")
    String update(){
        myShiroFilterFactoryBean.update();
        return "/test/index";
    }
}
