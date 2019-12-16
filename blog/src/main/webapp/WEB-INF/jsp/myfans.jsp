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
<script type="text/javascript" src="<%=basePath%>js/flow.js" ></script>
<script type="text/javascript">
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
</style>
</head>
<body style="background-color: rgb(240,242,245);min-height: 750px;">
	<!--导航栏-->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container"style="margin-top:2%;">
			<div class="row" style="min-height: 600px;">
				<div class="col-lg-3 hidden-xs"style="border-radius:10px;margin-right: 45px;height: 800px;border-bottom: 1px solid #C5C5C5;background-color: rgba(255,255,255,0.7);" id="profilebar"></div>	
				<div class="col-lg-8 col-xs-12" style="border-radius:10px;background-color: rgba(255,255,255,0.7);">
					<div class="row" style="border-bottom: 1px solid #C5C5C5;">
						<div class="col-lg-4 col-xs-4">
							<img src="<%=basePath%>img/hot.png" style="width: 30px;height: 30px;"/>
							<font style="font-weight:bold;font-size:20px;">
								我的fans
							</font>
						</div>
					</div>
					<br />
					
				<div class="row" style="height: 145px;">
					<div class="col-lg-12 col-xs-12" style="border-bottom: 1px solid #C5C5C5;" align="center">
						<form   method="post" action="${pageContext.request.contextPath }/myfans.html" class="form-inline"  id="searchform" >
						<div class="col-lg-8 col-xs-9" style="float:right;text-align: right;margin-bottom: 2%;">
				            <input type="text" class="form-control" style="width: 250px;" placeholder="查询用户"  id="userName" name="userName">
							<input type="submit" class="btn" value="查询">						
						</div> 
				        </form>
					</div>
						<c:forEach items="${page.rows }" var="hotuser"> 
							<div class="col-lg-12 col-xs-12" style="">
								<div class="col-lg-12 col-xs-12" style="margin-bottom: 2%;margin-top: 2%;">
									<img src="<%=basePath%>img/person.png" style="width: 50px;height: 50px;border-radius:25px;background-color: yellow;"/>&nbsp;
										<a href="personcenter.html?userId=${hotuser.userId}"><font style="margin-top: 1%;font-size: large;">${hotuser.userName }</font>&emsp;</a>
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
							</div>
						</c:forEach>
						<div class="col-lg-12 col-xs-12 text-right">
							<fengf:page url="${pageContext.request.contextPath }/myfans.html" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 编辑对话框 -->
		<div class="modal" id="editDialog" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="edit_customer_form" action="personEdit.html" method="post">
							<input type="hidden" id="edit_cust_id" name="cust_id"/>
							<div class="form-group">
								<label for="edit_userName" class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="edit_userName" value="${current_user.userName }" name="userName">
								</div>
							</div>	
							
							<div class="form-group">
								<label for="edit_email" class="col-sm-2 control-label">email</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="edit_email" value="${current_user.email }" name="email">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_phone" class="col-sm-2 control-label">联系方式</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="edit_phone" value="${current_user.phone }" name="phone">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_birthday" class="col-sm-2 control-label">生日</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="edit_birthday" value="${current_user.birthday }" name="birthday">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_sex" class="col-sm-2 control-label">性别</label>
								<div class="col-sm-10">
									
				                     <c:if test="${current_user.sex=='male'}">
				                    	<input type="radio" class="btn btn-success btn-sm" name="sex" id="sex" value="male" checked="checked">男
				                   		<input type="radio" class="btn btn-success btn-sm" name="sex" id="sex" value="female">女
				                     </c:if>
				                    <c:if test="${current_user.sex=='female'}">
				                    	<input type="radio" class="btn btn-success btn-sm" name="sex" id="sex" value="male" >男
				                   		<input type="radio" class="btn btn-success btn-sm" name="sex" id="sex" value="female" checked="checked">女
				                     </c:if>
								</div>
							</div>
							<div class="form-group">
								<label for="edit_profession" class="col-sm-2 control-label">行业</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="edit_profession" value="${current_user.profession }" name="profession">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_introduction" class="col-sm-2 control-label">个人简介</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="edit_introduction" value="${current_user.introduction }" name="introduction">
								</div>
							</div>
							<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" onclick="updateCustomer()">保存修改</button>
					</div>
						</form>
					</div>
					
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		document.getElementById('edit_birthday').valueAsDate=document.getElementById('birthday').value;
</script>
	</body>
</html>