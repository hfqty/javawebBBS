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
BBSService postss = new BBSService();
List<Post> posts = postss.posts();
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
.contents {
	width: 1200px;
	margin: 50px auto;
}

table {
	border-top: solid 2px #5d5d5d;
	width: 1200px;
}

td {
	border-bottom: solid 1px black;
	border-right: dashed 1px black
}

.content {
	height: 100px
}
.bottom{  width:1200px;  height:50px;background-color:#5d5d5d;margin: 0 auto;}
    .page{list-style: none;width: 1200px;text-align: center;}
    .page li{width:60px;height: 50px;border-radius: 5px;float: left;line-height: 50px;}
    .page li a{ display: block;text-decoration: none;text-align: center;color: white}
    .page li a:hover{background-color: #CCCCCC}
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
		<b class="asd"><span class="as">所有帖子</span></b>
		</c:when>
		<c:otherwise>
		<b class="asd"><span style="line-height: 80px; text-align: center;">尚未登录,无法发或回复</span></b>
		</c:otherwise>
		</c:choose>
</div>
	<div class="contents">
		<table>
			<tr>
				<td>发帖人</td>
				<td>标题</td>
				<td>发帖时间</td>
			</tr>
			
			<c:forEach items="${posts }" var="post">
			<tr>
				<td class="content" style="width:100px">${post.getName()}</td>
				<td class="content" style="width:60%" ><a href="GoRepServlet?id=${post.getId()}">${post.getTitle()}</a></td>
				<td class="content" style="width:100px">${post.getDate().substring(0,19)}</td>
				<td class="content" style="width:50px"><a href="DelServlet?id=${post.getId()}">删帖</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
<div class="bottom">
	 
    <ul class="page">
        <li style="width:200px;color:white;margin-right:10px">第1页/共20页</li>
        <li><a href="">首页</a></li>
        <li><a href="">上一页</a></li>
        <li><a href="">1</a></li>
        <li><a href="">2</a></li>
        <li><a href="">3</a></li>
        <li><a href="">4</a></li>
        <li><a href="">5</a></li>
        <li><a href="">6</a></li>
        <li><a href="">7</a></li>
        <li><a href="">8</a></li>
        <li><a href="">下一页</a></li>
        <li><a href="">尾页</a></li>
        
    </ul>

</div>

<h4 align="center">当前在线:${count }人;本次在线总人数:${max }人</h4>
</body>
</html>