package com.stdms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stdms.dao.SMSDao;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/controller")
public class IndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	out.print("<h1>doGet() method called</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//out.print("<h1>doPost() method called</h1>");
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		String user=request.getParameter("user");
		//out.print("<h1>User Id: "+uid+" <br>Password: "+pass+"</h1>");
		SMSDao d=new SMSDao();
		if(d.loginCheck(uid,pass,user))
		{
			HttpSession session=request.getSession();
			session.setAttribute("user",uid);
			if(user.equalsIgnoreCase("administration"))
				response.sendRedirect("adminhome.jsp");
			else if(user.equalsIgnoreCase("organization"))
				response.sendRedirect("orghome.jsp");
			else if(user.equalsIgnoreCase("student"))
				response.sendRedirect("studenthome.jsp");
			else 
				response.sendRedirect("jshome.jsp");

		}
		else
		{
			 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			 request.setAttribute("msg", "Login Fail!!!");
			 rd.forward(request,response);
			 
		}
			
	}

}
