package com.fengf.blog.mapper;

import com.fengf.blog.pojo.Attention;
import com.fengf.blog.pojo.AttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttentionMapper {
    int countByExample(AttentionExample example);

    int deleteByExample(AttentionExample example);

    int deleteByPrimaryKey(Integer attentionId);

    int insert(Attention record);

    int insertSelective(Attention record);

    List<Attention> selectByExample(AttentionExample example);

    Attention selectByPrimaryKey(Integer attentionId);

    int updateByExampleSelective(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByExample(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);

	Attention selectByAuthorIdAndUserId(Attention record);

	int deleteByUserIdAndAttuserId(Attention attention);
}