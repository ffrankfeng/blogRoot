<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>热门博主</title>
<link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<!-- 引入Bootstrap核心样式文件 -->
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/customize.css" rel="stylesheet">	
<!-- 引入jQuery核心js文件 -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $('#InfoBar').load('InfoBar.html');
})
</script>
<style type="text/css">
	html{
		height:100%;
		width:100%;
	}
	body{ 		  
	    background: -webkit-linear-gradient(#D9EDF7,#AFD9EE ); /* Safari 5.1 - 6.0 */
		background: -o-linear-gradient(#D9EDF7, #AFD9EE); /* Opera 11.1 - 12.0 */
	    background: -moz-linear-gradient(#D9EDF7, #AFD9EE); /* Firefox 3.6 - 15 */
	   	background: linear-gradient(#D9EDF7, #AFD9EE); /* 标准的语法 */ 
		background-size:100% 100%;
		background-attachment:fixed
	}
</style>
</head>
<body>
<script type="text/javascript" src="<%=basePath%>js/flow.js" ></script>
	<!--导航栏-->
	<jsp:include page="header.jsp"></jsp:include>
		<div class="container"style="margin-top:2%;">
			<div class="row" style="min-height: 600px;">
				<div class="col-lg-8 col-xs-12" style="background-color: rgba(255,255,255,0.7);">
					<div class="row" style="border-bottom: 1px solid #C5C5C5;">
						<div class="col-lg-4 col-xs-4" style="border-radius:0 40px 40px 0;vertical-align: middle;">
							<img src="<%=basePath%>img/hot.png" style="width: 30px;height: 30px;"/>
							<font style="font-weight:bold;font-size:20px;">
								HOT
							</font>
						</div>
					</div>
					<br />
				<div class="row" style="height: 145px;">
					<div class="col-lg-12 col-xs-12" style="border-bottom: 1px solid #C5C5C5;" align="center">
						<form   method="post" action="${pageContext.request.contextPath }/hotuser.html" class="form-inline"  id="searchform" >
						<div class="col-lg-8 col-xs-9" style="float:right;text-align: right;margin-bottom: 2%;">
				            <input type="text" class="form-control" style="width: 250px;" placeholder="查询用户"  id="userName" name="userName">
							<input type="submit" class="btn" value="查询">						
						</div> 
				        </form>
					</div>
						<c:forEach items="${page.rows }" var="hotuser"> 
						<a href="personcenter.html?userId=${hotuser.userId}">
							<div class="col-lg-12 col-xs-12" style="">
								<div class="col-lg-12 col-xs-12" style="margin-bottom: 2%;margin-top: 2%;">
									<img src="<%=basePath%>img/person.png" style="width: 50px;height: 50px;border-radius:25px;background-color: #FFFFCC;"/>&nbsp;
										<font style="margin-top: 1%;font-size: large;">${hotuser.userName }</font>&emsp;
										<font style="margin-top: 1%;font-size: small;">${hotuser.introduction }</font>
								</div>
								<div class="col-lg-12 col-xs-12" style="color: #808080;">
									<table style="float: right;">
										<tr>
											<th>文章：</th><th width="12%">${hotuser.articlecount }</th>
											<th>心情：</th><th width="12%">${hotuser.moodcount }</th>
											<th>关注：</th><th width="12%">${hotuser.attention }</th>
											<th>粉丝：</th><th width="12%">${hotuser.fans }</th>
										</tr>
									</table>
									
								</div>
								<div class="col-lg-12 col-xs-12" style="margin-top: 2%;border-bottom: 1px solid #C5C5C5;">
									<div class="col-lg-9 col-xs-9"style="margin-bottom: 2%;"></div>
									<div class="col-lg-3 col-xs-3"style="margin-bottom: 2%;"></div>
								</div>
							</div></a>
						</c:forEach>
						<div class="col-lg-12 col-xs-12 text-right">
							<fengf:page url="${pageContext.request.contextPath }/hotuser.html" />
						</div>
					</div>
				</div>
				<div class="col-lg-3 hidden-xs"style="margin-left: 15px; height: 800px;" id="InfoBar">
				</div>
			</div>
		</div>
	</body>
</html>