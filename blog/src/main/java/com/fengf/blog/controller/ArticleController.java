package com.fengf.blog.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fengf.blog.pojo.*;
import com.fengf.blog.service.CategoryService;
import com.fengf.common.utils.JGitUtil;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fengf.blog.service.ArticleService;
import com.fengf.common.utils.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import static org.apache.solr.client.solrj.impl.XMLResponseParser.log;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
    private JGitUtil jGitUtil;


	@RequestMapping(value="/upload.html")
	@ResponseBody
	public String imgUpload(@RequestParam("imgUpload") MultipartFile multipartFile, HttpServletRequest request){
//		System.out.println(multipartFile);
		try {
			// 获取项目路径
			String realPath = request.getSession().getServletContext()
					.getRealPath("");
			InputStream inputStream = multipartFile.getInputStream();
			String contextPath = request.getContextPath();
			// 服务器根目录的路径
//			String path = realPath.replace(contextPath.substring(1), "");
			// 根目录下新建文件夹upload，存放上传图片
			String uploadPath = contextPath + "/images/upload/";
			// 获取文件名称
			String filename = getFileName();
			// 将文件上传的服务器根目录下的upload文件夹
			String path =request.getSession().getServletContext().getRealPath("/") + "img/mood/";
			File file = new File(path, filename);


//			System.out.println("file:"+file);
			FileUtils.copyInputStreamToFile(inputStream, file);
			// 返回图片访问路径
			String url = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + "/img/mood/" + filename;
//			System.out.println("url:"+url);
			String[] str = { url };
			WangEditor we = new WangEditor(str);
			boolean blag = jGitUtil.commitFiles(file, new File(jGitUtil.getLOCALPATH() + "/home/article/" + filename), "update img:" + filename);
			if (!blag)
				System.out.println("备份图片失败|"+filename);
//			System.out.println("we:"+JSONObject.fromObject(we));
//			return JSONObject.fromObject(we);
//			System.out.println("{\"errno\":0,\"data\":[\""+url+"\"]}");
			return "{\"errno\":0,\"data\":[\""+url+"\"]}";
		} catch (IOException e) {
//			System.out.println("error:"+e);
			log.error("上传文件失败", e);
		}
		return null;
	}
	public String getFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStr = sdf.format(new Date());
		String str = RandomStringUtils.random(5,
				"abcdefghijklmnopqrstuvwxyz1234567890");
		String name = timeStr + str + ".jpg";
		return name;
	}

	@RequestMapping(value="/deleteArticle.html")
	@ResponseBody
	public String deleteArticle(int articleId,HttpServletRequest request){
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user == null)
			return "{\"isFinish\":null}";
		else {
			boolean isVaild = articleService.checkArticleRequestIsVaild(current_user, articleId);
			if (isVaild) {
				boolean flag = articleService.deleteArticle(articleId);
				return "{\"isFinish\":" + flag + "}";
			} else {
				return "{\"isFinish\":null}";
			}
		}
	}

	@RequestMapping(value="/editArticle.html")
	public String editArticle(int articleId,Model model,HttpServletRequest request){
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user == null)
			return "404";
		else {
			boolean isVaild = articleService.checkArticleRequestIsVaild(current_user,articleId);
			if (isVaild){
				Articles article  = articleService.editArticle(articleId);
				article.setContent(article.getContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
				model.addAttribute("editArticle", article);
				model.addAttribute("articleId", articleId);
				List<Category> categoryList = categoryService.selectAllCategory();
				model.addAttribute("categoryList", categoryList);
				return "editArticle";
			}else {
				return "404";
			}
		}

	}
	@RequestMapping(value="/writing.html")
	String writing(HttpServletRequest request,Model model){
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user == null)
			return "login";
		else {
			List<Category> categoryList = categoryService.selectAllCategory();
			model.addAttribute("categoryList", categoryList);
			return "writeacticle";
		}

	}

