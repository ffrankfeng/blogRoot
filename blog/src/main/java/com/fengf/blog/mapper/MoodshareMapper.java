package com.fengf.blog.mapper;

import com.fengf.blog.pojo.MoodQueryVo;
import com.fengf.blog.pojo.MoodShareQueryVo;
import com.fengf.blog.pojo.Moodshare;
import com.fengf.blog.pojo.MoodshareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoodshareMapper {
    int countByExample(MoodshareExample example);

    int deleteByExample(MoodshareExample example);

    int deleteByPrimaryKey(Integer moodId);

    int insert(Moodshare record);

    int insertSelective(Moodshare record);

    List<Moodshare> selectByExampleWithBLOBs(MoodshareExample example);

    List<Moodshare> selectByExample(MoodshareExample example);

    Moodshare selectByPrimaryKey(Integer moodId);

    int updateByExampleSelective(@Param("record") Moodshare record, @Param("example") MoodshareExample example);

    int updateByExampleWithBLOBs(@Param("record") Moodshare record, @Param("example") MoodshareExample example);

    int updateByExample(@Param("record") Moodshare record, @Param("example") MoodshareExample example);

    int updateByPrimaryKeySelective(Moodshare record);

    int updateByPrimaryKeyWithBLOBs(Moodshare record);

    int updateByPrimaryKey(Moodshare record);
    
    int moodCountByQueryVo(MoodShareQueryVo vo);
	  
	List<MoodShareQueryVo> selectMoodListByQueryVo(MoodShareQueryVo vo);
}