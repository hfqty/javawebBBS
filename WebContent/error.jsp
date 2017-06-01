<%@page import="com.newcapec.service.BBSService"%>
<%@page import="com.newcapec.entity.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>我要发帖</title>

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
<body style="background: url(image/bg.png);">
<div class="nav">
		<%
			String name = (String) session.getAttribute("name");
			String login = "用户登录";
			if (!"".equals(name) && name != null) {
				login = "注销登录";
			}
		%>
		<ul>
			<li><a href="all.jsp" class="ds">所有帖子</a></li>
			<li><a href="InfoServlet" class="ds">个人中心</a></li>
			<li><a href="LoginoutServlet?login=<%=login%>" class="ds">
					<%=login%></a></li>
		</ul>
		<%
			if (!login.equals("用户登录")) {
		%>
		<b class="asd"><span class="as"><%=name%></span><span>已登录</span></b>
		<b class="asd"><span class="as">欢迎发表帖子</span></b>
		<%
			} else {
		%>
		<b class="asd"><span
			style="line-height: 80px; text-align: center;">尚未登录,无法发或回复</span></b>
		<%
			}
		%>
	</div>
	<h1 align="center">恭喜你来到了没有东西的世界</h1>
</body>
</html>