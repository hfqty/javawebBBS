package com.newcapec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginoutServlet")
public class LoginoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginstate = request.getParameter("login");
		
		if(loginstate.equals("ÓÃ»§µÇÂ¼")){
			response.sendRedirect("index.jsp");
		}else{
			HttpSession session = request.getSession();
			session.invalidate();
			System.out.println(session.getAttribute("name"));
			request.getRequestDispatcher("all.jsp").forward(request, response);;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
