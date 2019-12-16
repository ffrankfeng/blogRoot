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
<title>个人中心</title>
<link rel="icon" href="../../img/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<!-- 引入Bootstrap核心样式文件 -->
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/customize.css" rel="stylesheet">
<!-- 引入jQuery核心js文件 -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
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
<script>
    function attention(authorId){
        $.post(
            "${pageContext.request.contextPath}/attention.html",
            {"userId":authorId},
            function(data){
                var isFinish=data.isFinish;
                if (isFinish == "null"){
                    window.open("login.html","_blank");
                }else if(isFinish == false){
                    alert("关注失败");
                }else if(isFinish == true){
                    alert("关注成功");
                    location.reload();
                }
            },
            "json"
        );
    }
    function deleteAttention(authorId){
        if(confirm("确定不再关注ta？")){

            $.post(
                "${pageContext.request.contextPath}/deleteAttention.html",
                {"userId":authorId},
                function(data){
                    var isFinish=data.isFinish;
                    if(isFinish == false){
                        alert("取消关注失败");
                    }else{
                        alert("取消关注成功");
                        location.reload();
                    }
                },
                "json"
            );
        }
    }
</script>
	<!--导航栏-->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container"style="margin-top:2%;">
			<div class="row" style="min-height: 600px;">
			<div class="col-lg-3 col-xs-12"style="border-radius:10px;height: 800px;border-bottom: 1px solid #C5C5C5;background-color: rgba(255,255,255,0.7);" >
				<div class="row" style="">
					<div class="col-lg-6 col-xs-6" style="border-radius:0 40px 40px 0;background-color: rgba(255,255,255,0.7);vertical-align: middle;margin-top: 2px;margin-left: 2px;height: 30px;border-bottom: 1px solid #C5C5C5;">
						<img src="<%=basePath%>img/expert.png" style="width: 20px;height: 21px;"/>&nbsp;
						<font size="4">我的资料</font>
					</div>

					<div class="col-lg-12 col-xs-12" style="vertical-align: middle;border-top: 1px solid #C5C5C5;">

						<img src="<%=basePath%>img/person.png" style="margin-top: 2%;margin-left: 2%;width: 60px;height: 60px;background-color: red;border-radius:50px ;"/>&nbsp;


						<font size="2" style="font-weight: bold;">${user.userName }</font>
						<%--<a data-toggle="modal" data-target="#editDialog" onclick="edituser()"> <span style="float: right;margin-top: 2px;margin-right: 4px;">修改</span></a>--%>
						<%--<img src="<%=basePath%>img/file_edit48.png" style="margin-top: 4px;float: right;width: 15px;height: 15px;"/>--%>
						<c:if test="${isAttention == false}">
							<input type="button" class="btn btn-default" onclick="attention(${user.userId })" style="width:100px;right:2px;color: red;border-color: red;" value="关注" />
						</c:if>
						<c:if test="${isAttention == true}">
							<input type="button" class="btn btn-default" onclick="deleteAttention(${user.userId })" style="width:100px;float: right;margin-right: 2%;margin-top: 5%;color: red;background-color:#FF9966; border-color:#FF9900;" value="已关注" />
						</c:if>
						<div class="col-lg-12 col-xs-10" style="text-align: center;">
							<span style="font-size: 15px;">入坑
							<span style="font-size: 15px;" id="numday">${user.joinday }
							<span style="font-size: 15px;">天&emsp;&emsp;&emsp;&emsp;</span>
						</div>
					</div>
					<div class="col-lg-1 col-xs-1" style="margin-top: 3%;"></div>
					<div class="col-lg-10 col-xs-10" style="margin-top: 3%;">

						<table style="margin-top: 2%;font-weight: 560;">
							<tr>
								<td>性别:</td>
								<td><span>${user.sex }</span></td>

							</tr>
							<tr>
								<td>生日：</td>
								<td><span>${user.birthday }</span></td>
							</tr>
							<tr>
								<td>行业：</td>
								<td><span>${user.profession }</span></td>
							</tr>
							<tr>
								<td>金币：</td>
								<td><span>${user.gold }</span></td>
							</tr>
						</table>
					</div>
					<div class="col-lg-12 col-xs-12"style="margin-top: 2%;margin-bottom: 2%;">
						<span style="font-size: small; color: #808080;">${user.introduction }</span>
					</div>

					<div class="col-lg-12 col-xs-12" style="margin-top: 4%; height: 70px;background-color: rgba(255,255,255,0.7);border-top: 1px solid #C5C5C5;border-bottom: 1px solid #C5C5C5;">
						<table class="col-lg-12 col-xs-12" style="margin-top: 2%;text-align: center;">
							<tr >
								<td><a href="">关注</a></td>
								<td><a href="">粉丝</a></td>
								<td><a href="">心情</a></td>
								<td><a href="">文章</a></td>
							</tr>
							<tr>
								<td><a href=""><span>${user.attention }</span></a></td>
								<td><a href=""><span>${user.fans }</span></a></td>
								<td><a href=""><span>${user.moodcount }</span></a></td>
								<td><a href=""><span>${user.articlecount }</span></a></td>
							</tr>
						</table>

					</div>
				</div>


				<div class="row">
					<div class="col-lg-6 col-xs-6" style="background-color: rgba(255,255,255,0.7);margin-top: 2px;height: 30px;border-radius: 0 40px 40px 0;border-bottom: 1px solid #C5C5C5;">
						<img src="<%=basePath%>img/content.png" style="width: 24px;height: 24px;"/>
						<font size="4" style="text-align: center;">联系我</font>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-xs-12" style="background-color: rgba(255,255,255,0.7);margin-top: 2px;border-top: 1px solid #C5C5C5;">
						<div class="row" >
							<div class="col-lg-12 col-xs-12" style="background-color: rgba(255,255,255,0.7);border-bottom: 1px solid #C5C5C5;margin-top: 2px;margin-bottom: 2px;">
								<img src="<%=basePath%>img/email.png" style="width: 33px;height: 33px;"/>
								<span id="distri" style="font-size:  initial;"> 95111539@qq.com</span><br/>
								<img src="<%=basePath%>img/phone.png" style="width: 33px;height: 33px;"/>
								<span id="distri" style="font-size: initial;"> 15366363203</span><br/>
								<img src="<%=basePath%>img/qq.png" style="width: 33px;height: 33px;"/>
								<span id="distri" style="font-size: initial;"> 951115439</span>
							</div>
						</div>
					</div>
				</div>
			</div>
				<div class="col-lg-8 hidden-xs" style="border-radius:10px;margin-left: 45px;background-color: rgba(255,255,255,0.7);" id="myariclebar">
					<div class="row" style="border-bottom: 1px solid #C5C5C5;">
						<div class="col-lg-4" style="border-radius:0 40px 40px 0;">
							<img src="<%=basePath%>img/reading.png" style="width: 40px;height: 40px;"/>
							<span style="font-weight:bold;font-size:large;">
								我的文章
							</span>
						</div>
					</div>
					<br />
					<c:forEach items="${page.rows }" var="article">
						<a href="showarticle.html?articleId=${article.articleId }">
						<div class="row" style="height: 145px;border-bottom:1px solid #C5C5C5;">
							<div class="clo-lg-12" style="margin-top:2%;margin-left: 2%;">
								<h3 class="line-limit-length" style="font-weight:bold;">
									${article.title }
								</h3>
								<div class="col-lg line-limit-length" style="height:40px ;width:80%;color: #808080;rgba(255,255,255,0.7)-space: nowrap;overflow: hidden;">
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
						<fengf:page url="${pageContext.request.contextPath }/personcenter.html" />
					</div>
				</div>
			</div>
		</div>
	</body>
</html>