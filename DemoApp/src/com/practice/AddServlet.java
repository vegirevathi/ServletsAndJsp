package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;
		
		//Using Request Dispatcher
//		req.setAttribute("sum", k);
//		RequestDispatcher rd=  req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
		//Using sendRedirect
		//res.sendRedirect("sq?k=" + k); //this is called URL rewriting
		
		
		//Using HttpSession
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("sq");
		
		//Using cookies
		Cookie cookie = new Cookie("k", String.valueOf(k));
		res.addCookie(cookie);
		res.sendRedirect("sq");
	}

}
