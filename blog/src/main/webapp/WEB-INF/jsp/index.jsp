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
<title>博客-与你分享我的世界</title>

<!-- 引入Bootstrap核心样式文件 -->
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/customize.css" rel="stylesheet">
<link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
<!-- 引入jQuery核心js文件 -->
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/alertStyle.js"></script>
<script type="text/javascript" src="<%=basePath%>js/flow.js" >
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
	.my-navbar {
		background-color: rgba(255,255,255,0.3);
		position: fixed;
	    z-index: 1;
	    top: 45px;
	    left: 100px;
	    overflow-x: hidden;
	    padding: 8px 0;
	    border-radius: 10px;
	}
	.my-navbar a:hover{
		 	color:#777777 !important;
		 	background:transparent;
		 	outline:0;
	}
	.nav-pills > li.active > a, .nav-pills > li.active > a:hover, .nav-pills > li.active > a:focus{
		color: #000000;
		background-color: rgba(255,255,255,0);
	}
	.active{
		text-align: center;
		font-size: 15px;
	}
	.my-navbar a{
		text-align: center;
	}
	.my-col-lg-3{
		
	}
		.line-limit-length {
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap; //文本不换行，这样超出一行的部分被截取，显示...
		}
</style>
</head>
<body>
<script type="text/javascript" src="<%=basePath%>js/flow.js" ></script>
		<!--导航栏-->
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container" style="margin-top:2%;">
			<div class="row" style="height: 800px;">
				<div class="col-lg-2 hidden-xs" style="display: block;">
		            <ul class="nav nav-pills nav-stacked my-navbar">
		                <li class="active"><a href="#">分类</a></li>
						<c:forEach items="${categoryList}" var="category">
							<li><a href="index.html?topic=${category.categoryId}">${category.categoryName}</a></li>
						</c:forEach>
		            </ul>
                </div>
				<div class="col-lg-6 col-xs-12"style="display:block;height: 800px;background-color: rgba(255,255,255,0.3);border-radius: 10px;">
					<div class="row" style="height: 30px;">
						<div class="col-lg-4" style="background-color:rgba(255,255,255,0);">
							<img src="<%=basePath%>img/reading.png" style="width: 40px;height: 40px;"/>
							<span style="font-weight:bold;font-size:large;">
								精品文章
							</span>
						</div>
					</div>
					<br />
					<c:forEach items="${page.rows }" var="article"> 
						<div class="row" style="background-color:rgba(255,255,255,0.7);height: 145px;border-bottom:1px solid #C5C5C5;">
							<div class="clo-lg" style="margin-top:2%;margin-left: 2%;">
								<h3 class="line-limit-length" style="font-weight:bold;">
									<a href="showarticle.html?articleId=${article.articleId }">${article.title }</a>
								</h3>
								<div class="col-lg" style=" width:95%; height:40px ; color: #808080;rgba(255,255,255,0.7)-space: nowrap;overflow: hidden;text-overflow: ellipsis;">
									${article.content }
								</div>
								<div class="col-lg" style="margin-top: 1%;">
									<div class="col-lg-4 hidden-xs">
										<img src="<%=basePath%>img/person.png" style="width: 20px;height: 20px;"/>&nbsp;
										<font style="margin-top: 1%;">${article.author }</font>
									</div>
									<div class="col-lg-3"style="float: right;">
										<span id="readCount">${article.reading }</span><span> 阅读</span>&nbsp;
										<span id="comCount">0</span><span> 评论</span>
										
									</div>
								</div>
							</div>
						</div>

					</c:forEach>
					<div class="col-md-12 text-right">
						<fengf:page url="${pageContext.request.contextPath }/index.html" />
					</div>
				</div>
				<div class="col-lg-3 hidden-xs my-col-lg-3"style="display:block;margin-left: 15px; height: 800px;background-color: rgba(255,255,255,0.3);border-radius: 10px;" id="InfoBar">

				</div>
			</div>
		</div>
		<script type="text/javascript">
            function selectArticlesByCategory(categoryId){
                $.post(
                    "${pageContext.request.contextPath}/index.html",
                    {"categoryId":categoryId},
                    function(data){
                        var isFinish=data.isFinish;
                        console.log(isFinish);
                        if (isFinish == "null"){
                            // window.location.href="login";
                            window.open("login.html","_blank");
                        }else if(isFinish == false){
                            alert("关注失败");
                        }else{
                            alert("关注成功");
                            location.reload();
                        }
                    },
                    "json"
                );
			}
            $(document).ready(function(){
                $('#InfoBar').load('InfoBar.html');
            })

			document.addEventListener('scroll', function (event) {
			    var scrollDistance = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
			    if (scrollDistance >= 280) {    // 触发的位置
			        document.getElementsByClassName('my-col-lg-3')[0].style.cssText = 'margin-left: 15px;width:292.5px;background-color: rgba(255,255,255,0.3);border-radius: 10px;display:inline-block;position:fixed;bottom:0px;';
			    } else {
			        document.getElementsByClassName('my-col-lg-3')[0].style.cssText = 'margin-left: 15px;width:292.5px;background-color: rgba(255,255,255,0.3);border-radius: 10px;position:static;';
			    }
			});
            var _maq = _maq || [];
            _maq.push(['_setAccount', 'testname']);
            (function() {
                var ma = document.createElement('script'); ma.type = 'text/javascript'; ma.async = true;
                ma.src = ('https:' == "<%=basePath%>js/ma.js");
                var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ma, s);
            })();
		</script>
	</body>
</html>