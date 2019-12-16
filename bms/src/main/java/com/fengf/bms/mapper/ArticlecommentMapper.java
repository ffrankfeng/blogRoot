package com.fengf.bms.mapper;

import com.fengf.bms.pojo.Articlecomment;
import com.fengf.bms.pojo.ArticlecommentExample;
import java.util.List;

import com.fengf.bms.pojo.CommentQueryVo;
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

    int commentCountByQueryVo(CommentQueryVo vo);

    List<Articlecomment> selectCommentListByQueryVo(CommentQueryVo vo);

    int deleteByPrimaryKey(int commentId);
}