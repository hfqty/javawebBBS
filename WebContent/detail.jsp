<%@page import="com.newcapec.entity.Reply"%>
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
<title>我要回帖</title>
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
	margin-right: 30px;
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
  .ps{width: 1200px;margin: 30px auto}
    caption{font-size: 30px}
    .contents{width: 1200px;border-top: 5px solid black; }
    .contents tr{height: 200px;}
    .contents td{border-left: 1px dashed black;  border-bottom:1px solid black;}
    .posts {
	width: 1170px;
	margin:30px auto;
	padding: 10px;
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
	margin:20px auto;
}
</style>
<body >
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
		<b class="asd"><span class="as">帖子内容</span></b>
		</c:when>
		<c:otherwise>
		<b class="asd"><span style="line-height: 80px; text-align: center;">尚未登录,无法发或回复</span></b>
		</c:otherwise>
		</c:choose>
	</div>
	<c:choose>
	<c:when test="${post!=null }">
   <div class="ps">
    <table class="contents">
        <caption>${post.getTitle()}</caption>
        <tr class="content1">
            <td style="width: 20%">楼主:${ post.getName() }</td>
            <td style="width: 65%">${post.getDetail()}</td>
            <td>${post.getDate()}</td>
        </tr>
        <c:choose>
        <c:when test="${replys!=null }">
        <c:forEach items="${replys }" var="reply" varStatus="index">
        <tr class="content2">
            <td>${index.count+1}楼:${ reply.getRname()}</td>
            <td>${ reply.getContent()}</td>
            <td>${reply.getReDate() }</td>
        </tr>
        </c:forEach>
        </c:when>
        </c:choose>
        	</table>
         </div>
         </c:when>
         <c:otherwise>
		<b style="margin-left:400px;font-size:40px;margin-top:100px">参数错误!</b>
		</c:otherwise>
		</c:choose>
	<div class="posts">
	<c:choose>
	<c:when test="${login!='用户登录' }">
     <form action="ReplyServlet">
        	  输入回复内容:
			<textarea class="content" name="content"></textarea>
			<br> <input type="submit" value="发表回复">
		</form>
		<%
		Post post = (Post)request.getAttribute("post");
	    Cookie cookie = new Cookie("id",post.getId()+"");
	    response.addCookie(cookie);%>
		</c:when>
		<c:otherwise>
	   <b style="margin-left:400px;font-size:40px;margin-top:100px">尚未登录,无法回复</b>
	   </c:otherwise>
	   </c:choose>
</div>
<h4 align="center">当前在线:${count }人;本次在线总人数:${max }人</h4>
</body>
</html>