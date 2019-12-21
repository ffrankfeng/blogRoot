<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fengf" uri="http://fengf.com/common/" %>
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
    <title>${article.title }</title>
    <link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>css/customize.css" rel="stylesheet">
    <script src="../../js/alertStyle.js"></script>
    <!-- 引入jQuery核心js文件 -->
    <script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
    <style type="text/css">
        body {
            background: -webkit-linear-gradient(#D9EDF7, #AFD9EE); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(#D9EDF7, #AFD9EE); /* Opera 11.1 - 12.0 */
            background: -moz-linear-gradient(#D9EDF7, #AFD9EE); /* Firefox 3.6 - 15 */
            background: linear-gradient(#D9EDF7, #AFD9EE); /* 标准的语法 */
            background-size: 100% 100%;
            background-attachment: fixed
        }

        .line-limit-length {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        / / 文本不换行，这样超出一行的部分被截取，显示 . . .
        }

        .wrap {
            -webkit-animation: cloud 90s linear infinite;
            -o-animation: cloud 90s linear infinite;
        }

        @-webkit-keyframes cloud {
            from {
                background-position: 0% 0%
            }
            to {
                background-position: -2000% -2000%
            }
        }

        img {
            background-size: contain | cover;

            max-width: 100%;

            height: auto;
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
            border-radius: 10px;
        }

        .alert-wnd .alert-head {
            height: 24px;
            line-height: 24px;
            font-size: 15px;
            text-align: left;
            -webkit-border-top-left-radius: 10px;
            -webkit-border-top-right-radius: 10px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            font-weight: 600;
            background-image: -moz-linear-gradient(top, #B0E0E6, #AFEEEE); /* Firefox */
            background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #B0E0E6), color-stop(1, #AFEEEE));
            /* Saf4+, Chrome */
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#B0E0E6', endColorstr='#AFEEEE',
            GradientType='0'); /* IE*/
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

        /*文飞 20:52:07 */
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

        .line-limit-length {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        / / 文本不换行，这样超出一行的部分被截取，显示 . . .
        }
    </style>

    <script type="text/javascript">
        function attention(authorId) {
            $.post(
                "${pageContext.request.contextPath}/attention.html",
                {"userId": authorId},
                function (data) {
                    var isFinish = data.isFinish;
                    console.log(isFinish);
                    if (isFinish == "null") {
                        // window.location.href="login";
                        window.open("login.html", "_blank");
                    } else if (isFinish == false) {
                        alert("关注失败");
                    } else {
                        alert("关注成功");
                        location.reload();
                    }
                },
                "json"
            );
        }

        function deleteAttention(authorId) {

            if (confirm("确定不再关注ta？")) {
                $.post(
                    "${pageContext.request.contextPath}/deleteAttention.html",
                    {"userId": authorId},
                    function (data) {
                        var isFinish = data.isFinish;
                        if (isFinish == false) {
                            alert("取消关注失败");
                        } else {
                            alert("取消关注成功");
                            location.reload();
                        }
                    },
                    "json"
                );
            }
        }

        function likeAndDislike(articleId, flag) {
            if (flag) {
                $.post(
                    "${pageContext.request.contextPath}/likeAndDislike.html",
                    {"flag": flag, "articleId": articleId},
                    function (data) {
                        var isFinish = data.isFinish;
                        if (isFinish == "null") {
                            window.open("login.html", "_blank");
                        } else if (isFinish == false) {
                            alert("操作失败");
                        } else if (isFinish == true) {
                            location.reload();
                        }
                    },
                    "json"
                );
            } else {
                $.post(
                    "${pageContext.request.contextPath}/likeAndDislike.html",
                    {"flag": flag, "articleId": articleId},
                    function (data) {
                        var isFinish = data.isFinish;
                        if (isFinish == "null") {
                            window.open("login.html", "_blank");
                        } else if (isFinish == false) {
                            alert("操作失败");
                        } else if (isFinish == true) {
                            location.reload();
                        }
                    },
                    "json"
                );
            }
        }

        function articlecomment(articleId, author, authorId) {
            var commentContent = $("#commentContent").val();
            var at = commentContent.indexOf("@");
            var flag = commentContent.substring(0, at + 1);
            if (flag == '@' && at == 0) {
                var end = commentContent.indexOf(":");
                var str = commentContent.substring(1, end);
                var str2 = commentContent.substring(end + 1, commentContent.length);
                if ($.trim(str2) == '') {
                    alert("评论内容不能为空");
                    return false;
                } else {
                    $.post(
                        "${pageContext.request.contextPath}/articlecomment.html",
                        {
                            "articleId": articleId,
                            "toUsername": str,
                            "topicType": "reply",
                            "toUid": authorId,
                            "commentContent": str2
                        },
                        function (data) {
                            var isFinish = data.isFinish;
                            if (isFinish == "null") {
                                window.open("login.html", "_blank");
                            } else if (isFinish == false) {
                                alert("评论失败");
                            } else if (isFinish == true) {
                                alert("评论成功");
                                location.reload();
                            }
                        },
                        "json"
                    );
                }
            } else {
                if (commentContent == "") {
                    alert("评论内容不能为空");
                    return false;
                }
                $.post(
                    "${pageContext.request.contextPath}/articlecomment.html",
                    {"articleId": articleId, "toUsername": author, "toUid": authorId, "commentContent": commentContent},
                    function (data) {
                        var isFinish = data.isFinish;
                        if (isFinish == "null") {
                            window.open("login.html", "_blank");
                        } else if (isFinish == false) {
                            alert("评论失败");
                        } else if (isFinish == true) {
                            alert("评论成功");
                            location.reload();
                        }
                    },
                    "json"
                );
            }
        }

        function reply(fromUid, fromUsername) {
            document.getElementById('commentContent').value = "@" + fromUsername + ": ";
            document.getElementById('commentContent').focus();
        }
    </script>
<body>
<script>
    !function () {
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
            canvas_width = the_canvas.width = window.innerWidth || document.documentElement.clientWidth ||
                document.body.clientWidth,
                canvas_height = the_canvas.height = window.innerHeight || document.documentElement.clientHeight ||
                    document.body.clientHeight;
        }

        //绘制过程
        function draw_canvas() {
            context.clearRect(0, 0, canvas_width, canvas_height);
            //随机的线条和当前位置联合数组
            var e, i, d, x_dist, y_dist, dist; //临时节点
            //遍历处理每一个点
            random_points.forEach(function (r, idx) {
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
            frame_func = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame
                || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function (func) {
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
        window.onmousemove = function (e) {
            e = e || window.event;
            current_point.x = e.clientX;
            current_point.y = e.clientY;
        }, window.onmouseout = function () {
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
        setTimeout(function () {
            draw_canvas();
        }, 100);
    }();

</script>
<!--导航栏-->
<jsp:include page="header.jsp"></jsp:include>
<div class="navbar navbar-default" style="margin-top:0px;border-radius:0px;">
    <div class="col-lg-12 col-xs-12 wrap"
         style="padding:0;height: 120px;background-image: url(<%=basePath%>img/cloud.png);background-size: cover;">
        <div id="col-lg-12 col-xs-12" style="margin-top: 35px;">
    <span style="font-weight:bold;font-size:200%;margin-left: 10%;">
    ${article.author }的博文
    </span>
            <c:if test="${isAttention == false}">
                <input type="button" class="btn btn-default" onclick="attention(${article.authorId })" <input
                    type="button" class="btn btn-default"
                    style="width:100px;float: right;margin-right: 20%;border:2px;color: lightskyblue;border-color: lightskyblue;"
                    value="关注"/>
            </c:if>
            <c:if test="${isAttention == true}">
                <input type="button" class="btn btn-default" onclick="deleteAttention(${article.authorId })"
                       style="width:100px;float: right;margin-right: 20%;color: red;background-color:#FF9966; border-color:#FF9900;"
                       value="已关注"/>
            </c:if>

        </div>
    </div>
</div>
<div class="container" style="margin-top:2%;">

    <div class="row" style="min-height: 800px;">

        <div class="col-lg-8 col-xs-12"
             style="min-height: 800px;margin-top: 3%;background-color:rgba(255,255,255,0.7);">
            <div class="col-lg-12 col-xs-12" style="margin-top: 3%;">
    <span style="font-weight:bold;font-size:200%">
        ${article.title }
    </span>
            </div>
            <div class="col-lg-4 col-xs-4" style="margin-top: 2%;">${article.uptime }</div>
            <div class="col-lg-6 col-xs-6" style="margin-top: 2%;">
                <span style="font-size: small;">${article.keyword1 }</span>
                <span style="font-size: small;">${article.keyword2 }</span>
                <span style="font-size: small;">${article.keyword3 }</span>
            </div>
            <div class="col-lg-2 col-xs-2" style="margin-top: 2%;">
                <span style="font-size: small;">阅读:</span>
                <span style="font-size: small;">${article.reading }</span>
            </div>
            <div class="col-lg-12 col-xs-12" style="border-bottom: 1px solid #C5C5C5;"></div>
            <div class="col-lg-12 col-xs-12" id="content"
                 style="argin-top: 4%; margin-top: 3%;margin-bottom:6%;overflow:auto;">
                ${article.content }
                <%--<script>--%>
                    <%--if (${isMarkdown}) {--%>
                        <%--document.getElementById('content').innerHTML =--%>
                            <%--marked('# Marked in the browser\n\nRendered by **marked**.');--%>
                    <%--}--%>

                <%--</script>--%>
            </div>
            <div class="col-lg-4 col-xs-3"></div>
            <c:if test="${articlelike == null}">
                <div class="col-lg-3 col-xs-4" style="vertical-align: middle;">
        <span id="thumbsup" style="font-size: large;"><a onclick="likeAndDislike(${article.articleId },true)">
            <img src="<%=basePath%>img/like3.png" style="width: 30px;height: 30px;" onclick=""/></a>
        &emsp;${article.likecount }</span>
                </div>
                <div class="col-lg-3 col-xs-3" style=" vertical-align: middle;">
        <span id="disthumbsup" style="font-size: large;"><a onclick="likeAndDislike(${article.articleId },false)">
            <img src="<%=basePath%>img/dislike.png" style="width: 30px;height: 30px;"/></a>
        &emsp;${article.dislike }</span>
                </div>
            </c:if>
            <c:if test="${articlelike != null}">
                <c:if test="${articlelike.likeordislike == 'like'}">
                    <div class="col-lg-3 col-xs-4" style="vertical-align: middle;">
            <span id="thumbsup" style="font-size: large;color: red"><img src="<%=basePath%>img/finishlike.png"
                                                                         style="width: 30px;height: 30px;" onclick=""/>
            &emsp;${article.likecount }</span>
                    </div>
                    <div class="col-lg-3 col-xs-4" style=" vertical-align: middle;">
            <span id="disthumbsup" style="font-size: large;"><img src="<%=basePath%>img/dislike.png" style="width:
            30px;height: 30px;"/>
            &emsp;${article.dislike }</span>
                    </div>
                </c:if>

                <c:if test="${articlelike.likeordislike == 'dislike'}">
                    <div class="col-lg-3 col-xs-4" style="vertical-align: middle;">
            <span id="thumbsup" style="font-size: large;"><img src="<%=basePath%>img/like3.png" style="width:
            30px;height: 30px;" onclick=""/>
            &emsp;${article.likecount }</span>
                    </div>
                    <div class="col-lg-3 col-xs-4" style=" vertical-align: middle;">
            <span id="disthumbsup" style="font-size: large;color: #DDDDDD"><img src="<%=basePath%>
            img/finishdislike3.png" style="width: 30px;height: 30px;"/>
            &emsp;${article.dislike }</span>
                    </div>
                </c:if>
            </c:if>

            <div class="col-lg-12 col-xs-12" style="margin-top: 4%;height: 80px;">
                <form name="form" method="post">
                    <div class="col-lg-10 col-xs-10" style="margin-bottom: 2%;">
                        <textarea style="height: 100%;width: 100%;resize: none; maxlength=" 100"
                        onchange="this.value=this.value.substring(0,
                        100)" onkeydown="this.value=this.value.substring(0, 100)"
                        onkeyup="this.value=this.value.substring(0, 100)"
                        id="commentContent" name="commentContent" placeholder="想说点什么。。。"></textarea>

                    </div>
                    <div class="col-lg-2 col-xs-2">
                        <input type="button" class="btn btn-info" style="margin-left: 2%;margin-top: 6px;" value="发布"
                               style="font-size:
    80%;" onclick="articlecomment('${article.articleId}','${article.author }','${article.authorId }')"/>
                    </div>
                </form>

            </div>
            <c:forEach items="${commentList }" var="comment">
                <div class="col-lg-12 col-xs-12"
                     style="margin-top: 2%;margin-bottom: 2%;border-bottom: 1px solid #C5C5C5;">
        <span style="margin-top: 2%;font-size: large;">
                ${comment.fromUsername }
        </span>
                    <span style="margin-top: 2%;margin-left: 4%;">
                            ${comment.commentTime }
                    </span>
                    <a onclick="reply('${comment.fromUid}','${comment.fromUsername }')"><span style="margin-top: 2%;margin-left:
        4%;font-size:small;color: darkblue ">回复</span></a>
                    <br/>
                    <c:if test="${comment.topicType == 'reply'}">
            <span style="margin-top: 2%;margin-left: 1%;">
            @ ${comment.toUsername }:
            </span>
                    </c:if>
                    <span style="margin-top: 2%;margin-left: 1%;">
                            ${comment.commentContent }
                    </span>
                    <div class="col-lg-12 col-xs-12" style="height: 10px"></div>
                </div>
            </c:forEach>
            <div class="col-lg-12 col-xs-12" style="height: 80px"></div>
        </div>
        <div class="col-lg-3 hidden-xs" style="margin-left: 15px; height: 800px;">
            <div class="row">
                <div class="col-lg"
                     style="background-color: rgba(255,255,255,0.7);margin-top: 2px;margin-left: 2px;height: 30px;">
                    <img src="<%=basePath%>img/expert.png" style="width: 20px;height: 21px;"/>&nbsp;
                    <font size="4">个人资料</font>
                </div>
                <div class="col" style="background-color: whitesmoke;margin-top: 2px;margin-left: 2px;">
                    <div class="col-lg" style="height: 70px;background-color: rgba(255,255,255,0.3);">
                        <div class="col-lg" style="margin-left: 2px;">
                            <img src="<%=basePath%>img/person.png"
                                 style="margin-top: 4px;margin-left: 2px;width: 36px;height: 36px;"/>&nbsp;
                            <font size="2" style="font-weight: bold;">${articleAuthor.userName }</font>
                        </div>
                        <div class="col-lg" style="margin-top: 2px;margin-left: 4px">
                            <span style="font-size: small; color: #808080;">${articleAuthor.introduction }</span>
                        </div>
                        <div class="col-lg-12 col-xs-12" style="margin-top: 4%; height: 70px;background-color: rgba(255,255,255,0.7);border-bottom: 1px
    solid #C5C5C5;">
                            <table class="col-lg-12 col-xs-12" style="margin-top: 2%;text-align: center;">
                                <tr>
                                    <td>关注</td>
                                    <td>粉丝</td>
                                    <td>心情</td>
                                    <td>文章</td>
                                </tr>
                                <tr>
                                    <td><span>${articleAuthor.attention }</span></td>
                                    <td><span>${articleAuthor.fans }</span></td>
                                    <td><span>${articleAuthor.moodcount }</span></td>
                                    <td><span>${articleAuthor.articlecount }</span></td>
                                </tr>
                            </table>

                        </div>
                    </div>

                </div>
            </div>
            <div class="row" style="margin-top: 4px;margin-bottom: 4px;">
                <img src="<%=basePath%>img/background1.png" style="width: auto;height: 155px;"/>
            </div>
            <div class="row">
                <div class="col-lg-12" style="background-color: rgba(255,255,255,0.7);margin-top: 2px;height: 30px;">
                    <img src="<%=basePath%>img/content.png" style="width: 24px;height: 24px;"/>
                    <font size="4" style="text-align: center;">联系我</font>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" style="background-color: rgba(255,255,255,0.7);margin-top: 2px;">
                    <div class="row">
                        <div class="col-lg-12" style="background-color: rgba(255,255,255,0.7);border-bottom: 1px solid #C5C5C5;margin-top:
    2px;margin-bottom: 2px;">
                            <img src="<%=basePath%>img/email.png" style="width: 33px;height: 33px;"/>
                            <span id="distri" style="font-size: initial;"> 95111539@qq.com</span><br/>
                            <img src="<%=basePath%>img/phone.png" style="width: 33px;height: 33px;"/>
                            <span id="distri" style="font-size: initial;"> 15366363203</span><br/>
                            <img src="<%=basePath%>img/qq.png" style="width: 33px;height: 33px;"/>
                            <span id="distri" style="font-size: initial;"> 951115439</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>