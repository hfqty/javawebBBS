<%@page import="com.newcapec.service.BBSService"%>
<%@page import="com.newcapec.entity.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>我要发帖</title>

</head>
<style type="text/css">
/**总体**/
body {
	font-family: "微软雅黑 Light", "Arial Black";
	text-decoration: none
}
/**导航栏**/
.nav {
	width: 1200px;
	height: 80px;
	margin: 0 auto;
	background: #000
}
/**登录**/
.asd {
	float: right;
	margin-right: 100px;
	color: white
}
/**用户名**/
.as {
	width: 30%;
	text-align: center;
	font-size: 60px;
}
/**菜单**/
ul {
	width: 50%;
	list-style: none;
	margin-left: -40px
}
/**链接**/
li {
	width: 130px;
	line-height: 80px;
	text-align: center;
	float: left;
	font-size: 20px;
}
/**a标签**/
a {
	display: block;
	text-decoration: none
}
/**点击效果**/
li a:hover {
	background: #8A8A8A;
}
/**链接字体颜色**/
a:link, a:visited, a:hover, a:active {
	color: black;
}

.ds:link, .ds:visited, .ds:hover, .ds:active {
	color: white;
}

.posts {
	width: 1170px;
	height: 600px;
	border: dashed 2px darkgray;
	padding: 10px;
	margin: 30px auto;
	text-align: center;
	font-size: 20px;
	border-radius: 20px;
}

.title {
	width: 60%;
	height: 50px;
	resize: none;
	font-size:20px;
}

.content {
	margin-top:10px;
	width: 60%;
	height: 400px;
	resize: none;
	font-size:20px;
}

input {
	border-radius: 10px;
	width: 150px;
	height: 40px;
	font-size: 16px;
}
</style>
<body>
<div class="nav">
	<c:set var="login" value="用户登录"> </c:set>
	<c:if test="${name!=null&&name!=null }">
		<c:set var="login" value="注销登录"> </c:set>
	</c:if>
		<ul>
			<li><a href="post.jsp" class="ds">发表新帖</a></li>
			<li><a href="all.jsp"  class="ds">所有帖子</a></li>
			<li><a href="InfoServlet" class="ds">个人中心</a></li>
			<li><a href="LoginoutServlet?login=${login }" class="ds">
					${login }</a></li>
		</ul>
		<c:choose>
		<c:when test="${login=='注销登录' }">
		<b class="asd"><span class="as">${name}</span><span>已登录</span></b>
		<b class="asd"><span class="as">发表新帖</span></b>
		</c:when>
		<c:otherwise>
		<b class="asd"><span style="line-height: 80px; text-align: center;">尚未登录,无法发或回复</span></b>
		</c:otherwise>
		</c:choose>
</div>
	<div class="posts">
	<c:choose>	
	<c:when test="${login!='用户登录' }">
		<form action="PostServlet">
			标题:
			<textarea class="title" name="title"></textarea>
			<br> 内容:
			<textarea class="content" name="content"></textarea>
			<br> <input type="submit" value="发表新帖">
		</form>
		</c:when>
	<c:otherwise>
	<h1 align="center">尚未登录,无法发帖</h1>
	</c:otherwise>
</c:choose></div>
<h4 align="center">当前在线:${count }人;本次在线总人数:${max }人</h4>
</body>
</html>