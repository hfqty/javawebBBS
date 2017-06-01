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
			import javax.servlet.http.HttpSession; //��Ҫ����servlet-api.jar
			HttpSession session = request.getSession();
			session.setAttribute("������", ֵ����);
			session.getAttribute("������"); //��ʱȡ��������Object, һ����Ҫǿת
			session.removeAttribute("������");
			session.invalidate(); //ɾ������session�б���ļ�
			------------------------------------------------------
			HttpSession�ǲ���new������,
			Ҫ��HttpServletRequest�е���getSession�����õ�.
			һ��Ҳ����request.getSession();
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
