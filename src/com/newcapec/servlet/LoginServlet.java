package com.newcapec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newcapec.entity.Post;
import com.newcapec.entity.User;
import com.newcapec.service.BBSService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(name!=null){
		User user = new User();
		user.setName(name);
		user.setPassword(password);
	    BBSService login  = new BBSService();
	    boolean result = login.login(user);
	    if(result){
	    	/*
			import javax.servlet.http.HttpSession; //需要引入servlet-api.jar
			HttpSession session = request.getSession();
			session.setAttribute("变量名", 值对象);
			session.getAttribute("变量名"); //此时取出来的是Object, 一般需要强转
			session.removeAttribute("变量名");
			session.invalidate(); //删除所有session中保存的键
			------------------------------------------------------
			HttpSession是不能new出来的,
			要从HttpServletRequest中调用getSession方法得到.
			一般也就是request.getSession();
			*/
	    	HttpSession session = request.getSession();
	    	session.setAttribute("name", name);
	    	session.setAttribute("user", user);
	    	BBSService allpost = new BBSService();
	    	List<Post> posts = allpost.posts();
	    	request.setAttribute("posts", posts);
	    	request.getRequestDispatcher("all.jsp").forward(request, response);
	    	
	    }else{
	    	
	    	response.sendRedirect("error.jsp");
	    	
	    }
		}else{
			response.sendRedirect("error.jsp");
		}
	    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
