package com.fengf.bms.controller;

import com.fengf.bms.pojo.*;
import com.fengf.bms.service.ArticleService;
import com.fengf.bms.service.UserService;
import com.fengf.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="/blog-manager")
public class ArticlesController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;


    @RequestMapping(value="/index.html")
    public String index( Model model){
        ArticleVo articleVo = articleService.getArticleInfo();
        model.addAttribute("articleVo", articleVo);
        return "index";
    }
    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public String articlesList(ArticleQueryVo vo, Model model){
        Page<Articles> page = articleService.selectAllPage(vo);
        model.addAttribute("page", page);
        return "article";
    }
    @RequestMapping(value="/hotuser")
    public String hotuser(UserQueryVo vo, Model model){
        Page<Users>  page = userService.selectAllPage(vo);
        model.addAttribute("page", page);
        return "hotuser";
    }

    @RequestMapping(value = "/delete-article")
    public void delete(String ids, HttpServletResponse response) throws IOException {

//        System.out.println("删除"+ids);
        String [] id = ids.split(",");
        boolean isFinish = true;
        for (String single :id){
//            System.out.println(single);
             if (!articleService.deleteArticleByID(single)){
                 isFinish = false;
                 break;
             }
        }
        response.getWriter().write("{\"isFinish\":\""+isFinish+"\"}");
    }
}
