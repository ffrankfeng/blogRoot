package com.fengf.blog.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengf.blog.mapper.MoodshareMapper;
import com.fengf.blog.mapper.UsersMapper;
import com.fengf.blog.pojo.MoodShareQueryVo;
import com.fengf.blog.pojo.Moodshare;
import com.fengf.common.utils.Page;

@Service
public class MoodShareServiceImpl implements MoodShareService {

	@Autowired
	private MoodshareMapper moodshareMapper;
	@Autowired
	private UsersMapper usersMapper;
	@Override
	public Page<MoodShareQueryVo> selectAllMood(MoodShareQueryVo vo) {
		Page<MoodShareQueryVo> page=new Page<MoodShareQueryVo>();
		//每页数
		page.setSize(5);
		vo.setSize(5);
		
		if(vo!=null ){
			//判断当前页
			if(vo.getPage()!=null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if(vo.getMoodAuthor()!=null && !vo.getMoodAuthor().trim().equals("")){
				vo.setMoodAuthor(vo.getMoodAuthor().trim() );
			}
			//总条数
			page.setTotal(moodshareMapper.moodCountByQueryVo(vo));
			page.setRows(moodshareMapper.selectMoodListByQueryVo(vo));
		}
		return page;
	}
	public String getupDate() throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(new Date());
		return date;
	}
	@Override
	public boolean writeMyMood(Moodshare moodshare) {
		try {
			moodshare.setMoodDate(getupDate());
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		moodshare.setMoodDislike(0);
		moodshare.setMoodLike(0);
		int flag = moodshareMapper.insertSelective(moodshare);
		if(flag>0){
			int flag2 = usersMapper.addUserMood(moodshare.getMoodAuthor());
			if(flag2>0) return true;
			else return false;
		}
		else return false;
	}
	@Override
	public boolean likeMood(Integer moodId, Integer userId) {
		Moodshare moodshare = moodshareMapper.selectByPrimaryKey(moodId);
		moodshare.setMoodLikeuserid("|"+userId+"|");
		moodshare.setMoodLike(moodshare.getMoodLike()+1);
		int flag = moodshareMapper.updateByPrimaryKey(moodshare);
		if(flag>0)
			return true;
		else return false;
	}

}
