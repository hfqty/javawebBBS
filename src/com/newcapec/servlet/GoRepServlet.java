package com.newcapec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.entity.Post;
import com.newcapec.entity.Reply;
import com.newcapec.service.BBSService;

/**
 * Servlet implementation class GoRepServlet
 */
@WebServlet("/GoRepServlet")
public class GoRepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BBSService goRep = new BBSService();
		Post post = goRep.getFirst(id);
		List<Reply> replys = goRep.getRep(id);
		if(post!=null){
			request.setAttribute("post", post);
			
			if(replys!=null){
				request.setAttribute("replys", replys);
			}
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}else{
			response.sendRedirect("error.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
