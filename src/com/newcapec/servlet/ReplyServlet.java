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
import com.newcapec.entity.Reply;
import com.newcapec.service.BBSService;


@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		if(!"".equals(content)){
		String uname= (String)request.getSession().getAttribute("name");
		BBSService gid = new BBSService();
		int uid = gid.getId(uname);
		Reply reply = new Reply();
		Cookie[] cookies = request.getCookies();
		int id = 0;
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("id")){
				id = Integer.parseInt(cookie.getValue());
			}
		}
		
		reply.setUid(uid);
		reply.setPostid(id);
		reply.setContent(content);
		BBSService goRep = new BBSService();
		goRep.reply(reply);
		Post post = goRep.getFirst(id);
		List<Reply> replys = goRep.getRep(id);
		if(post!=null){
			request.setAttribute("post", post);
			if(replys!=null)
				request.setAttribute("replys", replys);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}else
			response.sendRedirect("error.jsp");	
		}else{
			response.getWriter().print("Œ¥ ‰»Îƒ⁄»›!");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
