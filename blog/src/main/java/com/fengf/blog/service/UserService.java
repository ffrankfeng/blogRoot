package com.fengf.blog.service;

import com.fengf.blog.pojo.ArticleQueryVo;
import com.fengf.blog.pojo.Articles;
import com.fengf.blog.pojo.UserQueryVo;
import com.fengf.blog.pojo.Users;
import com.fengf.common.utils.Page;

public interface UserService {

	Users userLogin(Users user);

	boolean userInsert(Users user);

	boolean checkUsername(String userName);

	String getJoinday(Users current_user);

	boolean personEdit(Users user);

	boolean insertAttention(Integer current_userId, Integer userId);

	boolean deleteAttention(Integer current_userId, Integer userId);


	Page<Users> selectAllPage(UserQueryVo vo);

	Users personcenter(Integer userId);

	boolean getIsAttention(Integer current_userId, Integer userId);

	Page<Articles> selectUserAllPage(ArticleQueryVo vo);

	Page<Users> selectAllAttentionPage(UserQueryVo vo);

	Page<Users> selectAllFansPage(UserQueryVo vo);

	Page<Articles> selectmyAllPage(ArticleQueryVo vo);
}
