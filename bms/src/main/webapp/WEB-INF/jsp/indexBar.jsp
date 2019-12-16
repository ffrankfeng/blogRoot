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
<aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
    <ul class="nav nav-sidebar">
        <li class="active"><a href="index.html">报告</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li><a href="article.html">文章</a></li>
        <li><a href="user.html">用户</a></li>
        <li><a href="comment.html">评论</a></li>
        <li><a data-toggle="tooltip" data-placement="bottom" title="网站暂无留言功能">留言</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li><a href="category.html">栏目</a></li>
        <li><a href="dataupdate.html">数据更新</a></li>
        <li><a class="dropdown-toggle" id="otherMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">其他</a>
            <ul class="dropdown-menu" aria-labelledby="otherMenu">
                <li><a href="flink.html">友情链接</a></li>
                <li><a data-toggle="modal" data-target="#areDeveloping">访问记录</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-sidebar">
        <li><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">管理员</a>
            <ul class="dropdown-menu" aria-labelledby="userMenu">
                <li><a data-toggle="modal" data-target="#areDeveloping">管理员组</a></li>
                <li><a href="manage-user.html">管理员信息</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="loginlog.html">管理登录日志</a></li>
            </ul>
        </li>
    </ul>
</aside>