package com.stdms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stdms.dao.SMSDao;
import com.stdms.model.StudentBin;

/**
 * Servlet implementation class CreateaAction
 */
@WebServlet("/CreateaAction")
public class CreateaAction extends HttpServlet {
	public CreateaAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String roll_no=request.getParameter("uid");
		String sname=request.getParameter("uname");
		String fname=request.getParameter("fname");
		String email=request.getParameter("email");
		String address=request.getParameter("add");
		PrintWriter out=response.getWriter();
		out.print(roll_no+" "+sname+" "+fname+" "+email+" "+address+" ");
		StudentBin sb=new StudentBin();
			//sb.setId(roll_no);
			sb.setSname(sname);
			sb.setFname(fname);
			sb.setEmail(email);
			String str=System.currentTimeMillis()+"";
			String pass=str.substring(7);
			sb.setPassword(pass);
			sb.setAddress(address);

		SMSDao d=new SMSDao();
		int x=0;
		if(sb.getId()==null ||sb.getId()=="")
			x=d.insertRecord(sb);
		if(x!=0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("createnewstudent.jsp");
			request.setAttribute("msg", "Operation completed....");
			rd.forward(request,response);
		}
	}



}
