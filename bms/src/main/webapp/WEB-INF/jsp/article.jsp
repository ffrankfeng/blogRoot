<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fengf" uri="http://fengf.com/common/"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!doctype html>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>文章 -博客管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="<%=basePath%>images/icon/snow2.png">
<link rel="shortcut icon" href="<%=basePath%>images/icon/snow2.png">
<script src="<%=basePath%>js/jquery-2.1.4.min.js"></script>
<!--[if gte IE 9]>
  <script src="<%=basePath%>js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/html5shiv.min.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/respond.min.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>
<script>
    function getCheckBox(){

        var checkbox = document.getElementsByName("checkbox[]");  //此处通过此种方式才能获得多选框为数组。
        //like为name = "like[]" , 获得时必须加上[]
        var checked_counts = "";

        for(var i=0;i<checkbox.length;i++){
            if(checkbox[i].checked){         //被选中的checkbox
                checked_counts+=checkbox[i].value;
            }
        }
        $.post(
            "${pageContext.request.contextPath}/blog-manager/delete-article",
            {"ids":checked_counts},
            function(data){
                var isFinish=data.isFinish;
                //3、根据返回的isExist动态显示信息
                if(isFinish){
                    location.reload();
                }
                else {
                    alert("删除失败，请重试");
                }
            },
            "json"
        );

    };
</script>
<body class="user-select">
<section class="container-fluid">
  <jsp:include page="header.jsp"></jsp:include>
  <div class="row">
    <jsp:include page="indexBar.jsp"></jsp:include>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
      <h1 class="page-header">操作</h1>
      <ol class="breadcrumb">
        <li><a href="add-article.html">增加文章</a></li>
      </ol>
      <h1 class="page-header">管理 <span class="badge">7</span></h1>
      <div class="table-responsive">
        <table class="table table-striped table-hover">
          <thead>
            <tr>
              <th><span class="glyphicon glyphicon-th-large"></span> <span class="visible-lg">选择</span></th>
              <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">标题</span></th>
              <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">栏目</span></th>
              <th class="hidden-sm"><span class="glyphicon glyphicon-tag"></span> <span class="visible-lg">标签</span></th>
              <th class="hidden-sm"><span class="glyphicon glyphicon-comment"></span> <span class="visible-lg">阅读量</span></th>
              <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">日期</span></th>
              <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${page.rows }" var="article">
            <tr>
              <td><input type="checkbox" class="input-control" name="checkbox[]" value="${article.articleId}," /></td>
              <td class="article-title">${article.title }</td>
              <td>${article.topic }</td>
              <td class="hidden-sm">${article.keyword1 } ${article.keyword2 } ${article.keyword2 }</td>
              <td class="hidden-sm">${article.reading }</td>
              <td>${article.uptime }</td>
              <td style="text-align: center;"><a href="update-article.html">修改</a> </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <footer class="message_footer">
        <nav>
          <div class="btn-toolbar operation" role="toolbar">
            <div class="btn-group" role="group"> <a class="btn btn-default" onClick="select()">全选</a> <a class="btn btn-default" onClick="reverse()">反选</a> <a class="btn btn-default" onClick="noselect()">不选</a> </div>
            <div class="btn-group" role="group">
              <button onclick="getCheckBox()" nc class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="删除全部选中" name="checkbox_delete">删除</button>
            </div>
          </div>
          <ul class="pagination pagenav">
            <fengf:page url="${pageContext.request.contextPath }/blog-manager/article" />
          </ul>
        </nav>
      </footer>
    </div>
  </div>
</section>
<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <form action="" method="post">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" >个人信息</h4>
        </div>
        <div class="modal-body">
          <table class="table" style="margin-bottom:0px;">
            <thead>
              <tr> </tr>
            </thead>
            <tbody>
              <tr>
                <td wdith="20%">姓名:</td>
                <td width="80%"><input type="text" value="王雨" class="form-control" name="truename" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">用户名:</td>
                <td width="80%"><input type="text" value="admin" class="form-control" name="username" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">电话:</td>
                <td width="80%"><input type="text" value="18538078281" class="form-control" name="usertel" maxlength="13" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">旧密码:</td>
                <td width="80%"><input type="password" class="form-control" name="old_password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">新密码:</td>
                <td width="80%"><input type="password" class="form-control" name="password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">确认密码:</td>
                <td width="80%"><input type="password" class="form-control" name="new_password" maxlength="18" autocomplete="off" /></td>
              </tr>
            </tbody>
            <tfoot>
              <tr></tr>
            </tfoot>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!--个人登录记录模态框-->
<div class="modal fade" id="seeUserLoginlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >登录记录</h4>
      </div>
      <div class="modal-body">
        <table class="table" style="margin-bottom:0px;">
          <thead>
            <tr>
              <th>登录IP</th>
              <th>登录时间</th>
              <th>状态</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>::1:55570</td>
              <td>2018-01-08 15:50:28</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:64377</td>
              <td>2018-01-08 10:27:44</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:64027</td>
              <td>2018-01-08 10:19:25</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:57081</td>
              <td>2018-01-06 10:35:12</td>
              <td>成功</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
  <div class="modal-dialog" role="document" style="margin-top:120px;max-width:280px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="<%=basePath%>images/weixin.jpg" width="200px" height="240px" style="cursor:pointer;"/> </div>
    </div>
  </div>
</div>
<!--提示模态框-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
      </div>
      <div class="modal-body"> <img src="<%=basePath%>images/baoman/baoman_01.gif" alt="深思熟虑" />
        <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--右键菜单列表-->
<div id="rightClickMenu">
  <ul class="list-group rightClickMenuList">
    <li class="list-group-item disabled">欢迎访问</li>
    <li class="list-group-item"><span>地址：</span>江苏省南京市</li>
  </ul>
</div>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/admin-scripts.js"></script>
<script>
//是否确认删除
$(function(){   
	$("#main table tbody tr td a").click(function(){
		var name = $(this);
		var id = name.attr("rel"); //对应id
        alert(id);
		if (event.srcElement.outerText == "删除") 
		{
			if(window.confirm("此操作不可逆，是否确认？"))
			{
				$.ajax({
					type: "POST",
					url: "/delete-article",
					data: "id=" + id,
					cache: false, //不缓存此页面   
					success: function (data) {
						window.location.reload();
					}
				});
			};
		};
	});   
});
</script>
</body>
</html>
