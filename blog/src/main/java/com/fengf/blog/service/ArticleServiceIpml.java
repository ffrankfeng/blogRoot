package com.fengf.blog.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fengf.blog.pojo.*;
import com.fengf.common.utils.JSONUtils;
import com.fengf.common.utils.JedisPoolUtil;
import net.sf.json.processors.JsDateJsonBeanProcessor;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengf.blog.mapper.ArticlecommentMapper;
import com.fengf.blog.mapper.ArticlelikeMapper;
import com.fengf.blog.mapper.ArticlesMapper;
import com.fengf.blog.mapper.AttentionMapper;
import com.fengf.blog.mapper.UsersMapper;
import com.fengf.common.utils.Page;
import redis.clients.jedis.Jedis;

@Service
public class ArticleServiceIpml implements ArticleService {

	@Autowired
	private ArticlesMapper articlesMapper;
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private ArticlelikeMapper articlelikeMapper;
	@Autowired
	private AttentionMapper attentionMapper;
	@Autowired
	private ArticlecommentMapper articlecommentMapper;
	@Autowired
	private JedisPoolUtil jedis;

	String hotUsersID = "fengfblog:hotUsers";
	String articleRecommendID = "fengfblog:articleRecommend";
	String articleCountID = "articleCount";
	String articleList_topicID = "fengfblog:topic_";
	String articleListID1 ="FeaturedArticleList_page_";
	private String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
	private String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
	private String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
     
    
	public String getupDate() throws ParseException{
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
	
		int flag = articlesMapper.insertSelective(articles);
		if(flag<=0)
			return false;
		else {
			Users users = usersMapper.selectByusername(articles.getAuthor());
			int flag1 = usersMapper.addUserArticleCount(users.getUserId());
			if(flag1>0)return true;
			else return false;
		}
			
	}
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
    public long queryArticlesByKeysCount(ArticleQueryVo vo) throws Exception {
        SolrServer solrServer = new HttpSolrServer("http://fengf-xy.top/solr/collection1");
        //创建一个查询对象
        SolrQuery query = new SolrQuery();
        //查询条件
        query.setQuery(vo.getTitle());
        query.set("df", "item_keywords");
        query.setHighlight(true);
        query.addHighlightField("item_title,item_content,item_author");
        query.setHighlightSimplePre("<em>");
        query.setHighlightSimplePost("</em>");
        //执行查询
        QueryResponse queryResponse = solrServer.query(query);
        //取文档列表。取查询结果的总记录数
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        return solrDocumentList.getNumFound();
    }
	public List<Articles> queryArticlesByKeys(ArticleQueryVo vo) throws Exception {
        SolrServer solrServer = new HttpSolrServer("http://fengf-xy.top/solr/collection1");
        //创建一个查询对象
        SolrQuery query = new SolrQuery();
        //查询条件
        query.setQuery(vo.getTitle());
        if(vo.getPage().equals(1)){
            query.setStart(vo.getPage());
        }else {
            query.setStart((vo.getPage()-1)*5+1);
        }
        query.setRows(5);
//        System.out.println("Start "+query.getStart()+",Rows "+query.getRows());
        query.set("df", "item_keywords");

//        query.setSort("item_title", SolrQuery.ORDER.desc);
        query.setHighlight(true);
        query.addHighlightField("item_title,item_content,item_author");
        query.setHighlightSimplePre("<span style=\"color:red\">");
        query.setHighlightSimplePost("</span>");
        //执行查询
        QueryResponse queryResponse = solrServer.query(query);
        //取文档列表。取查询结果的总记录数
        SolrDocumentList solrDocumentList = queryResponse.getResults();
//        System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
        //遍历文档列表，从取域的内容。
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        List<Articles> articles = new ArrayList<>();
        for (SolrDocument solrDocument : solrDocumentList) {
//            System.out.println();
			Integer article_id = 0;
			try {
				article_id = Integer.parseInt(solrDocument.get("id")+"");
			}catch (Exception e){

			}
			//取高亮显示
            List<String> title_list = highlighting.get(solrDocument.get("id")).get("item_title");
            String title = "";
            if (title_list != null && title_list.size() > 0) {
                title = title_list.get(0);
            } else {
                title = (String) solrDocument.get("item_title");
            }
            List<String> content_list = highlighting.get(solrDocument.get("id")).get("item_content");
            String content = "";
            if (content_list != null && content_list.size() > 0) {
                content = content_list.get(0);
            } else {
                content = (String) solrDocument.get("item_content");
            }
            List<String> author_list = highlighting.get(solrDocument.get("id")).get("item_author");
            String author = "";
            if (author_list != null && author_list.size() > 0) {
                author = author_list.get(0);
            } else {
                author = (String) solrDocument.get("item_author");
            }
//            System.out.println(title);
//            System.out.println(content);
//            System.out.println(author);
            Articles article = new Articles();
            article.setArticleId(article_id);
            article.setTitle(title);
            article.setContent(content);
            article.setAuthor(author);
            articles.add(article);
        }
        System.out.println("searrr");
        System.out.println(articles);
        return articles;
    }

