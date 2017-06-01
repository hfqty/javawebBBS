<%@page import="com.newcapec.entity.User"%>
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
<title>欢迎来看帖,记得点赞</title>

</head>
<%

%>

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
 a:link,  a:visited,  a:hover, a:active {
	color: black;
  }
 .ds:link,  .ds:visited,  .ds:hover, .ds:active {
	color: white;
  }
/**
    内容区
     */
     .content{width:1200px;height:600px;margin:30px auto;border:3px solid #8a8a8a;}
     .infos{width:1200px;font-size:40px}   
     row{height:70px}
     td{border-right:1px dashed black;border-bottom:1px solid black;height:60px;font-size:30px} 
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
		<b class="asd"><span class="as">个人中心</span></b>
		</c:when>
		<c:otherwise>
		<b class="asd"><span style="line-height: 80px; text-align: center;">尚未登录,无法发或回复</span></b>
		</c:otherwise>
		</c:choose>
	</div>
	
	<c:choose>
	<c:when test="${login!='用户登录' }">
	<c:choose>
	<c:when test="${user!=null }">
	<div class="content">
	<table class="infos">
	<caption style="border-bottom:5px solid black]">个人信息</caption>
	<tr class="row">
	<td style="width:100px">用户名</td>
	<td style="width:300px">${user.getName()}</td>
	</tr>
	<tr>
	<td>qq</td>
	<td>${user.getQq() }</td>
	</tr>
	<tr>
	<td>手机号</td>
	<td>${user.getPhone() }</td>
	</tr>
	<tr>
	<td>地址</td>
	<td>${user.getAddress() }</td>
	</tr>
	<tr>
	<td>注册时间</td>
	<td>${user.getDate() }</td>
	</tr>
	</table>
	</div>
	</c:when>
	<c:otherwise>
	<h1 align="center">失败</h1>
	</c:otherwise>
	</c:choose>
	</c:when>
	<c:otherwise>
		<h1 align="center">尚未登录</h1>
		</c:otherwise>
	</c:choose>
<h4 align="center">当前在线:${count }人;本次在线总人数:${max }人</h4>
</body>
</html>