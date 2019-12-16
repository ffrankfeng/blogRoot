package com.fengf.bms.service;

import com.fengf.bms.mapper.CategoryMapper;
import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.Category;
import com.fengf.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> selectAllPage() {
        return categoryMapper.selectAllCategory();
    }

    @Override
    public boolean addCategory(String categoryName, String categoryAlias, String categoryKeywords) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setCategoryAnothername(categoryAlias);
        category.setCategoryNum(Integer.parseInt(categoryKeywords));
        category.setCategoryCount(0);
        int insert = categoryMapper.insert(category);
        if (insert> 0)
            return true;
        return false;
    }

    @Override
    public Category selectCategoryByCategoryId(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public boolean updateCategory(int categoryId, String categoryName, String categoryAlias, int categoryKeywords,int categoryCount) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryCount(categoryCount);
        category.setCategoryNum(categoryKeywords);
        category.setCategoryAnothername(categoryAlias);
        category.setCategoryName(categoryName);
        int i = categoryMapper.updateByPrimaryKey(category);
        if (i> 0)
            return true;
        return false;
    }

    @Override
    public boolean deleteCategoryById(int id) {
        int i = categoryMapper.deleteByPrimaryKey(id);
        if (i> 0)
            return true;
        return false;
    }
}