//	@RequestMapping(value="/tselectArticlesByCategory")
//	public String index(ArticleQueryVo vo,Model model){
//		Page<Articles>  page = articleService.selectAllPage(vo);
//		model.addAttribute("page", page);
//		List<Category> categoryList = categoryService.selectAllCategory();
//		model.addAttribute("categoryList", categoryList);
//		return "index";
//	}
	@RequestMapping(value="/articlecomment.html")
	public void articlecomment(Articlecomment articlecomment,HttpServletRequest request,HttpServletResponse response) throws IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user == null){
			response.getWriter().write("{\"isFinish\":\"null\"}");
		}else{
			articlecomment.setFromUid(current_user.getUserId());
			articlecomment.setFromUsername(current_user.getUserName());
			boolean flag = articleService.insertcomment(articlecomment);
			response.getWriter().write("{\"isFinish\":"+flag+"}");
		}
	}
	//首页
	@RequestMapping(value="/")
	public String defaultPage(ArticleQueryVo vo,Model model){
		Page<Articles>  page = articleService.selectAllPage(vo);
		model.addAttribute("page", page);
		List<Category> categoryList = categoryService.selectAllCategory();
		model.addAttribute("categoryList", categoryList);
		return "index";
	}
	@RequestMapping(value="/index.html")
	public String index(ArticleQueryVo vo,Model model){
		Page<Articles>  page = articleService.selectAllPage(vo);
		model.addAttribute("page", page);
		List<Category> categoryList = categoryService.selectAllCategory();
		model.addAttribute("categoryList", categoryList);
		return "index";
	}
	@RequestMapping(value="/InfoBar.html")
	public String InfoBar(Model model){
		List<Users> hotUsers=articleService.selectHotUsers();
		model.addAttribute("hotUsers", hotUsers);
		List<Articles> hotArticles=articleService.selecthotArticles();
		model.addAttribute("hotArticles", hotArticles);
		return "InfoBar";
	}
	@RequestMapping(value="/userarticlelist.html")
	String userarticlelist(ArticleQueryVo vo,Integer userId,Model model){
		if(userId !=null && userId !=0){
			vo.setAuthorId(userId);
			model.addAttribute("search",userId);
		}
		Page<Articles>  page = articleService.selectAllPageBySerach(vo);
		model.addAttribute("page", page);
//		System.out.println("serarch tr");
//		System.out.println(page);
		return "userarticlelist";
	}
	@RequestMapping(value="/likeAndDislike.html")
	public void likeAndDislike(Boolean flag,Integer articleId,HttpServletResponse response,HttpServletRequest request) throws IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user == null){
			response.getWriter().write("{\"isFinish\":\"null\"}");
		}else {
			boolean flag2 = articleService.likeAndDislike(flag, articleId, current_user.getUserId());
			response.getWriter().write("{\"isFinish\":" + flag2 + "}");
		}
	}

	@RequestMapping(value="/showarticle.html")
	public String showarticle(Integer articleId,Model model,HttpServletRequest request){
		try {
			Articles articles = articleService.showarticle(articleId);
			Users author=articleService.getArticleAuthor(articles.getAuthor());
			Users current_user = (Users) request.getSession().getAttribute("current_user");
			if(current_user != null){
				Articlelike articlelike =articleService.getUserLikeAndDisLike(articleId,current_user.getUserId());
				boolean isAttention = articleService.getIsAttention(current_user.getUserId(),articles.getAuthor());
				model.addAttribute("isAttention", isAttention);
				model.addAttribute("articlelike", articlelike);
			}else{
				model.addAttribute("isAttention", false);
				model.addAttribute("articlelike", null);
			}

			List<Articlecomment> commentList = articleService.getCommentList(articleId);
			model.addAttribute("commentList", commentList);
			model.addAttribute("article", articles);
			model.addAttribute("articleAuthor", author);
			return "showarticle";
		}catch (Exception e){
			return "forward";
		}
	}
	@RequestMapping(value="/savewriting.html")
	void savewriting(Articles articles,HttpServletResponse response,HttpServletRequest request) throws IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user == null){
			response.getWriter().write("{\"isFinish\":null}");
		}else {
			articles.setAuthorId(current_user.getUserId());
			articles.setAuthor(current_user.getUserName());
			boolean flag = articleService.savewriting(articles);
			response.getWriter().write("{\"isFinish\":" + flag + "}");
		}
	}

	@RequestMapping(value="/saveEdit.html")
	void saveEdit(Articles articles,HttpServletResponse response,HttpServletRequest request) throws IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user == null)
			response.getWriter().write("{\"isFinish\":null}");
		else {
			boolean isVaild = articleService.checkArticleRequestIsVaild(current_user, articles.getArticleId());
			if (isVaild) {
				articles.setAuthorId(current_user.getUserId());
				articles.setAuthor(current_user.getUserName());
//				System.out.println(articles);
				boolean flag = articleService.saveEdit(articles);
				response.getWriter().write("{\"isFinish\":" + flag + "}");
			} else {
				response.getWriter().write("{\"isFinish\":null}");
			}
		}
	}

    public JGitUtil getjGitUtil() {
        return jGitUtil;
    }

    public void setjGitUtil(JGitUtil jGitUtil) {
        this.jGitUtil = jGitUtil;
    }
}
