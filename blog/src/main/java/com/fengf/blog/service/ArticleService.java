package com.fengf.blog.service;

import java.util.List;

import com.fengf.blog.pojo.*;
import com.fengf.common.utils.Page;

public interface ArticleService {

	boolean savewriting(Articles articles);

	Page<Articles> selectAllPage(ArticleQueryVo vo);
	Page<Articles> selectAllPageBySerach(ArticleQueryVo vo);

	Articles showarticle(Integer articleId);

	boolean likeAndDislike(Boolean flag, Integer articleId, Integer userId);

	Users getArticleAuthor(String author);

	List<Users> selectHotUsers();

	Articlelike getUserLikeAndDisLike(Integer articleId, Integer userId);

	boolean getIsAttention(Integer userId, String author);

	List<Articlecomment> selectNewComment(Articlecomment articlecomment);

	boolean insertcomment(Articlecomment articlecomment);

	List<Articlecomment> getCommentList(Integer articleId);

	List<Articles> selecthotArticles();

    boolean deleteArticle(int articleId);

    Articles editArticle(int articleId);

	boolean saveEdit(Articles articles);

	boolean checkArticleRequestIsVaild(Users current_user, int articleId);
}
