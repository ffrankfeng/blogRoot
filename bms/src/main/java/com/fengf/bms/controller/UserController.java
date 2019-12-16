package com.fengf.bms.controller;

import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.ArticleVo;
import com.fengf.bms.pojo.UserQueryVo;
import com.fengf.bms.pojo.Users;
import com.fengf.bms.service.ArticleService;
import com.fengf.bms.service.UserService;
import com.fengf.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping(value = "/blog-manager")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;



    @RequestMapping(value="/flink")
    public String flink(Model model){
        List<String[]> flinks = new ArrayList<>();
        String[] flink = {"博客","http://www.fengf-xy.top"};
        flinks.add(flink);
        model.addAttribute("flinks", flinks);
        return "flink";
    }

    @RequestMapping(value="/delete-user")
    public void deleteIUser(String ids, HttpServletResponse response) throws IOException {

        String [] id = ids.split(",");
        boolean isFinish = true;
        for (String single :id){
//            System.out.println(single);
            if (!userService.deleteUserByID(single)){
                isFinish = false;
                break;
            }
        }
        response.getWriter().write("{\"isFinish\":\""+isFinish+"\"}");
    }
    @RequestMapping(value="/user")
    public String hotuser(UserQueryVo vo, Model model){
        Page<Users> page = userService.selectAllPage(vo);
        model.addAttribute("page", page);
        return "user";
    }

//    @RequestMapping("/item/cat/list")
//    @ResponseBody
//    public List<EasyUITreeNode> getItemCatList(
//            @RequestParam(name="id", defaultValue="0")Long parentId) {
//        //调用服务查询节点列表
//        List<EasyUITreeNode> list = itemCatService.getItemCatlist(parentId);
//        return list;
//
//    }
//    public TbItem getItemById(@PathVariable Long itemId) {
//        TbItem tbItem = itemService.getItemById(itemId);
//        return tbItem;
//    }
}
