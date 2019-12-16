<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/3/30
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
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
<html>
<head>
    <title>敬请期待</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container" style="margin-top:2%;">
        <div class="row" style="">
            <div class="col-lg-12 col-xs-12" style="width:100%;background-size: cover;border-radius:25px;height: 500px">
                <div class="col-lg-3 col-xs-3" style="margin-top: 10%" align="center">
                </div>
                <div class="col-lg-2 col-xs-2" style="margin-top: 10%;" align="center">
                    <img src="<%=basePath%>img/forward.png" alt="">
                </div>
                <div class="col-lg-5 col-xs-5" style="margin-top: 10%;" align="center">
                    <p style="color: #b92c28; font-size: xx-large">网站升级中，部分历史文章正在清理，无法查看<br>敬请谅解。。。</p>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
