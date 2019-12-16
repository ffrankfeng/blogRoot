package com.fengf.blog.mapper;

import com.fengf.blog.pojo.ArticleQueryVo;

import java.util.List;

import com.fengf.blog.pojo.Articles;
import com.fengf.blog.pojo.ArticlesExample;
import org.apache.ibatis.annotations.Param;

public interface ArticlesMapper {
    int countByExample(ArticlesExample example);

    int deleteByExample(ArticlesExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(Articles record);

    int insertSelective(Articles record);
    List<Articles> selectByExample(ArticlesExample example);
    Articles selectByPrimaryKey(Integer articleId);

    int updateByExampleSelective(@Param("record") Articles record, @Param("example") ArticlesExample example);

    int updateByExample(@Param("record") Articles record, @Param("example") ArticlesExample example);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKey(Articles record);
    
    int updateLikeByPrimaryKey(Articles record);
    
    int updateDisLikeByPrimaryKey(Articles record);

    void addReadingByPrimaryKey(Integer articleId);

    List<Articles> selectArticleListByUser(ArticleQueryVo articleVo);

    int articleCountByQueryVo(ArticleQueryVo articleVo);


    int articleCountByUserId(int i);

	List<Articles> selectArticleListByQueryVo(ArticleQueryVo articleVo);

    List<Articles> selectArticleListByQueryVoAndReadings(ArticleQueryVo articleVo);

    int myArticleCount(int i);

    List<Articles> selectMyArticleList(ArticleQueryVo articleVo);
}