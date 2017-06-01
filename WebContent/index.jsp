<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页面</title>
</head>
<style type="text/css">
    body{
        font-family: "微软雅黑 Light", "Arial Black";

    }
    .bd{
        margin: 0 auto;
        width: 600px;
        height: 600px;
        border-radius: 30px;
        border: 3px #5d5d5d  dashed;
    }
    .form{
        width:260px;
        height: 400px;
        margin: 200px auto;
    }
   h1{
        width: 260px;
        text-align: center;
    }
    input{
        border-bottom: 1px black solid;
        margin-bottom: 30px;
        width:200px;
        border-radius: 5px;
    }
    .gin{
        width: 60px;
        margin-left: 40px;
    }
    p{
        width: 200px;
    }
    a{text-decoration: none}
    /**链接字体颜色**/
 a:link,  a:visited,  a:hover, a:active {
	color: black;
  }
</style>
<body>

<div class="bd">
    <div class="form">
    <h1>欢迎登录!</h1>
    <form action="LoginServlet">
        用户名:<input type="text" name="name"><br>
        密&nbsp;&nbsp;&nbsp;码:<input type="text" name="password"><br>
        <input type="submit" value="登录" class="gin"/>
        <input type="reset" value="重置" class="gin"/>
    </form>
    <p>没有账号?<a href="reg.jsp" style="color:red;font-size:30px">请注册</a></p>
    <p>或者先<a href="all.jsp" style="color:red;font-size:30px;">随便看看</a></p>
    </div>
</div>
<h4 align="center">当前在线:${count }人;本次在线总人数:${max }人</h4>
</body>
</html>