package com.fengf.bms.controller;

import com.fengf.bms.pojo.Articlecomment;
import com.fengf.bms.pojo.CommentQueryVo;
import com.fengf.bms.service.CommentService;
import com.fengf.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/blog-manager")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "/comment",method = RequestMethod.GET)
    public String articlesList(CommentQueryVo vo, Model model){
        Page<Articlecomment> page = commentService.selectAllPage(vo);
        model.addAttribute("page", page);
        return "comment";
    }

    @RequestMapping(value = "/delete-comment")
    public void delete(String ids, HttpServletResponse response) throws IOException {

//        System.out.println("删除"+ids);
        String [] id = ids.split(",");
        boolean isFinish = true;
        for (String single :id){
//            System.out.println(single);
            if (!commentService.deleteCommentByID(single)){
                isFinish = false;
                break;
            }
        }
        response.getWriter().write("{\"isFinish\":\""+isFinish+"\"}");
    }
}
