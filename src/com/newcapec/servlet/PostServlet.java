package com.newcapec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newcapec.entity.Post;
import com.newcapec.entity.Reply;
import com.newcapec.service.BBSService;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session =request.getSession();
		String name = (String)session.getAttribute("name");
		BBSService getI = new BBSService();
		int uid = getI.getId(name);
		Post post = new Post();
		post.setUid(uid);
		post.setTitle(title);
		post.setDetail(content);
		boolean result = getI.post(post);
		if(result){
			response.sendRedirect("all.jsp");
		}else{
			response.sendRedirect("error.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}
}
