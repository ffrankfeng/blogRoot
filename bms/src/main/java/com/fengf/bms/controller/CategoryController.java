package com.fengf.bms.controller;

import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.AdminQueryVo;
import com.fengf.bms.pojo.Category;
import com.fengf.bms.service.CategoryService;
import com.fengf.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/blog-manager")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value="/category")
    public String hotuser(Model model){
        List<Category> page = categoryService.selectAllPage();
        model.addAttribute("page", page);
        return "category";
    }
    @RequestMapping(value="/update-category.html")
    public String updateCategory(int categoryId,Model model){
        Category category = categoryService.selectCategoryByCategoryId(categoryId);
        model.addAttribute("category",category);
        return "update-category";
    }
    @RequestMapping(value="/save-update-category")
    public String SaveUpdateCategory(int categoryId,int categoryCount,String categoryName ,String categoryAlias,int categoryKeywords){
//        System.out.println("save update");
        boolean category = categoryService.updateCategory(categoryId,categoryName,categoryAlias,categoryKeywords,categoryCount);
        return "redirect:/blog-manager/category";
    }
    @RequestMapping(value="/delete-category")
    public void deleteCategory(int id, HttpServletResponse response) throws IOException {
        boolean isFinish = categoryService.deleteCategoryById(id);
        response.getWriter().write("{\"isFinish\":\""+isFinish+"\"}");
    }
    @RequestMapping(value="/add-category")
    public String addCategory(String categoryName ,String categoryAlias,String categoryKeywords ,Model model){
//        System.out.println(categoryKeywords);
        boolean isFinish = categoryService.addCategory(categoryName , categoryAlias, categoryKeywords);
        return "redirect:/blog-manager/category";
    }
}
