package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sq")
public class SquareServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//Using Request Dispatcher		
//		int i = (int)req.getAttribute("sum");
//		int j = i * i;
		
		
		//Using sendRedirect method
//		int i = Integer.parseInt(req.getParameter("k"));
//		int j = i * i;
//		PrintWriter out = res.getWriter();
//		out.print("Result is : "+j);
		
		//Using HttpSession
//		HttpSession session = req.getSession();
//		int i = (int)session.getAttribute("k");
//		int j = i * i;
//		PrintWriter out = res.getWriter();
//		out.print("Result is : "+j);
		
		//Using Cookies
		int i = 0;
		Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("k")) {
				i = Integer.parseInt(c.getValue());
			}
		}
		
		int j = i * i;
		PrintWriter out = res.getWriter();
		out.print("Result is : "+j);
		
		//Concept of servlet context - Added context-param in web.xml
		ServletContext sc = getServletContext();
		out.println("My name is "+ sc.getInitParameter("name"));
		
		//Concept of servlet config - Added init-param in web.xml inside the square servlet tag
		ServletConfig config = getServletConfig();
		out.println("my name in this servlet is "+config.getInitParameter("name"));
	}
}
