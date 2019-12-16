package com.fengf.blog.service;

import com.fengf.blog.mapper.CategoryMapper;
import com.fengf.blog.pojo.Category;
import com.fengf.common.utils.JedisPoolUtil;
import com.fengf.common.utils.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private JedisPoolUtil jedis;
    String categoryID = "fengfblog:catagory";
    @Override
    public List<Category> selectAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        String json = jedis.get(categoryID);
        if (StringUtils.isNotBlank(json)) {
            try {
                categoryList = JSONUtils.json2list(json, Category.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            categoryList = categoryMapper.selectAllCategory();
            try {
                jedis.set(categoryID,JSONUtils.obj2json(categoryList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return categoryList;

    }
}
