package com.fengf.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fengf.blog.pojo.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fengf.blog.pojo.ArticleQueryVo;
import com.fengf.blog.pojo.UserQueryVo;
import com.fengf.blog.pojo.Users;
import com.fengf.blog.service.UserService;
import com.fengf.common.utils.Page;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	ArticleQueryVo vo =new ArticleQueryVo();
	Users user = new Users();
	//注册页面
	@RequestMapping(value="/register.html",method = RequestMethod.GET)
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="/ProfileBar.html")
	public String ProfileBar(){
		
		return "ProfileBar";
	}
	@RequestMapping(value="/hotuser.html")
	public String hotuser(UserQueryVo vo,Model model){
		Page<Users>  page = userService.selectAllPage(vo);
		model.addAttribute("page", page);
		return "hotuser";
	}
	//我的关注
	@RequestMapping(value="/myattention.html")
	public String myattention(UserQueryVo vo,Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		vo.setUserId(current_user.getUserId());
		Page<Users>  page = userService.selectAllAttentionPage(vo);
		model.addAttribute("page", page);
		return "myattention";
	}

	//我的fans
	@RequestMapping(value="/myfans.html")
	public String myfans(UserQueryVo vo,Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		vo.setUserId(current_user.getUserId());
		Page<Users>  page = userService.selectAllFansPage(vo);
		model.addAttribute("page", page);
		return "myfans";
	}
	//取消关注
	@RequestMapping(value="/deleteAttention.html")
	public void deleteAttention(Integer userId,Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		boolean flag = userService.deleteAttention(current_user.getUserId(),userId);
		response.getWriter().write("{\"isFinish\":"+flag+"}");
	}
	//关注
	@RequestMapping(value="/attention.html")
	public void insertAttention(Integer userId,Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user == null){
			response.getWriter().write("{\"isFinish\":\"null\"}");
		}else{
			boolean flag = userService.insertAttention(current_user.getUserId(),userId);
			response.getWriter().write("{\"isFinish\":"+flag+"}");
		}
	}

	//个人中心
	@RequestMapping(value="/myinformation.html")
	public String myinformation(ArticleQueryVo vo,Integer userId,Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		Users user = new Users();
		if(userId == null ||userId == 0){
			Users current_user = (Users) request.getSession().getAttribute("current_user");
			user = userService.personcenter(current_user.getUserId());
		}
		else {
			user = userService.personcenter(userId);
		}
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		boolean isAttention = userService.getIsAttention(current_user.getUserId(),userId);
		vo.setAuthorId(userId);
		Page<Articles>  page = userService.selectUserAllPage(vo);
		model.addAttribute("page", page);
		model.addAttribute("isAttention", isAttention);
		model.addAttribute("user",user);


		return "userInformation";
	}
	//我的文章
	@RequestMapping(value="/myarticles.html")
	public String myarticles(ArticleQueryVo vo,Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		Users user = userService.personcenter(current_user.getUserId());
		HttpSession session = request.getSession();
		session.setAttribute("current_user", user);
		vo.setAuthorId(current_user.getUserId());
		Page<Articles>  page = userService.selectUserAllPage(vo);
		model.addAttribute("page", page);
		return "myarticles";
	}
	@RequestMapping(value="/personcenter.html")
	public String personcenter(ArticleQueryVo vo,Integer userId,Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		if (userId != null){
			vo.setAuthorId(userId);
			Page<Articles>  page = userService.selectUserAllPage(vo);
			user = userService.personcenter(userId);
			Users current_user = (Users) request.getSession().getAttribute("current_user");
			boolean isAttention =false;
			if(current_user != null){
				isAttention = userService.getIsAttention(current_user.getUserId(),userId);
			}
			model.addAttribute("page", page);
			model.addAttribute("isAttention", isAttention);
			model.addAttribute("user",user);
			return "userInformation";
		}
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		if (current_user != null){
			Users user = userService.personcenter(current_user.getUserId());
			HttpSession session = request.getSession();
			session.setAttribute("current_user", user);
			vo.setAuthorId(current_user.getUserId());
			Page<Articles>  page = userService.selectmyAllPage(vo);
			model.addAttribute("page", page);
			return "personcenter";
		}
		return "404";
	}
	@RequestMapping(value="/personEdit.html")
	public void personEdit(Users user,HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException{
		Users current_user = (Users) request.getSession().getAttribute("current_user");
		current_user.setUserName(user.getUserName());
		current_user.setEmail(user.getEmail());
		current_user.setPhone(user.getPhone());
		current_user.setBirthday(user.getBirthday());
		current_user.setSex(user.getSex());
		current_user.setProfession(user.getProfession());
		current_user.setIntroduction(user.getIntroduction());
		boolean flag=userService.personEdit(current_user);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(flag){
			HttpSession session = request.getSession();
			session.setAttribute("current_user", current_user);
			out.println("<script language='javaScript'> alert('修改成功！');</script>");
			response.setHeader("refresh","0.2;url=index.html");
		}else{
			out.println("<script language='javaScript'> alert('修改失败，请重新登录！');</script>");
			response.setHeader("refresh","0.2;url=userQuit.html");
		}
			
		
	}
	//用户名查重
	@RequestMapping(value="/checkUsername.html",method = RequestMethod.POST)
	public void checkUsername(String userName,HttpServletResponse response) throws IOException{
		boolean flag=userService.checkUsername(userName);
		response.getWriter().write("{\"isExist\":"+flag+"}");
	}
	//核对验证码
	@RequestMapping(value="/checkverificationCode.html")
	public void checkverificationCode(String verificationCode,HttpServletRequest request,HttpServletResponse response) throws IOException{
		boolean flag=false;
		HttpSession session = request.getSession();
		String checkcode_session=(String) session.getAttribute("checkcode_session");
		if(checkcode_session.equals(verificationCode))
			flag=true;
		response.setContentType("text/plain");
		response.getWriter().write("{\"isCorrect\":"+flag+"}");
	}
	
	//注册
	@RequestMapping(value="/userRegister.html")
	public void userRegister(Users user,Model model,HttpServletRequest request,HttpServletResponse response) throws IOException{
		boolean flag=userService.userInsert(user);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(!flag){
			out.println("<script language='javaScript'> alert('注册失败，请重新添加！');</script>");
			response.setHeader("refresh","0.2;url=register.html");
		}else{
			Users current_user=userService.userLogin(user);
			if(current_user ==null){
				out.println("<script language='javaScript'> alert('登录失败，请登录！');</script>");
				response.setHeader("refresh","0.2;url=login.html");
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("current_user", current_user);
				out.println("<script language='javaScript'> alert('注册成功');</script>");
				response.setHeader("refresh","0.2;url=index.html");
			}
		}
	}
	//登录页面
	@RequestMapping(value="/login.html",method = RequestMethod.GET)
	public String login(){
		return "login";
	}

	@RequestMapping(value="/userQuit.html")
	public String userQuit(HttpServletRequest request){
		request.getSession().invalidate();
		return "loginhtml";
	}
	//登录
	@RequestMapping(value="/userLogin.html",method = RequestMethod.POST)
	public String userLogin(Users user,Model model,HttpServletRequest request){
		Users current_user=userService.userLogin(user);
	
		if(current_user ==null){
			model.addAttribute("loginInfo", "密码不正确");
			return "login.html";
		}else{
			
			HttpSession session = request.getSession();
			session.setAttribute("current_user", current_user);
		}
		return "redirect:index.html";
	}
}
