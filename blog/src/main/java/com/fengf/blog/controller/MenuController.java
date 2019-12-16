package com.fengf.blog.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class MenuController {
    @RequestMapping("list.html")
    public String list(){
        return "/test/menu_list";
    }

    @RequestMapping("edit.html")
    @RequiresPermissions("menu:edit")
    public String edit(){
        return "/test/menu_edit";
    }
}
