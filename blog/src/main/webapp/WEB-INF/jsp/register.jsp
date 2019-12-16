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
<title>会员注册</title>

<!-- 引入Bootstrap核心样式文件 -->
    <link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/customize.css" rel="stylesheet">	
<!-- 引入jQuery核心js文件 -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/alertStyle.js" ></script>
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
	.alert_btn {
	    background-color: #F5F5F5;
	    background-image: linear-gradient(to bottom, #FFFFFF, #E6E6E6);
	    background-repeat: repeat-x;
	    border-bottom: 0 none #B3B3B3;
	    border-radius: 4px;
	    border-right: 0 none #E6E6E6;
	    border-top: 0 none #E6E6E6;
	    box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px rgba(0, 0, 0, 0.05);
	    color: #333333;
	    cursor: pointer;
	    display: inline;
	    font-size: 14px;
	    line-height: 20px;
	    margin-bottom: 0;
	    padding: 4px 12px;
	    text-align: center;
	    text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
	    vertical-align: middle;
	}
	a, input[type="button"] {
	    border-left: 1px none;
	}
	a {
	    color: #007FBF;
	    outline: medium none;
	    text-decoration: none;
	}
	a {
	    color: #0088CC;
	    text-decoration: none;
	}
	.alert-bg {
	    background-color: #999999;
	    bottom: 0;
	    left: 0;
	    position: fixed;
	    right: 0;
	    top: 0;
	    z-index: 1100;
	    opacity: 0.3;
	}
	
	.alert-wnd {
	    width: 320px;
	    height: 120px;
	    margin-left: -160px;
	    margin-top: -160px;
	    box-shadow: 5px 5px 5px #AAAAAA;
	    left: 50%;
	    top: 50%;
	    z-index: 1110;
	    background-color: #ffffff;
	    font-family: 'Microsoft YaHei';
	    font-size: 12px;
	    opacity: 1;
	    position: fixed;
	    border: none;
	    border-radius:10px ;
	}
	
	.alert-wnd .alert-head {
        height: 24px;
        line-height: 24px;
        font-size: 15px;
        text-align: left;
        -webkit-border-top-left-radius:10px ;
        -webkit-border-top-right-radius:10px ;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        font-weight: 600;
        background-image: -moz-linear-gradient(top, #B0E0E6, #AFEEEE); /* Firefox */
        background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #B0E0E6), color-stop(1, #AFEEEE)); /* Saf4+, Chrome */
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#B0E0E6', endColorstr='#AFEEEE', GradientType='0'); /* IE*/
    }
	
    .alert-wnd .alert-body {
        height: 60px;
    }
	
	        .alert-wnd .alert-body .alert-icon {
	            width: 200px;
	            height: 60px;
	            float: left;
	        }
	
	        .alert-wnd .alert-body .alert-msg {
	            float: left;
	            width: 310px;
	            height: 60px;
	        }
	
	            .alert-wnd .alert-body .alert-msg p {
	                width: 310px;
	                text-align: center;
	                font-size: 15px;
	                padding-top: 10px;
	            }
	.alert_btn {
	    background-color: #F5F5F5;
	    background-image: linear-gradient(to bottom, #FFFFFF, #E6E6E6);
	    background-repeat: repeat-x;
	    border-bottom: 0 none #B3B3B3;
	    border-radius: 4px;
	    border-right: 0 none #E6E6E6;
	    border-top: 0 none #E6E6E6;
	    box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px rgba(0, 0, 0, 0.05);
	    color: #333333;
	    cursor: pointer;
	    display: inline;
	    font-size: 14px;
	    line-height: 20px;
	    margin-bottom: 0;
	    padding: 4px 12px;
	    text-align: center;
	    text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
	    vertical-align: middle;
	}
	a, input[type="button"] {
	    border-left: 1px none;
	}
	a {
	    color: #007FBF;
	    outline: medium none;
	    text-decoration: none;
	}
	a {
	    color: #0088CC;
	    text-decoration: none;
	}
	/*文飞  20:52:07 */
	.alert_btn:active,
	.alert_btn.active {
	  background-color: #cccccc \9;
	}
	
	.alert_btn:first-child {
	  *margin-left: 0;
	}
	
	.alert_btn:hover,
	.alert_btn:focus {
	  color: #333333;
	  text-decoration: none;
	  background-position: 0 -15px;
	  -webkit-transition: background-position 0.1s linear;
	     -moz-transition: background-position 0.1s linear;
	       -o-transition: background-position 0.1s linear;
	          transition: background-position 0.1s linear;
	}
	
	.alert_btn:focus {
	  outline: thin dotted #333;
	  outline: 5px auto -webkit-focus-ring-color;
	  outline-offset: -2px;
	}
	
	.alert_btn.active,
	.alert_btn:active {
	  background-image: none;
	  outline: 0;
	  -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
	     -moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
	          box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
	}
</style>
</head>
<script type="text/javascript">
function changeImg(obj){
	obj.src="${pageContext.request.contextPath}/checkcode.html?time="+new Date().getTime();
};

$(function(){
	var username=document.getElementById("usernameConfirm");
	username.style.display="none";
	//为输入框绑定事件
	$("#userName").blur(function(){
		//1、失去焦点获得输入框的内容
		var usernameInput=$("#userName").val();
		username.style.display="inline";
		//2、去服务器端校验用户名是否存在--ajax
		$.post(
			"${pageContext.request.contextPath}/checkUsername.html",
			{"userName":usernameInput},
			function(data){
				var isExist=data.isExist;
				var col=document.getElementsByClassName("my-col");
				//3、根据返回的isExist动态显示信息
				if(!isExist){
					$("#usernameConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
					
			 	}else{
			 		if(usernameInput.length<2||usernameInput.length>6){
			 			$("#usernameConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
			 		}
			 		else {
			 			$("#usernameConfirm").attr("src","<%=basePath%>img/sign-check-icon.png");
			 		}
				}
			},
			"json"
		);
	});
	
	$("#verificationCode").blur(function(){
		//1、失去焦点获得输入框的内容
		var checkcodeInput=$("#verificationCode").val();
		$.post(
			"${pageContext.request.contextPath}/checkverificationCode.html",
			{"verificationCode":checkcodeInput},
			function(data){
				var isCorrect=data.isCorrect;
				
				
				if(isCorrect){
				
					$("#verificationCodeConfirm").attr("src","<%=basePath%>img/sign-check-icon.png");
			 	}else{
			 		
			 		$("#verificationCodeConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
				}
			},
			"json"
		);
	});
	var pass=document.getElementById("passwordConfirm");
	pass.style.display="none";
	$("#userPassword").blur(function(){
		var passwordInput=$("#userPassword").val();
		pass.style.display="inline";
		if(passwordInput.length<6||passwordInput.length>12){
			$("#passwordConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
		}
		else $("#passwordConfirm").attr("src","<%=basePath%>img/sign-check-icon.png");
	});
	var e=document.getElementById("emailConfirm");
	e.style.display="none";
	$("#email").blur(function(){
		var emailInput=$("#email").val();
		e.style.display="inline";
		if(emailInput.length<1){
			$("#emailConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
		}
		else $("#emailConfirm").attr("src","<%=basePath%>img/sign-check-icon.png");
	})
	var p=document.getElementById("phoneConfirm");
	p.style.display="none";
	$("#phone").blur(function(){
		var usercaptionInput=$("#phone").val();
		p.style.display="inline";
		if(usercaptionInput.length!=11){
			$("#phoneConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
		}
		else $("#phoneConfirm").attr("src","<%=basePath%>img/sign-check-icon.png");
	});
	var b=document.getElementById("birthdayConfirm");
	b.style.display="none";
	$("#birthday").blur(function(){
		var birthdayInput=$("#birthday").val();
		b.style.display="inline";
		if(birthdayInput.length<1){
			$("#birthdayConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
		}
		else $("#birthdayConfirm").attr("src","<%=basePath%>img/sign-check-icon.png");
	});
	var pcheck=document.getElementById("passwordCheckConfirm");
	pcheck.style.display="none";
	$("#passwordCheck").blur(function(){
		//1、失去焦点获得输入框的内容
		var confirmpwdInput=$(this).val();
		var passwordInput=$("#userPassword").val();
		pcheck.style.display="inline";
		if(confirmpwdInput==passwordInput){
			$("#passwordCheckConfirm").attr("src","<%=basePath%>img/sign-check-icon.png");
	 	}else{
	 		$("#passwordCheckConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
		}
	});
    var v=document.getElementById("verificationCodeConfirm");
    v.style.display="none";
    $("#verificationCode").blur(function(){
        //1、失去焦点获得输入框的内容
        var confirmpwdInput=$(this).val();
        var verInput=$("#verificationCode").val();
        v.style.display="inline";
        if(confirmpwdInput==verInput){
            $("#verificationCodeConfirm").attr("src","../../img/sign-check-icon.png");
        }else{
            $("#verificationCodeConfirm").attr("src","../../img/sign-error-icon.png");
        }
    });
});	
function submitform(){
	var blog=true;
	var usernameInput=document.getElementById("usernameConfirm").src;
	var passwordInput=document.getElementById("passwordConfirm").src;
	var passwordCheckInput=document.getElementById("passwordCheckConfirm").src;
	var emailInput=document.getElementById("emailConfirm").src;
	var phoneInput=document.getElementById("phoneConfirm").src;
	var birthdayInput=document.getElementById("birthdayConfirm").src;
	var verificationCodeInput=document.getElementById("verificationCodeConfirm").src;
	if(usernameInput.indexOf("check")<0){
		alert("用户名不正确");
		blog=false;
	}
	else if(passwordInput.indexOf("check")<0){
		alert("请输入6-12位密码");
		blog=false;
	}
	else if(passwordCheckInput.indexOf("check")<0){
		alert("两次密码不一致");
		blog=false;
	}else if(emailInput.indexOf("check")<0){
		alert("邮箱不能为空");
		blog=false;
	}else if(phoneInput.indexOf("check")<0){
		alert("手机号码不能为空");
		blog=false;
	}
	else if(birthdayInput.indexOf("check")<0){
		alert("出生日期不能为空");
		blog=false;
	}
	else if(verificationCodeInput.indexOf("check")<0){
		alert("验证码不能为空");
		blog=false;
	}
	return blog;
};
</script>
<body style="height: 750px;">
	<!--导航栏-->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="margin-top:2%;">
			<div class="row" style="margin-top: 1%;" >
				<div class="col-lg-1"></div>
				<div class="col-lg-10 col-xs-12"align="center"style="border-radius:10px;background-color: rgba(255,255,255,0.8);text-align: center;font-size: 200%;">
					<div class="row" style="margin-top: 2%;vertical-align: middle;align-items: center;">
						<img src="<%=basePath%>img/sign_up.png" style="width: 30px;height: 30px;"/>
						<font style="font-weight: bold;">欢迎注册</font>
					</div>
					<div class="row" style="margin-top: 2%;">
						<div class="col-lg-3 hidden-xs"></div>
						<div class="col-lg-8 col-xs-12" >
							<form class="bs-example bs-example-form" action="${pageContext.request.contextPath}/userRegister.html" method="post" onsubmit="return submitform()" >
								<div class="row">
									<div class="col-lg-9 col-xs-10" >
								 		<div class="form-group input-group" style="margin-top: 2%;">
								 		
								 			<span class="input-group-addon">用&ensp;户&ensp;名</span>
		           							<input type="text" class="form-control" placeholder="请输入2-6位的用户名" id="userName" name="userName">
								 		</div>
								 	</div>
							 	
								 	<div class="col-lg-3 col-xs-2 my-col" style="text-align: left; ">
								 		<!--<span style="font-size: small;" id="usernameConfirm">用户已存在</span>-->
								 		<img src="" id="usernameConfirm" style="width: 20px;height: 20px;margin-top: 10%;" />
								 	</div>
							 	</div>
							 	<div class="row">
								 	<div class="col-lg-9 col-xs-10" >
								 		<div class="form-group input-group"style="margin-top: 2%;">
								 			<span class="input-group-addon">密&emsp;&emsp;码</span>
		           							<input type="password" class="form-control" placeholder="请输入6-12位的密码"id="userPassword" name="userPassword">
								 		</div>
								 	</div>
								 	<div class="col-lg-3 col-xs-2 my-col" style="text-align: left;">
								 		<!--<span style="font-size: initial;" >密码不合法</span>-->
								 		<img src="" id="passwordConfirm" style="width: 20px;height: 20px;margin-top: 10%;" />
								 	</div>
							 	</div>
							 	<div class="row">
								 	<div class="col-lg-9 col-xs-10" >
									 	<div class="form-group input-group"style="margin-top: 2%;">
									 		<span class="input-group-addon">确认密码</span>
			           						<input type="password" class="form-control" placeholder="请重新输入密码"id="passwordCheck" name="passwordCheck">
									 	</div>
								 	</div>
								 	<div class="col-lg-3 col-xs-2 my-col" style="text-align: left;">
								 		<!--<span style="font-size: initial;" >两次密码不一致</span>-->
								 		<img src="" id="passwordCheckConfirm" style="width: 20px;height: 20px;margin-top: 10%;" />
								 	</div>
							 	</div>
							 	<div class="row">
								 	<div class="col-lg-9 col-xs-10" >
									 	<div class="form-group input-group">
									 		<span class="input-group-addon">邮&emsp;&emsp;箱</span>
			           						<input type="email" class="form-control" placeholder="请输入邮箱" id="email" name="email">
									 	</div>
								 	</div>
								 	<div class="col-lg-3 col-xs-2" style="text-align: left;">
								 		<!--<span style="font-size: initial;" id="emailConfirm">邮箱不合法</span>-->
								 		<img src="" id="emailConfirm" style="width: 20px;height: 20px;margin-top: 10%;"/>
								 	</div>
							 	</div>
							 	<div class="row">
								 	<div class="col-lg-9 col-xs-10" >
									 	<div class="form-group input-group">
									 		<span class="input-group-addon">联系方式</span>
			           						<input type="text" class="form-control" placeholder="请输入手机号码" id="phone" name="phone" onkeyup="value=value.replace(/[^\d]/g,'')">
									 	</div>
									</div>
									<div class="col-lg-3 col-xs-2" style="text-align: left;">
								 		<!--<span style="font-size: initial;" ">手机号码不合法</span>-->
								 		<img src="" id="phoneConfirm" style="width: 20px;height: 20px;margin-top: 10%;"/>
								 	</div>
							 	</div>
							 	<div class="row">
								 	<div class="col-lg-9 col-xs-10" >
									 	<div class="form-group input-group">
									 		<span class="input-group-addon">生&emsp;&emsp;日</span>
			           						<input type="date"  class="form-control" placeholder="请输入您的生日" id="birthday" name="birthday">
									 	</div>
									</div>
									<div class="col-lg-3 col-xs-2 my-col" style="text-align: left;">
								 		<!--<span style="font-size: initial;" >手机号码不合法</span>-->
								 		<img src="" id="birthdayConfirm" style="width: 20px;height: 20px;margin-top: 10%;"/>
								 	</div>
							 	</div>
							 	<div class="row">
								 	<div class="col-lg-9 col-xs-10" >
									 	<div class="form-group input-group">
									 		<span class="input-group-addon">性&emsp;&emsp;别</span>
									 		<div class="col-lg-4 col-xs-6">
			           							<input type="radio"name="sex" value="male" checked="checked"><font style="font-size: initial;">男</font>
												<input type="radio" name="sex" value="female"><font style="font-size: initial;">女</font>
			           						</div>
									 	</div>
									</div>
									<div class="col-lg-3 col-xs-2 my-col" style="text-align: left;">
								 		<!--<span style="font-size: initial;" id="phoneConfirm">手机号码不合法</span>-->
								 		<%-- <img src="<%=basePath%>img/sign-check-icon.png" style="width: 20px;height: 20px;margin-top: 10%;"" /> --%>
								 	</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-lg-6 col-xs-8" >
									 	<div class="form-group input-group" style="float: left;">
									 		<span class="input-group-addon">验&ensp;证&ensp;码</span>
			           						<input type="text" class="form-control" placeholder="请输入验证码" id="verificationCode" name="verificationCode">
									 	</div>
									</div>
								 	<div class="col-lg-3 col-xs-2" >
								 		<img onclick="changeImg(this)" src="${pageContext.request.contextPath}/checkcode.html">
								 	</div>
								 	<div class="col-lg-3 col-xs-2 my-col" style="text-align: left;">
								 		<!--<span style="font-size: initial;" >验证码不正确</span>-->
								 		<img src="" id="verificationCodeConfirm" style="width: 20px;height: 20px;" />
								 	</div>
							 	</div>
							 	<div class="row" style="margin-bottom: 4%;">
								 	<div class="col-lg-4 col-xs-4"></div>
								 	<div class="col-lg-3 col-xs-4" style="margin-top: 10%;">
								 		<input type="submit" class="btn btn-block" style="background-color:#5BC0DE;color: white;"/>
								 	</div>
							 	</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>