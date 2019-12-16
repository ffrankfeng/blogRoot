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
<title>会员登录</title>
<!-- 引入Bootstrap核心样式文件 -->
<link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/customize.css" rel="stylesheet">	
<!-- 引入jQuery核心js文件 -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/alertStyle.js"></script>
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
	.qiqiu{ position:fixed; width:100px; height:200px;}
	.qiqiu div{ width:70px; height:65px; background:url(<%=basePath%>images/730e0cf3d7ca7bcbbc1b79c0bf096b63f724a8f9.png) no-repeat center center; padding:15px 5px 0; text-align:center; margin:0 auto; background-size:100% auto;}
	.qiqiu img{ width:100%; height:auto; display:block;}
	
	.qiqiu1{ bottom:-200px; left:100px;animation: myfirst 20s linear infinite; z-index:2222;animation-delay:0s;-webkit-animation: myfirst 20s linear infinite; z-index:2222;-webkit-animation-delay:0s; }
	.qiqiu2{ bottom:-200px; left:300px;animation: myfirst2 22s 1s linear infinite;animation-delay:2s;width:70px;-webkit-animation: myfirst2 22s 1s linear infinite;-webkit-animation-delay:2s;}
	.qiqiu3{ bottom:-200px; left:450px;animation: myfirst3 22.2s linear infinite; z-index:2222;animation-delay:3s;-webkit-animation: myfirst3 22.2s linear infinite;-webkit-animation-delay:3s; }
	.qiqiu4{ bottom:-200px; left:600px;animation: myfirst4 21s 0.2s linear infinite; z-index:2222;animation-delay:5s;-webkit-animation: myfirst4 21s 0.2s linear infinite;-webkit-animation-delay:5s; }
	.qiqiu5 div{ width:50px; height:55px; padding: 5px 5px 0; margin:0 auto}
	.qiqiu2 div{ width:60px; height:65px; padding: 5px 5px 0; margin:0 auto}
	
	.qiqiu5{ bottom:-200px; left:1250px;animation: myfirst5 19.5s 1.2s linear infinite;animation-delay:4s;width:60px;}
	.yun{ position:fixed;}
	.yun1{ z-index:-999; width:567px; height:185px; background:url(<%=basePath%>images/yun1.png) no-repeat center center; left:760px; top:118px;animation: myfirst6 50s linear infinite;-webkit-animation: myfirst6 50s linear infinite;}
	.yun2{ z-index:-999; width:605px; height:253px; background: url(<%=basePath%>images/yun2.png) no-repeat center center; left:100px; top:49px;animation: myfirst7 50s linear infinite;-webkit-animation: myfirst7 50s linear infinite;}
	.yun3{ z-index:-999; width:348px; height:226px; background: url(<%=basePath%>images/yun3.png) no-repeat center center; left:50px; top:300px;animation: myfirst8 50s linear infinite;-webkit-animation: myfirst8 50s linear infinite;}
	.yun4{ z-index:-999; width:786px; height:362px; background:url(<%=basePath%>images/yun4.png) no-repeat center center; left:562px; top:233px;animation: myfirst9 50s linear infinite;-webkit-animation: myfirst9 50s linear infinite;}
	@keyframes myfirst
	{
	from {bottom: -200px;}
	to {bottom: 800px;}
	}
	@keyframes myfirst2
	{
	from {bottom: -200px;}
	to {bottom: 850px;}
	}
	@keyframes myfirst3
	{
	from {bottom: -200px;}
	to {bottom: 820px;}
	}
	@keyframes myfirst4
	{
	from {bottom: -200px;}
	to {bottom: 780px;}
	}
	@keyframes myfirst5
	{
	from {bottom: -200px;}
	to {bottom: 830px;}
	}
	@keyframes myfirst6
	{
	from {left: 760px;}
	to {left: 1250px;}
	}
	@keyframes myfirst7
	{
	from {left: 100px;}
	to {left: 400px;}
	}
	@keyframes myfirst8
	{
	from {left: 50px;}
	to {left: 350px;}
	}
	@keyframes myfirst9
	{
	from {left: 562px;}
	to {left: 1000px;}
	}
	@-webkit-keyframes myfirst
	{
	from {bottom: -200px;}
	to {bottom: 800px;}
	}
	@-webkit-keyframes myfirst2
	{
	from {bottom: -200px;}
	to {bottom: 850px;}
	}
	@-webkit-keyframes myfirst3
	{
	from {bottom: -200px;}
	to {bottom: 820px;}
	}
	@-webkit-keyframes myfirst4
	{
	from {bottom: -200px;}
	to {bottom: 780px;}
	}
	@-webkit-keyframes myfirst5
	{
	from {bottom: -200px;}
	to {bottom: 830px;}
	}
	@-webkit-keyframes myfirst6
	{
	from {left: 760px;}
	to {left: 1250px;}
	}
	@-webkit-keyframes myfirst7
	{
	from {left: 100px;}
	to {left: 400px;}
	}
	@-webkit-keyframes myfirst8
	{
	from {left: 50px;}
	to {left: 350px;}
	}
	@-webkit-keyframes myfirst9
	{
	from {left: 562px;}
	to {left: 1000px;}
	}
