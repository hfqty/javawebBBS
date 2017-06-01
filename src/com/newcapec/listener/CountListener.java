package com.newcapec.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountListener
 *
 */
@WebListener
public class CountListener implements HttpSessionListener {
	private int count;
	private int max;

    /**
     * Default constructor. 
     */
    public CountListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent hse)  {
    	count ++;
    	max = count;
    	HttpSession session = hse.getSession();
    	ServletContext hs = session.getServletContext();
    	hs.setAttribute("count", count);
    	hs.setAttribute("max", max);
    }

    public void sessionDestroyed(HttpSessionEvent hse)  { 
         count --;
         HttpSession session = hse.getSession();
         ServletContext sc = session.getServletContext();
         sc.setAttribute("count", count);
    }
	
}