	@Override
	public Page<Articles> selectAllPageBySerach(ArticleQueryVo vo) {


		Page<Articles> page=new Page<Articles>();
		//每页数
		page.setSize(5);
		vo.setSize(5);

		if(vo!=null ){
			//判断当前页
			if(vo.getPage()!=null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}

			//总条数
            int	articleCount = 0;
            try {
                articleCount = Integer.parseInt(queryArticlesByKeysCount(vo)+"");
            } catch (Exception e) {
                e.printStackTrace();
            }

            page.setTotal(articleCount);

            List<Articles> list = null;
            try {
                list = queryArticlesByKeys(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            page.setRows(list);
		}
//		System.out.println(page);
		return page;
	}
	@Override
	public Page<Articles> selectAllPage(ArticleQueryVo vo) {

		
		Page<Articles> page=new Page<Articles>();
		//每页数
		page.setSize(5);
		vo.setSize(5);
		
		if(vo!=null ){
			//判断当前页
			if(vo.getPage()!=null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}

			//总条数
			int articleCount = 0;
			List<Articles> list = new ArrayList<>();
			int topic = 0;
			int nowPage = 1;
			if (vo.gettopic() !=null){
				topic = vo.gettopic();
			}
			if(vo.getPage() != null){
				nowPage = vo.getPage();
			}
			String jsonArticleCount = jedis.get(articleList_topicID+topic+":"+articleCountID);
			if (StringUtils.isNotBlank(jsonArticleCount)) {
				try {

					articleCount = Integer.parseInt(jsonArticleCount);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				articleCount = articlesMapper.articleCountByQueryVo(vo);
				try {
					jedis.set(articleList_topicID+topic+":"+articleCountID,articleCount+"");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			page.setTotal(articleCount);



			String jsonArticleList = jedis.get(articleList_topicID+topic+":"+articleListID1+nowPage);
			if (StringUtils.isNotBlank(jsonArticleList)) {
				try {

					list = JSONUtils.json2list(jsonArticleList,Articles.class);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				list = articlesMapper.selectArticleListByQueryVoAndReadings(vo);
				for(Articles article:list){
					article.setContent(removeHTML(article.getContent()+""));
				}
				try {
					jedis.set(articleList_topicID+topic+":"+articleListID1+nowPage, JSONUtils.obj2json(list));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for(Articles article:list){
				article.setContent(removeHTML(article.getContent()+""));
			}
			page.setRows(list);
		}
//		System.out.println(page);
		return page;
	}
	@Override
	public Articles showarticle(Integer articleId) {
		articlesMapper.addReadingByPrimaryKey(articleId);
		return articlesMapper.selectByPrimaryKey(articleId);
	}
	@Override
	public boolean likeAndDislike(Boolean flag,Integer articleId, Integer userId) {
		int flag1=0;
		int insertflag=0;
		Articles article = articlesMapper.selectByPrimaryKey(articleId);
		Articlelike articlelike = new Articlelike();
		articlelike.setArticleId(articleId);
		articlelike.setUserId(userId);
		if(flag){
			articlelike.setLikeordislike("like");
			article.setLikecount(article.getLikecount()+1);
			insertflag=articlelikeMapper.insertSelective(articlelike);
			flag1=articlesMapper.updateLikeByPrimaryKey(article);
			return flag1>0&&insertflag>0?true:false;
		}
		else{
			articlelike.setLikeordislike("dislike");
			article.setDislike(article.getDislike()+1);
			insertflag=articlelikeMapper.insertSelective(articlelike);
			flag1=articlesMapper.updateDisLikeByPrimaryKey(article);
			return flag1>0&&insertflag>0?true:false;
		}
	}
	@Override
	public Users getArticleAuthor(String author) {
		Users users = usersMapper.selectByusername(author);
		return users;
	}
	@Override
	public List<Users> selectHotUsers() {
		List<Users> hotUsers = new ArrayList<>();
		String json = jedis.get(hotUsersID);
		if (StringUtils.isNotBlank(json)) {
			try {

				hotUsers = JSONUtils.json2list(json, Users.class);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			hotUsers = usersMapper.selectHotUsers(5);
			try {
				jedis.set(hotUsersID,JSONUtils.obj2json(hotUsers));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return hotUsers;
	}
	@Override
	public Articlelike getUserLikeAndDisLike(Integer articleId, Integer userId) {
		Articlelike articlelike= new Articlelike();
		articlelike.setArticleId(articleId);
		articlelike.setUserId(userId);
		
		return articlelikeMapper.selectByArticleIdAndUserId(articlelike);
	}
	@Override
	public boolean getIsAttention(Integer userId, String author) {
		Users attentionAuthor = usersMapper.selectByusername(author);
		Attention record = new Attention();
		record.setUserId(userId);
		record.setAttuserId(attentionAuthor.getUserId());
//		System.out.println(record.toString());
		Attention attention = attentionMapper.selectByAuthorIdAndUserId(record);

		if(attention == null) return false;
		else return true;
	}
	@Override
	public List<Articlecomment> selectNewComment(Articlecomment articlecomment) {
		
		return null;
	}
	@Override
	public boolean insertcomment(Articlecomment articlecomment) {
		
		try {
			articlecomment.setCommentTime(getupDate());
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int flag = articlecommentMapper.insert(articlecomment);
		if (flag>0) return true;
		else return false;
	}
	@Override
	public List<Articlecomment> getCommentList(Integer articleId) {
		return articlecommentMapper.selectCommentByArticleId(articleId);
	}
	@Override
	public List<Articles> selecthotArticles() {
		ArticleQueryVo aqv =   new ArticleQueryVo();
		aqv.setAuthorId(1);
		aqv.setSize(5);
		List<Articles> listByUser = new ArrayList<>();
		String json = jedis.get(articleRecommendID);
		if (StringUtils.isNotBlank(json)) {
			try {

				listByUser = JSONUtils.json2list(json, Articles.class);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			listByUser = articlesMapper.selectArticleListByUser(aqv);
			for(Articles article:listByUser){
				article.setContent(removeHTML(article.getContent()+""));
			}
			try {
				jedis.set(articleRecommendID,JSONUtils.obj2json(listByUser));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for(Articles article : listByUser){
			article.setContent(removeHTML(article.getContent()));
		}
		return listByUser;
	}

	@Override
	public boolean deleteArticle(int articleId) {
		Articles article = articlesMapper.selectByPrimaryKey(articleId);
		int result1 = articlesMapper.deleteByPrimaryKey(articleId);
		if (result1>0) {
			int result2 = usersMapper.deleteUserArticleCount(article.getAuthorId());
			if (result2>0)
				return true;
		}
		return false;
	}

	@Override
	public Articles editArticle(int articleId) {
		Articles article = articlesMapper.selectByPrimaryKey(articleId);
		return article;
	}

	@Override
	public boolean saveEdit(Articles articles) {
		Articles oldArticles = articlesMapper.selectByPrimaryKey(articles.getArticleId());
		oldArticles.setContent(articles.getContent());
		oldArticles.setIsopen(articles.getIsopen());
		oldArticles.setKeyword1(articles.getKeyword1());
		oldArticles.setKeyword2(articles.getKeyword2());
		oldArticles.setKeyword3(articles.getKeyword3());
		oldArticles.setTitle(articles.getTitle());
		oldArticles.setTopic(articles.getTopic());

		try {
			oldArticles.setUptime(getupDate());
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int flag = articlesMapper.updateByPrimaryKey(oldArticles);
		if(flag<=0)
			return false;
		else {
			return true;
		}
	}

	@Override
	public boolean checkArticleRequestIsVaild(Users current_user, int articleId) {
		Articles articles = articlesMapper.selectByPrimaryKey(articleId);
		if (current_user.getUserId() != articles.getAuthorId())
			return false;
		else
			return true;
	}
}
