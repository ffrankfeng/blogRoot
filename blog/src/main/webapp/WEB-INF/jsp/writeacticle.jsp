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
    <title>创作中ing</title>

    <!-- 引入Bootstrap核心样式文件 -->
    <link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon">
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>css/customize.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.3/jquery.js"></script>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/alertStyle.js"></script>
    <script src="<%=basePath%>js/wangEditor.min.js"></script>

    <script type="text/javascript">
        // var E = window.wangEditor
        // var editor = new E('#wangEditor')
        // // 下面两个配置，使用其中一个即可显示“上传图片”的tab。但是两者不要同时使用！！！
        // editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
        // // editor.customConfig.uploadImgServer = '../upload'  // 上传图片到服务器
        // editor.create()

        var isOpen = "on";

        function getContent() {
            // var article = UE.getEditor('editor').getContent();
            var article =editor.txt.html()
            var title = $("#articleTitle").val();


            var keyword1 = $("#keyword1").val();
            var keyword2 = $("#keyword2").val();
            var keyword3 = $("#keyword3").val();
            var topic = $("#topic option:selected").val();


            if (article != null && article != "" && title != null && title != "") {
                $.post(
                    "${pageContext.request.contextPath}/savewriting.html",//url地址
                    {
                        "title": title,
                        "content": article,
                        "isopen": isOpen,
                        "keyword1": keyword1,
                        "keyword2": keyword2,
                        "keyword3": keyword3,
                        "topic": topic
                    },//请求参数
                    function (data) {//执行成功后的回调函数
                        var isFinish = data.isFinish;
                        if (isFinish) {
                            alert("提交成功！");
                            window.location.href = "index.html";
                        } else {
                            alert("提交失败请重新尝试");
                        }
                    },
                    "json"
                );
            } else {
                alert("请填写完整文章");
            }
        }


        var count = 1;
        var flag = 5;
        var addInput = function (obj) {
            var inp1 = document.getElementsByTagName('input')[count];
            var tel = inp1.value;
            var result = tel.replace(/^(\s|\u00A0)+|(\s|\u00A0)+$/g, '');
            if (result != "") {
                count++;
                if (count < 3) {
                    var inp = document.createElement('input');
                    var myContent = document.getElementById('btnContent');
                    inp.type = "text";
                    inp.style.cssText = "margin-left: 5px;width: 80px;height:30px;border:none;border-radius: 10px;font-size: 15px;float: left;display: block;";
                    inp.id = "keyword" + count;
                    inp.name = "keyword" + count;
                    inp.class = "form-inline"
                    myContent.insertBefore(inp, myContent.childNodes[flag]);
                    flag++;
                    var oldMargin = parseInt(myContent.style.marginLeft);
                    myContent.style.marginLeft = (oldMargin - 85) + "px";
                }
                else if (count == 3) {
                    obj.style.display = "none";
                    var inp = document.createElement('input');
                    var myContent = document.getElementById('btnContent');
                    inp.type = "text";
                    inp.style.cssText = "margin-left: 5px;width: 80px;height:30px;border:none;border-radius: 10px;font-size: 15px;float: left;display: block;";
                    inp.id = "keyword" + count;
                    inp.name = "keyword" + count;
                    inp.class = "form-inline"
                    myContent.insertBefore(inp, myContent.childNodes[flag]);
                    flag++;
                    var oldMargin = parseInt(myContent.style.marginLeft);
                    myContent.style.marginLeft = (oldMargin - 85) + "px";
                }
                else {
                    obj.style.display = "none";
                }
            }
            else {
                alert('请输入标签!');
            }

        }

        $(document).ready(function () {
            $("#isOpen").on('click', function () {
                clickSwitch()
            });
            var clickSwitch = function () {
                if ($("#isOpen").is(':checked')) {
                    isOpen = "off";
                } else {
                    isOpen = "on";
                }
            };
        });

    </script>
    <style type="text/css">
        html {
            height: 100%;
            width: 100%;
        }

        body {
            background: -webkit-linear-gradient(#D9EDF7, #B0E0E6); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(#D9EDF7, #B0E0E6); /* Opera 11.1 - 12.0 */
            background: -moz-linear-gradient(#D9EDF7, #B0E0E6); /* Firefox 3.6 - 15 */
            background: linear-gradient(#D9EDF7, #B0E0E6); /* 标准的语法 */
            background-size: 100% 100%;
            background-attachment: fixed
        }

        .testswitch {
            position: relative;
            float: right;
            right: 60px;
            width: 90px;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
        }

        .testswitch-checkbox {
            display: none;
        }

        .testswitch-label {
            display: block;
            overflow: hidden;
            cursor: pointer;
            border: 2px solid #999999;
            border-radius: 20px;
        }

        .testswitch-inner {
            display: block;
            width: 200%;
            margin-left: -100%;
            transition: margin 0.3s ease-in 0s;
        }

        .testswitch-inner::before, .testswitch-inner::after {
            display: block;
            float: right;
            width: 50%;
            height: 30px;
            padding: 0;
            line-height: 30px;
            font-size: 14px;
            color: white;
            font-family: Trebuchet, Arial, sans-serif;
            font-weight: bold;
            box-sizing: border-box;
        }

        .testswitch-inner::after {
            content: attr(data-on);
            padding-left: 10px;
            background-color: #EEEEEE;
            color: #999999;
        }

        .testswitch-inner::before {
            content: attr(data-off);
            padding-right: 10px;
            background-color: #00e500;
            color: #FFFFFF;
            text-align: right;
        }

        .testswitch-switch {
            position: absolute;
            display: block;
            width: 22px;
            height: 22px;
            margin: 4px;
            background: #FFFFFF;
            top: 0;
            bottom: 0;
            right: 56px;
            border: 2px solid #999999;
            border-radius: 20px;
            transition: all 0.3s ease-in 0s;
        }

        .testswitch-checkbox:checked + .testswitch-label .testswitch-inner {
            margin-left: 0;
        }

        .testswitch-checkbox:checked + .testswitch-label .testswitch-switch {
            right: 0px;
        }

        .my-btn {
            float: left;
            display: block;
            width: 20px;
            height: 20px;
            background: url(<%=basePath%>img/add.png);
            background-size: 20px 20px;
            -moz-background-size: 20px 20px;
            -moz-background-size: 20px 20px;
            -o-background-size: 20px 20px;
            border: none;
            margin-top: 2px;
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
        .w-e-text-container{
            height: 700px !important;/*!important是重点，因为原div是行内样式设置的高度300px*/
        }
    </style>
</head>
<body>
<!--导航栏-->
<jsp:include page="header.jsp"></jsp:include>
<div class="container" style="margin-top:2%;">
    <div class="row" style="margin-top: 1%;">
        <div class="col-lg-1"></div>
        <div class="col-lg-10 col-xs-12" align="center"
             style="border-radius:10px;background-color: rgba(255,250,300,0.8);text-align: center;font-size: 200%;">
            <div class="row" style="margin-top: 2%;vertical-align: middle;align-items: center;">
                <img src="<%=basePath%>img/sign_up.png" style="width: 30px;height: 30px;"/>
                <font style="font-weight: bold;">创作中ing</font>
            </div>
            <div class="row" style="margin-top: 2%;margin-bottom: 2%;">
                <div class="col-lg-2"></div>
                <div class="col-lg-8" style="margin-top: 2%;margin-bottom: 4%;">
                    <input type="text" id="articleTitle" name="articleTitle" class="form-control" placeholder="输入文章标题"/>
                </div>

                <%--<div  id="wangEditor">--%>
                    <%--&lt;%&ndash;<script id="editor" type="text/plain" style="width:100%;height:500px;"></script>&ndash;%&gt;--%>
                    <%--<p>欢迎使用 wangEditor 富文本编辑器</p>--%>
                <%--</div>--%>
                <div class="col-lg-12" >
                    <div class="toolbar" id="wangEditor1" style="font-size: 22px"></div>
                    <div class="toolbar" id="wangEditor2" style="background-color: white"></div>
                </div>

                <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
                <%--<script type="text/javascript" src="../js/wangEditor.min.js"></script>--%>
                <script type="text/javascript">
                    var E = window.wangEditor
                    var editor = new E('#wangEditor1','#wangEditor2')
                    // 下面两个配置，使用其中一个即可显示“上传图片”的tab。但是两者不要同时使用！！！
                    editor.customConfig.debug = true;
                    editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
                    editor.customConfig.uploadFileName = 'imgUpload'; //设置文件上传的参数名称
                    editor.customConfig.uploadImgServer = '../upload.html'  // 上传图片到服务器
                    //自定义上传图片事件
                    editor.customConfig.uploadImgHooks = {
                        before : function(xhr, editor, files) {

                        },
                        success : function(xhr, editor, result) {
                            console.log("上传成功");
                        },
                        fail : function(xhr, editor, result) {
                            console.log("上传失败,原因是"+result);
                        },
                        error : function(xhr, editor) {
                            console.log("上传出错");
                        },
                        timeout : function(xhr, editor) {
                            console.log("上传超时");
                        }
                    }
                    editor.create()
                </script>
                <div class="col-lg-3"></div>

                <div class="col-lg-12" style="margin-top: 4%;text-align: left;">
                    <label class="control-label"
                           style="margin-left:750px;margin-top:5px;font-size: 15px;float:left;display: block;">
                        类别： </label>
                    <select class="form-control" id="topic" name="topic"
                            style="float:left;display:block;width: 100px;font-size: 15px;">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                    <div class="row" id="btnContent"
                         style="float: left;width: 100%;margin-left:750px;margin-top:5px;margin-bottom: 5px;">
                        <label style="font-size: initial;float: left;display: block;">标签:</label>
                        <input type="text" class="form-inline"
                               style="margin-left: 5px;width: 80px;height:30px;border:none;border-radius: 10px;font-size: 15px;float: left;display: block;"
                               id="keyword1" name="keyword1"/>
                        <input type="button" class="my-btn" id="my-btn" onclick="addInput(this)"/>
                    </div>
                    <div class="row testswitch">
                        <input class="testswitch-checkbox" id="isOpen" type="checkbox">
                        <label class="testswitch-label" for="isOpen">
                            <span class="testswitch-inner" data-on="私密" data-off="公开"></span>
                            <span class="testswitch-switch"></span>
                        </label>
                    </div>
                    <br/>

                </div>
                <div class="col-lg-5 col-xs-4"></div>
                <div class="col-lg-6 col-xs-6" style="margin-top: 4%;text-align: left;">
                    <button class="btn btn-default" style="background-color: brown;color: rgba(255,255,255,0.3); "
                            onclick="getContent()">发布
                    </button>&emsp;
                    <button class="btn btn-default" style="background-color: brown;color: rgba(255,255,255,0.3);"
                            onclick="javascript:history.go(-1);">返回
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>