package com.fengf.bms.service;

import com.fengf.bms.mapper.ArticlesMapper;
import com.fengf.bms.mapper.MoodshareMapper;
import com.fengf.bms.mapper.UsersMapper;
import com.fengf.bms.pojo.*;
import com.fengf.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticlesMapper articlesMapper;
    @Autowired
    private MoodshareMapper moodshareMapper;
    @Autowired
    private UsersMapper usersMapper;

    private int aritcleCount;
    private int modeCount;
    private int userCount;
    private int readCount;
    private String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
    private String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
    private String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式


    public String removeHTML(String htmlStr){
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        if (htmlStr != null && htmlStr != ""){
            Matcher m_script=p_script.matcher(htmlStr);
            htmlStr=m_script.replaceAll(""); //过滤script标签

            Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
            Matcher m_style=p_style.matcher(htmlStr);
            htmlStr=m_style.replaceAll(""); //过滤style标签

            Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
            Matcher m_html=p_html.matcher(htmlStr);
            htmlStr=m_html.replaceAll(""); //过滤html标签

            Pattern nn_html=Pattern.compile("&nbsp;",Pattern.CASE_INSENSITIVE);
            Matcher n_html=nn_html.matcher(htmlStr);
            htmlStr=n_html.replaceAll(""); //过滤&nbsp;标签
//           \n
//
            Pattern n1_html=Pattern.compile("&gt;",Pattern.CASE_INSENSITIVE);
            Matcher n11_html=n1_html.matcher(htmlStr);
            htmlStr=n11_html.replaceAll(""); //过滤 &gt;标签

            Pattern n2_html=Pattern.compile("&lt;",Pattern.CASE_INSENSITIVE);
            Matcher n22_html=n2_html.matcher(htmlStr);
            htmlStr=n22_html.replaceAll(""); //过滤 &lt;标签

            Pattern n3_html=Pattern.compile("&quot;",Pattern.CASE_INSENSITIVE);
            Matcher n33_html=n3_html.matcher(htmlStr);
            htmlStr=n33_html.replaceAll(""); //过滤 &quot;标签

            return htmlStr.trim(); //返回文本字符串
        }
        else return htmlStr;

    }
    @Override
    public ArticleVo getArticleInfo() {
        List<Articles> list = articlesMapper.selectAllArticleList();
         List<Moodshare> moodlist = moodshareMapper.selectAllMoodList();
        List<Users> userlist = usersMapper.selectAllUserList();

        ArticleVo articleVo = new ArticleVo();
        readCount = 0;
        for (Articles article:list){
            readCount +=article.getReading();
        }
        articleVo.setmoodCount(moodlist.size());
        articleVo.setUserCount(userlist.size());
        articleVo.setAritcleCount(list.size());
        articleVo.setReadCount(readCount);

        return articleVo;
    }
    public String getupDate() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(new Date());
        return date;
    }
    @Override
    public boolean savewriting(Articles articles) {
        articles.setCatalog("0");
        articles.setDislike(0);
        articles.setLikecount(0);
        articles.setReading(0);
        articles.setTop("0");
        try {
            articles.setUptime(getupDate());
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
//        System.out.println(articles);
        int flag = articlesMapper.insertSelective(articles);
        if(flag<=0)
            return false;
        else {
            Users users = usersMapper.selectByusername(articles.getAuthor());
            usersMapper.addUserArticleCount(users.getUserId());
            return true;
        }

    }
    @Override
    public Page<Articles> selectAllPage(ArticleQueryVo vo) {
        Page<Articles> page=new Page<Articles>();
        //每页数
        page.setSize(10);
        vo.setSize(10);

        if(vo!=null ){
            //判断当前页
            if(vo.getPage()!=null){
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage()-1)*vo.getSize());
            }
            //总条数
            page.setTotal(articlesMapper.articleCountByQueryVo(vo));
            page.setRows(articlesMapper.selectArticleListByQueryVo(vo));
        }
        return page;
    }

    @Override
    public List<Articles> selectAllArticles() {
        List<Articles> articles = articlesMapper.selectAllArticleList();
        for (Articles article:articles){
            String remove_str = removeHTML(article.getContent());
            if (remove_str.length()>160)
                remove_str = remove_str.substring(0,160);
            article.setContent(remove_str);
        }
        return articles;
    }

    @Override
    public Articles showarticle(Integer articleId) {
        articlesMapper.addReadingByPrimaryKey(articleId);
        return articlesMapper.selectByPrimaryKey(articleId);
    }
    @Override
    public int likeAndDislike(Boolean flag,Integer articleId) {
        int flag1=0;
        Articles article = articlesMapper.selectByPrimaryKey(articleId);
        if(flag){
            article.setLikecount(article.getLikecount()+1);
            flag1=articlesMapper.updateLikeByPrimaryKey(article);
            return article.getLikecount();
        }
        else{
            article.setDislike(article.getDislike()-1);
            flag1=articlesMapper.updateDisLikeByPrimaryKey(article);
            return article.getDislike();
        }
    }
    @Override
    public Users getArticleAuthor(String author) {
        Users users = usersMapper.selectByusername(author);
        return users;
    }

    @Override
    public boolean deleteArticleByID(String id) {
        int flag = articlesMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if (flag>0)
            return true;
        return false;
    }

}

