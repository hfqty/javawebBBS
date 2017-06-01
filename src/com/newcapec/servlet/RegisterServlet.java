package com.newcapec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.entity.User;
import com.newcapec.service.BBSService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		int qq = Integer.parseInt(request.getParameter("qq"));
		int phone = Integer.parseInt(request.getParameter("phone"));
		String address = request.getParameter("address");
		User user = new User();
		user.setName(uname);
		user.setPassword(password);
		user.setQq(qq);
		user.setPhone(phone);
		user.setAddress(address);
		BBSService register = new BBSService();
		boolean result = register.register(user);
		if(result){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			response.sendRedirect("error.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
