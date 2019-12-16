package com.fengf.blog.mapper;

import com.fengf.blog.pojo.Articlecomment;
import com.fengf.blog.pojo.ArticlecommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlecommentMapper {
    int countByExample(ArticlecommentExample example);

    int deleteByExample(ArticlecommentExample example);

    int insert(Articlecomment record);

    int insertSelective(Articlecomment record);

    List<Articlecomment> selectByExample(ArticlecommentExample example);

    int updateByExampleSelective(@Param("record") Articlecomment record, @Param("example") ArticlecommentExample example);

    int updateByExample(@Param("record") Articlecomment record, @Param("example") ArticlecommentExample example);

	List<Articlecomment> selectCommentByArticleId(Integer articleId);
}