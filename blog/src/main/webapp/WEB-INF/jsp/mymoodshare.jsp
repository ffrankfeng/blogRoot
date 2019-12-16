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
<title>我的动态</title>

<!-- 引入Bootstrap核心样式文件 -->
    <link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/customize.css" rel="stylesheet">
<!-- 引入jQuery核心js文件 -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/alertStyle.js"></script>
<script type="text/javascript" src="<%=basePath%>js/flow.js" ></script>
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
	<!--导航栏-->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container"style="margin-top:2%;">

			<div class="row" style="min-height: 600px;">
				<div class="col-lg-3 hidden-xs"style="margin-right: 45px;height: 800px;border-bottom: 1px solid #C5C5C5;background-color: rgba(255,255,255,0.3);border-radius:10px ;"id="profilebar">
				</div>
				<div class="col-lg-8 col-xs-12" style="background-color: rgba(255,255,255,0.3);border-radius:10px">
					<div class="row"">
						<div class="col-lg-4 col-xs-4" style="background-color:rgba(255,255,255,0);border-radius:0 40px 40px 0;vertical-align: middle;">
							<img src="<%=basePath%>img/favourites2.png" style="width: 30px;height: 30px;"/>
							<font style="font-weight:bold;font-size:20px;">
								全部动态
							</font>

						</div>
					</div>
					<br />
					<div class="row" style="background-color:rgba(255,255,255,0.3);height: 145px;">
						<div class="" style="margin-bottom: 4%;border-bottom: 1px solid #C5C5C5;">
							<form name="form" action="${pageContext.request.contextPath }/writeMyMood.html" method="post" enctype="multipart/form-data" onsubmit="return checksubmint()">
								<div class="col-lg-10 col-xs-10" style="margin-bottom: 2%;">
									<textarea style="height: 100%;width: 100%;resize: none; maxlength="100"  onchange="this.value=this.value.substring(0, 100)" onkeydown="this.value=this.value.substring(0, 100)" onkeyup="this.value=this.value.substring(0, 100)"  id="moodContent" name="moodContent" placeholder="想说点什么。。。"></textarea>
								</div>
								<div class="col-lg-2 col-xs-2" >
									<input type="submit" class="btn btn-info" value="发布" style="margin-top:6px;size:70%;font-size: 80%;" />
								</div>

								<div class="box" id="preImg" style="margin-left: 4%;"></div>
								<input type="file" class="btn btn-info" accept="image/*" style="margin-left:3%;margin-bottom:4%; inline-block;" id="moodPic" name="moodPic">


							</form>
						</div>
						<c:forEach items="${page.rows }" var="mood">
							<div class="col-lg-12 col-xs-12" style="margin-bottom: 2%;">
								<div class="col-lg-1 hidden-xs" style="margin-right: 2%;" >
									<img src="<%=basePath%>img/person.png" style="width: 50px;height: 50px;float: left;border-radius:25px;background-color: red;"/>&nbsp;
								</div>
								<div class="col-lg-8 col-xs-12" style="border: 1px solid #C5C5C5;">
									<font style="margin-top: 1%;font-size: small;">${mood.moodDate }</font>
									<div class="col-lg-12 col-xs-12" style="color: #808080;margin-top: 2%;">
										<span>
											${mood.moodContent }
										&nbsp;<br/>&nbsp;
										</span>
										<img src="${mood.moodPic }" class="col-xs-12" style="max-width: 600px;max-height: 600px;"/>
									</div>
									<div class="col-lg-12 col-xs-12" style="margin-top: 2%;border-bottom: 1px solid #C5C5C5;">
										<div class="col-lg-3 col-xs-4"style="float: right;margin-bottom: 2%;">
											<img src="<%=basePath%>img/like3.png" style="width: 20px;height: 20px;" onclick=""/>&nbsp;
											<span style="font-size: large;">${mood.moodLike }</span>&emsp;
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="col-md-12 text-right">
							<fengf:page url="${pageContext.request.contextPath }/mymoodshare.html" />
						</div>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
        function checksubmint(){
            var moodContent =$("#moodContent").val();
            var flag=true;
            if(moodContent==""){
                flag=false;
                alert("请输入文字");
            }

            return flag;
        }
        window.onload = function () {
            //选择图片类型
            var imgType = ["image/jpeg","image/png","image/x-png","image/bmp","image/gif"];

            //回显图片
            var fr = new FileReader(),
                file = document.getElementById("moodPic"),
                img = document.createElement("img");
            img.style="max-width:540px";
            file.onchange = function(e){
                for(var i = 0 ; i < imgType.length ; i++){
                    if(file.files[0].type == imgType[i]){
                        fr.onload = function(e){
                            var res = this.result;
                            img.src = res;

                            document.getElementById("preImg").appendChild(img);//显示
                        };

                        fr.readAsDataURL(file.files[0]);//读取文件
                        break;
                    }
                }
            }
        }
        $(document).ready(function(){
            $('#profilebar').load('ProfileBar.html');
        })
	</script>
	</body>
</html>