<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/19
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>hello world</h2>
<shiro:hasPermission name="menu:list">
    <li data-options="url:/test/list.html">
       leibi
    </li>
</shiro:hasPermission>
<shiro:hasRole name="admin">
    <li>
        欢迎管理员。
    </li>
</shiro:hasRole>
<a href="/test/logout.html">退出</a>
<a href="/test/list.html">列表</a>
<a href="/test/edit.html">编辑</a>
<a href="/test/update.html">更新</a>
</body>
</html>
