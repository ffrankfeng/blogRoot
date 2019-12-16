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
<title>文章搜索</title>
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
    ! function() {
        //封装方法，压缩之后减少文件大小
        function get_attribute(node, attr, default_value) {
            return node.getAttribute(attr) || default_value;
        }
        //封装方法，压缩之后减少文件大小
        function get_by_tagname(name) {
            return document.getElementsByTagName(name);
        }
        //获取配置参数
        function get_config_option() {
            var scripts = get_by_tagname("script"),
                script_len = scripts.length,
                script = scripts[script_len - 1]; //当前加载的script
            return {
                l: script_len, //长度，用于生成id用
                z: get_attribute(script, "zIndex", -1), //z-index
                o: get_attribute(script, "opacity", 0.5), //opacity
                c: get_attribute(script, "color", "0,0,0"), //color
                n: get_attribute(script, "count", 99) //count
            };
        }
        //设置canvas的高宽
        function set_canvas_size() {
            canvas_width = the_canvas.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,
                canvas_height = the_canvas.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
        }

        //绘制过程
        function draw_canvas() {
            context.clearRect(0, 0, canvas_width, canvas_height);
            //随机的线条和当前位置联合数组
            var e, i, d, x_dist, y_dist, dist; //临时节点
            //遍历处理每一个点
            random_points.forEach(function(r, idx) {
                r.x += r.xa,
                    r.y += r.ya, //移动
                    r.xa *= r.x > canvas_width || r.x < 0 ? -1 : 1,
                    r.ya *= r.y > canvas_height || r.y < 0 ? -1 : 1, //碰到边界，反向反弹
                    context.fillRect(r.x - 0.5, r.y - 0.5, 1, 1); //绘制一个宽高为1的点
                //从下一个点开始
                for (i = idx + 1; i < all_array.length; i++) {
                    e = all_array[i];
                    // 当前点存在
                    if (null !== e.x && null !== e.y) {
                    	
                        x_dist = r.x - e.x; //x轴距离 l
                        y_dist = r.y - e.y; //y轴距离 n
                        dist = x_dist * x_dist + y_dist * y_dist; //总距离, m

                        dist < e.max && (e === current_point && dist >= e.max / 2 && (r.x -= 0.03 * x_dist, r.y -= 0.03 * y_dist), //靠近的时候加速
                            d = (e.max - dist) / e.max,
                            context.beginPath(),
                            context.lineWidth = d / 2,
                            context.strokeStyle = "rgba(" + config.c + "," + (d + 0.2) + ")",
                            context.moveTo(r.x, r.y),
                            context.lineTo(e.x, e.y),
                            context.stroke());
                    
                    }
                }
            }), frame_func(draw_canvas);
        }
        //创建画布，并添加到body中
        var the_canvas = document.createElement("canvas"), //画布
            config = get_config_option(), //配置
            canvas_id = "c_n" + config.l, //canvas id
            context = the_canvas.getContext("2d"), canvas_width, canvas_height,
            frame_func = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function(func) {
                window.setTimeout(func, 1000 / 45);
            }, random = Math.random,
            current_point = {
                x: null, //当前鼠标x
                y: null, //当前鼠标y
                max: 20000 // 圈半径的平方
            },
            all_array;
        the_canvas.id = canvas_id;
        the_canvas.style.cssText = "position:fixed;top:0;left:0;z-index:" + config.z + ";opacity:" + config.o;
        get_by_tagname("body")[0].appendChild(the_canvas);

        //初始化画布大小
        set_canvas_size();
        window.onresize = set_canvas_size;
        //当时鼠标位置存储，离开的时候，释放当前位置信息
        window.onmousemove = function(e) {
            e = e || window.event;
            current_point.x = e.clientX;
            current_point.y = e.clientY;
        }, window.onmouseout = function() {
            current_point.x = null;
            current_point.y = null;
        };
        //随机生成config.n条线位置信息
        for (var random_points = [], i = 0; config.n > i; i++) {
            var x = random() * canvas_width, //随机位置
                y = random() * canvas_height,
                xa = 2 * random() - 1, //随机运动方向
                ya = 2 * random() - 1;
            // 随机点
            random_points.push({
                x: x,
                y: y,
                xa: xa,
                ya: ya,
                max: 6000 //沾附距离
            });
        }
        all_array = random_points.concat([current_point]);
        //0.1秒后绘制
        setTimeout(function() {
            draw_canvas();
        }, 100);
    }();
    $(document).ready(function(){
        $('#InfoBar').load('InfoBar.html');
    })