</style>
</head>
<script type="text/javascript">
function changeImg(obj){
	obj.src="${pageContext.request.contextPath}/checkcode.html?time="+new Date().getTime();
};
$(function(){
	//为输入框绑定事件
	$("#username").blur(function(){
		//1、失去焦点获得输入框的内容
		var usernameInput=$(this).val();
		//2、去服务器端校验用户名是否存在--ajax
		var usernameInfo="";
		$.post(
			"${pageContext.request.contextPath}/checkUsername.html",
			{"userName":usernameInput},
			function(data){
				var isExist=data.isExist;
				//3、根据返回的isExist动态显示信息
				if(isExist){
					usernameInfo="用户不存在";
					$("#usernameInfo").css("color","red");
			 	}
				$("#usernameInfo").html(usernameInfo);
			},
			"json"
		);
	});
});

$(function(){
    var v=document.getElementById("verificationCodeConfirm");
    v.style.display="none";
    $("#verificationCode").blur(function(){
        var verInput=$("#verificationCode").val();
        if(verInput.length==0){
            alert("请输入验证码！");
        }
    });

	$("#verificationCode").keyup(function(){
		//1、失去焦点获得输入框的内容
		var checkcodeInput=$("#verificationCode").val();
		$.post(
			"${pageContext.request.contextPath}/checkverificationCode.html",
			{"verificationCode":checkcodeInput},

			function(data){
				var isCorrect=data.isCorrect;
				//3、根据返回的isExist动态显示信息
				if(isCorrect){
                    var v=document.getElementById("verificationCodeConfirm");
                    v.style.display="inline";
					$("#verificationCodeConfirm").attr("src","<%=basePath%>img/sign-check-icon.png");
			 	}else{
                    var v=document.getElementById("verificationCodeConfirm");
                    v.style.display="inline";
			 		$("#verificationCodeConfirm").attr("src","<%=basePath%>img/sign-error-icon.png");
				}
		},
			"json"
		);
	});

});
function submitform(){
	var blog=true;
	var usernameInfo=$("#usernameInfo").text();
	var verificationCodeInput=document.getElementById("verificationCodeConfirm").src;
	if(usernameInfo.indexOf("用户不存在")>=0){
		alert("用户不存在");
		blog=false;
	}
	if(verificationCodeInput.indexOf("check")<0){
		alert("验证码不正确");
		blog=false;
	}
	return blog;
};

