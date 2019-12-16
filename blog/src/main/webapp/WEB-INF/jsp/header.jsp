<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fengf" uri="http://fengf.com/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!-- 引入Bootstrap核心样式文件 -->
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/customize.css" rel="stylesheet">	
<!-- 引入jQuery核心js文件 -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/alertStyle.js"></script>
<div class="">
			<nav class="navbar navbar-default" style="border-radius:0px;margin-bottom: 0px;">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					    </button>
						<a class="navbar-brand" href="index.html">首页</a>
						<a class="navbar-brand hidden-lg" href="userarticlelist.html"><img src="<%=basePath%>img/search.png" style="width: 18px;height: 18px;" /></a>
						<c:if test="${empty current_user }">
							<a class="navbar-brand hidden-lg" href="login.html"><img src="<%=basePath%>img/person.png" style="width: 18px;height: 18px;" /></a>
						</c:if>
						<c:if test="${!empty current_user }">
							<a class="navbar-brand hidden-lg" href="personcenter.html"><img src="<%=basePath%>img/person.png" style="width: 18px;height: 18px;" /></a>
						</c:if>

					</div>

					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">

							<li>
								<a href="hotuser.html">热门博主</a>
							</li>
							<li>
								<a href="moodshare.html">心情站</a>
							</li>
							<li>
								<a href="forward.html">畅玩聊天室</a>
							</li>
							<li class="visible-xs">
								<a href="${pageContext.request.contextPath }/userQuit.html">退出</a>
							</li>
						</ul>
						<div class="nav navbar-nav navbar-right visible-lg" style="padding-top: 15px;">
							<c:if test="${empty current_user }">
								<a href="login.html">登录</a>
								<a href="register.html">注册</a>
							</c:if>

							<c:if test="${!empty current_user }">
								<a href="personcenter.html"><img src="<%=basePath%>img/person.png" style="width: 20px;height: 20px;" /></a>
								<a href="${pageContext.request.contextPath }/userQuit.html" style="margin-left: 2px">退出</a>
							</c:if>
						</div>
						<form class="navbar-form navbar-right visible-lg" method="post" action="${pageContext.request.contextPath }/userarticlelist.html" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search" id="title" name="title">
								<input type="submit" class="btn btn-default" style="" value="搜索" />
							</div>
							<!--<button type="submit" class="btn btn-default">Submit</button>-->
						</form>
						<div class="nav navbar-nav navbar-right" >
							<ul class="nav navbar-nav">
								<li>
									<a href="writing.html" class="navbar-left"><img src="<%=basePath%>img/write.png" style="width: 18px;height: 18px;" />
										<span>写文章</span>
									</a>
								</li>
								<li>
									<a href="mymoodshare.html" class="navbar-left"><img src="<%=basePath%>img/mood.png" style="width: 18px;height: 18px;" />
										<span>发心情</span>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</nav>
		</div>