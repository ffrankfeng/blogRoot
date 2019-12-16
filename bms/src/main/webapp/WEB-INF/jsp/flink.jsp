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
<title>友情链接 -博客管理系统</title>
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

<body class="user-select">
<section class="container-fluid">
  <jsp:include page="header.jsp"></jsp:include>
  <div class="row">
    <jsp:include page="indexBar.jsp"></jsp:include>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
      <form action="/Flink/checkAll" method="post" >
        <h1 class="page-header">操作</h1>
        <div class="table-responsive">
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th><span class="glyphicon glyphicon-bookmark"></span> <span class="visible-lg">名称</span></th>
                <th><span class="glyphicon glyphicon-link"></span> <span class="visible-lg">URL</span></th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${flinks }" var="flink">
              <tr>
                <td class="article-title">${flink[0]}</td>
                <td><a href="${flink[1]}">${flink[1]}</a> </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>

      </form>
    </div>
  </div>
</section>
</body>
</html>
