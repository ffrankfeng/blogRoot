package com.fengf.blog.mapper;

import com.fengf.blog.pojo.Articlelike;
import com.fengf.blog.pojo.ArticlelikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlelikeMapper {
    int countByExample(ArticlelikeExample example);

    int deleteByExample(ArticlelikeExample example);

    int deleteByPrimaryKey(Integer ladId);

    int insert(Articlelike record);

    int insertSelective(Articlelike record);

    List<Articlelike> selectByExample(ArticlelikeExample example);

    Articlelike selectByPrimaryKey(Integer ladId);

    int updateByExampleSelective(@Param("record") Articlelike record, @Param("example") ArticlelikeExample example);

    int updateByExample(@Param("record") Articlelike record, @Param("example") ArticlelikeExample example);

    int updateByPrimaryKeySelective(Articlelike record);

    int updateByPrimaryKey(Articlelike record);

	Articlelike selectByArticleIdAndUserId(Articlelike articlelike);
}