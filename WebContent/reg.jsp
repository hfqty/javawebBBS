<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<center>
<h1>欢迎注册!</h1>
<div>
<form action="RegisterServlet">

<p>用户名:<input type="text" name="uname"></p>
<p>密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="text" name="password"></p>
<p>qq&nbsp;&nbsp;&nbsp;号:<input type="text" name="qq"></p>
<p>手机号:<input type="text" name="phone"></p>
<p>地&nbsp;&nbsp;&nbsp;&nbsp;址:<input type="text" name="address"></p>
<input type="submit" value="确定注册">

</form>
<h2>不要忘了密码!忘了就找不回了</h2>
</div>
<a href="index.jsp">已有账号?登录</a>
</center>
</body>
</html>