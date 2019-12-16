package com.fengf.blog.service;

import com.fengf.blog.pojo.MoodQueryVo;
import com.fengf.blog.pojo.MoodShareQueryVo;
import com.fengf.blog.pojo.Moodshare;
import com.fengf.common.utils.Page;

public interface MoodShareService {

	Page<MoodShareQueryVo> selectAllMood(MoodShareQueryVo vo);

	boolean writeMyMood(Moodshare moodshare);

	boolean likeMood(Integer moodId, Integer userId);
}
