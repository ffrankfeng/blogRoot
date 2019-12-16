package com.fengf.bms.service;

import com.fengf.bms.pojo.ArticleQueryVo;
import com.fengf.bms.pojo.ArticleVo;
import com.fengf.bms.pojo.Articles;
import com.fengf.bms.pojo.Users;
import com.fengf.common.utils.Page;

import java.util.List;

public interface ArticleService {
    ArticleVo getArticleInfo();

    boolean savewriting(Articles articles);

    Page<Articles> selectAllPage(ArticleQueryVo vo);

    List<Articles> selectAllArticles();

    Articles showarticle(Integer articleId);

    int likeAndDislike(Boolean flag, Integer articleId);

    Users getArticleAuthor(String author);

    boolean deleteArticleByID(String id);
}
