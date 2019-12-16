package com.fengf.bms.mapper;

import com.fengf.bms.pojo.Articles;
import com.fengf.bms.pojo.MoodShareQueryVo;
import com.fengf.bms.pojo.Moodshare;
import com.fengf.bms.pojo.MoodshareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoodshareMapper {
    int countByExample(MoodshareExample example);

    int deleteByExample(MoodshareExample example);

    int deleteByPrimaryKey(Integer moodId);

    int insert(Moodshare record);

    int insertSelective(Moodshare record);

    List<Moodshare> selectByExample(MoodshareExample example);

    Moodshare selectByPrimaryKey(Integer moodId);

    int updateByExampleSelective(@Param("record") Moodshare record, @Param("example") MoodshareExample example);

    int updateByExample(@Param("record") Moodshare record, @Param("example") MoodshareExample example);

    int updateByPrimaryKeySelective(Moodshare record);

    int updateByPrimaryKey(Moodshare record);

	int moodCountByQueryVo(MoodShareQueryVo vo);

	List<Moodshare> selectMoodListByQueryVo(MoodShareQueryVo vo);

    List<Moodshare> selectAllMoodList();
}