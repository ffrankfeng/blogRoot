package com.fengf.bms.service;

import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.Category;
import com.fengf.common.utils.Page;

import java.util.List;

public interface CategoryService {
    List<Category> selectAllPage();

    boolean addCategory(String categoryName, String categoryAlias, String categoryKeywords);

    Category selectCategoryByCategoryId(int categoryId);

    boolean updateCategory(int categoryId, String categoryName, String categoryAlias, int categoryKeywords,int categoryCount);

    boolean deleteCategoryById(int id);
}
