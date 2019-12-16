<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
</head>
	<div class="row" style="">
		<div class="col-lg-6 col-xs-6" style="border-radius:0 40px 40px 0;background-color: rgba(255,255,255,0.7);vertical-align: middle;margin-top: 2px;margin-left: 2px;height: 30px;border-bottom: 1px solid #C5C5C5;">
			<img src="<%=basePath%>img/expert.png" style="width: 20px;height: 21px;"/>&nbsp;
			<font size="4">我的资料</font>
		</div>
		
		<div class="col-lg-12 col-xs-12" style="vertical-align: middle;border-top: 1px solid #C5C5C5;">
		
			<img src="<%=basePath%>img/person.png" style="margin-top: 2%;margin-left: 2%;width: 60px;height: 60px;background-color: red;border-radius:50px ;"/>&nbsp;
		
		
			<font size="2" style="font-weight: bold;">${current_user.userName }</font>
			<a data-toggle="modal" data-target="#editDialog" onclick="edituser()"> <span style="float: right;margin-top: 20px;margin-right: 4px;">修改</span></a>
			<img src="<%=basePath%>img/file_edit48.png" style="margin-top: 20px;float: right;width: 15px;height: 15px;"/>
			<div class="col-lg-12 col-xs-10" style="text-align: center;">
				<span style="font-size: 15px;">入坑
				<span style="font-size: 15px;" id="numday">${current_user.joinday }
				<span style="font-size: 15px;">天&emsp;&emsp;&emsp;&emsp;</span>
			</div>
		</div>
		<div class="col-lg-1 col-xs-1" style="margin-top: 3%;"></div>
		<div class="col-lg-10 col-xs-10" style="margin-top: 3%;">
			
			<table style="margin-top: 2%;font-weight: 560;">
						<tr>
							<td>性别:</td>
							<td><span>${current_user.sex }</span></td>
							
						</tr>
						<tr>
							<td>生日：</td>	
							<td><span>${current_user.birthday }</span></td>		
						</tr>
						<tr>
							<td>行业：</td>
							<td><span>${current_user.profession }</span></td>
						</tr>
						<tr>
							<td>金币：</td>
							<td><span>${current_user.gold }</span></td>
						</tr>
						</table>
		</div>
		<div class="col-lg-12 col-xs-12"style="margin-top: 2%;margin-bottom: 2%;">
			<span style="font-size: small; color: #808080;">${current_user.introduction }</span>
		</div>
							
		<div class="col-lg-12 col-xs-12" style="margin-top: 4%; height: 70px;background-color: rgba(255,255,255,0.7);border-top: 1px solid #C5C5C5;border-bottom: 1px solid #C5C5C5;">
					<table class="col-lg-12 col-xs-12" style="margin-top: 2%;text-align: center;">
						<tr >
							<td><a href="myattention.html">关注</a></td>
							<td><a href="myfans.html">粉丝</a></td>
							<td><a href="mymoodshare.html">心情</a></td>
							<td><a href="myarticles.html">文章</a></td>
						</tr>
						<tr>
								<td><a href="myattention.html"><span>${current_user.attention }</span></a></td>
								<td><a href="myfans.html"><span>${current_user.fans }</span></a></td>
								<td><a href="mymoodshare.html"><span>${current_user.moodcount }</span></a></td>
								<td><a href="myarticles.html"><span>${current_user.articlecount }</span></a></td>
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
								<input type="text" class="form-control" id="edit_userName" value="${current_user.userName }" name="userName" readonly="readonly" >
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
<script type="text/javascript">
	document.getElementById('edit_birthday').valueAsDate=document.getElementById('birthday').value;
</script>
</html>