</script>
		<!--导航栏-->
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container" style="margin-top:2%;">
			
			<div class="row" style="height: 800px;">
				<div class="col-lg-8 col-xs-12"style="height: 800px;">
					<div class="row" style="height: 30px;">
						<div class="col-lg-4" style="background-color:rgba(255,255,255,0.7);border-radius: 10px;">
							<img src="<%=basePath%>img/reading.png" style="width: 40px;height: 40px;"/>
							<span style="font-weight:bold;font-size:large;">
								搜索
							</span>
						</div>
					</div>
					<br />
					<div class="row" style="background-color:rgba(255,255,255,0.7);border-bottom:1px solid #C5C5C5;">
					<div class="col-lg-12 col-xs-12" style="margin-top:2%;border-bottom: 1px solid #C5C5C5;" align="center">
						<c:if test="${!empty search }">
							<form   method="post" action="${pageContext.request.contextPath }/userarticlelist.html?userId=${search} " class="form-inline"  id="searchform" >
						</c:if>
						<c:if test="${empty search }">
							<form   method="post" action="${pageContext.request.contextPath }/userarticlelist.html" class="form-inline"  id="searchform" >
						</c:if>

						<div class="col-lg-10 col-xs-10" style="text-align: right;margin-bottom: 2%;">
				            <input type="text" class="form-control"style="width: 100%" id="title" name="title">
				        </div>
				        <div class="col-lg-2 col-xs-2" style="text-align: left;margin-bottom: 2%;">
				            <input type="submit" class="btn" value="查询">
				        </div>
				        </form>
					</div>
					</div>
					<c:if test="${!empty page.rows }">
					<c:forEach items="${page.rows }" var="article">
						<div class="row" style="background-color:rgba(255,255,255,0.7);height: 145px;border-bottom:1px solid #C5C5C5;padding-right: 20px;">
							<a href="showarticle.html?articleId=${article.articleId }">
								<div class="clo-lg" style="margin-top:2%;margin-left: 2%;">
									<h3 class="line-limit-length" style="font-weight:bold;">
											${article.title }
									</h3>
									<div class="col-lg line-limit-length" style="height:40px ;width:100%; color: #808080;rgba(255,255,255,0.7)-space: nowrap;overflow: hidden;text-overflow: ellipsis;">
											${article.content }
									</div>
									<div class="col-lg" style="">
										<div class="col-lg-4 col-xs-6">
											<img src="<%=basePath%>img/person.png" style="width: 20px;height: 20px;"/>&nbsp;
											<font style="margin-top: 1%;">${article.author }</font>
										</div>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
					</c:if>
					<c:if test="${empty page.rows }">
						<div class="row" style="background-color:rgba(255,255,255,0.7);height: 145px;border-bottom:1px solid #C5C5C5;padding-right: 20px;">
								<div class="clo-lg" style="margin-top:2%;margin-left: 2%;">
									<h3 class="line-limit-length" style="font-weight:bold;color: red">
											暂时没有查询到相关内容
									</h3>
								</div>
						</div>
					</c:if>
					<div class="col-md-12 text-right">
						<fengf:page url="${pageContext.request.contextPath }/userarticlelist.html" />
					</div>
				</div>
				<div class="col-lg-3 hidden-xs"style="margin-left: 15px; height: 800px;" id="InfoBar">
				</div>
			</div>
		</div>
	</body>
</html>