</script>
<body>
	<!--导航栏-->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="margin-top:2%;">
			<div class="row" style="margin-top: 1%;" >
				<div class="col-lg-7"></div>
				<div class="col-lg-5 col-xs-12"align="center"style="border-radius:10px;background-color: rgba(255,255,255,0.8);text-align: center;font-size: 200%;">
					<div class="row" style="margin-top: 4%;vertical-align: middle;align-items: center;">
						<img src="<%=basePath%>img/login14.png" style="width: 30px;height: 30px;"/>
						<font style="font-weight: bold;">帐号登录</font>
					</div>
					<div class="row" style="margin-top: 4%;">
						<div class="col-lg-1 hidden-xs"></div>
						<div class="col-lg-11 col-xs-12" ><!-- onsubmit="return submitform()" -->
							<form class="bs-example bs-example-form" action="${pageContext.request.contextPath}/userLogin.html" method="post" onsubmit="return submitform()" >
								<div class="row">
									<div class="col-lg-8 col-xs-8" >
								 		<div class="form-group" style="margin-top: 2%;">
		           							<input type="text" class="form-control" placeholder="请输入用户名" id="username" name="userName">
								 		</div>
								 	</div>
								 	<div class="col-lg-4 col-xs-4" style="text-align: left;margin-top: 2%">
								 		<span style="font-size:initial;" id="usernameInfo"></span>
								 		<!--<img src="img/sign-check-icon.png" style="width: 20px;height: 20px;" />-->
								 	</div>
							 	</div>
							 	<div class="row" style="margin-top: 2%;">
								 	<div class="col-lg-8 col-xs-8" >
								 		<div class="form-group"style="margin-top: 2%;">
		           							<input type="password" class="form-control" placeholder="请输入密码"id="password" name="userPassword">
								 		</div>
								 	</div>
								 	<div class="col-lg-4 col-xs-4" style="text-align: left;">
								 		<span style="font-size: small;" id="passwordConfirm"></span>
								 		<!--<img src="img/sign-check-icon.png" style="width: 20px;height: 20px;" />-->
								 	</div>
							 	</div>
							 	<div class="row" style="margin-top: 2%;">
							 		<div class="col-lg-4 col-xs-4" >
									 	<div class="form-group" style="float: left;">
			           						<input type="text" class="form-control" placeholder="请输入验证码" id="verificationCode" name="verificationCode">
									 	</div>
									</div>
								 	<div class="col-lg-4 col-xs-4" >
								 		<img onclick="changeImg(this)" src="${pageContext.request.contextPath}/checkcode.html">
								 	</div>
								 	<div class="col-lg-2 col-xs-2" style="text-align: left;">
								 		<!--<span style="font-size: initial;" >验证码不正确</span>-->
								 		<img src="" id="verificationCodeConfirm" style="width: 20px;height: 20px;margin-top: 10%;"/>
								 	</div>
							 	</div>
							 	<div class="row" style="margin-top: 2%;margin-bottom: 4%;">
							 	<div class="col-lg-1 col-xs-1"></div>
								 	<div class="col-lg-6 col-xs-6" style="margin-top: 2%;">
								 		<span style="font-size:18px;color: red">${loginInfo}</span>
								 	</div>
									<div class="col-lg-8 col-xs-8" style="margin-top: 2%;float: right;">
										<a href="register.html" style="font-size: small;color: green;">去注册...</a>
									</div>
							 	</div>
							 	<div class="row" style="margin-top: 2%;margin-bottom: 4%;">
								 	<div class="col-lg-4 col-xs-4"></div>
								 	<div class="col-lg-3 col-xs-4" style="margin-top: 2%;">
								 		<input type="submit" class="btn btn-block" style="background-color: brown;color: white;" value="登录"/>
								 	</div>
							 	</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="qiqiu1 qiqiu">
	    	<img src="<%=basePath%>images/201101ddd22135412367.png"/>
	        <div class="text"></div>
	    </div>
	    	<div class="qiqiu2 qiqiu">
	    	<img src="<%=basePath%>images/201101asdsaf22135412367.png"/>
	        <div class="text"></div>
	    </div>
	    	<div class="qiqiu3 qiqiu">
	    	<img src="<%=basePath%>images/20110122135s412367.png"/>
	        <div class="text"></div>
	    </div>
	    	<div class="qiqiu4 qiqiu">
	    	<img src="<%=basePath%>images/20110122135aaaaa412367.png"/>
	        <div class="text"></div>
	    </div>
	    	<div class="qiqiu5 qiqiu">
	    	<img src="<%=basePath%>images/20110122135412367.png"/>
	        <div class="text"></div>
	    </div>
		<div class="yun1 yun"> </div>
		<div class="yun2 yun"> </div>
		<div class="yun3 yun"> </div>	
		<div class="yun4 yun"> </div>        
	</body>
</html>