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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>我的文章</title>
<link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<!-- 引入Bootstrap核心样式文件 -->
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/customize.css" rel="stylesheet">	
<!-- 引入jQuery核心js文件 -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/flow.js" ></script>
<script>
        $(document).ready(function(){
            $('#profilebar').load('ProfileBar.html');
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
	.line-limit-length {
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap; //文本不换行，这样超出一行的部分被截取，显示...
	}

</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container"style="margin-top:2%;">
			<div class="row" style="min-height: 600px;">
			<div class="col-lg-3 hidden-xs"style="border-radius:10px;height: 800px;border-bottom: 1px solid #C5C5C5;background-color: rgba(255,255,255,0.7);margin-right: 45px;" id="profilebar"></div>
				<div class="col-lg-8 col-xs-12" style="border-radius:10px;background-color: rgba(255,255,255,0.7);" id="myariclebar">
					<div class="row" style="border-bottom: 1px solid #C5C5C5;">
						<div class="col-lg-4">
							<img src="<%=basePath%>img/reading.png" style="width: 40px;height: 40px;"/>
							<span style="font-weight:bold;font-size:large;">
								我的文章
							</span>
						</div>
					</div>
					<br />
					<c:forEach items="${page.rows }" var="article">
						<a href="showarticle.html?articleId=${article.articleId }">
						<div class="row line-limit-length" style="background-color:rgba(255,255,255,0.7);height: 145px;border-bottom:1px solid #C5C5C5;padding-right: 20px;">
							<div class="clo-lg-12" style="margin-top:2%;margin-left: 2%;">
								<h3 class="line-limit-length" style="font-weight:bold;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
									${article.title }
								</h3>
								<div class="col-lg" style="height:30px ;color: #808080;rgba(255,255,255,0.7)-space: nowrap;overflow: hidden;text-overflow: ellipsis;">
									${article.content}
								</div>
								<div class="col-lg" style="margin-top: 1%;">
									<div class="col-lg-4 hidden-xs">
										<img src="<%=basePath%>img/person.png" style="width: 20px;height: 20px;"/>&nbsp;
										<font style="margin-top: 1%;">${article.author}</font>
									</div>
									<div class="col-lg-3"style="float: right;">
										<span id="readCount">${article.reading}</span><span> 阅读</span>&nbsp;
										<span id="comCount">${article.commentcontent}</span><span> 评论</span>
									</div>
								</div>
							</div>
						</div></a>
					</c:forEach>
					<div class="col-md-12 text-right">
						<fengf:page url="${pageContext.request.contextPath }/myarticles.html" />
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>