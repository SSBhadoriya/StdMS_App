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
 * Servlet implementation class UpdateActionForm
 */
@WebServlet("/UpdateActionForm")
public class UpdateActionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String roll_no=request.getParameter("roll_no");
		String sname=request.getParameter("sname");
		String fname=request.getParameter("fname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
//		PrintWriter out=response.getWriter();
//		out.print(roll_no+" "+sname+" "+fname+" "+email+" "+password+" "+address+" ");
		StudentBin sb=new StudentBin();
			sb.setId(roll_no);
			sb.setSname(sname);
			sb.setFname(fname);
			sb.setEmail(email);
			sb.setPassword(password);
			sb.setAddress(address);

		SMSDao d=new SMSDao();
		int x=0;
			x=d.updateFormRecord(sb);
		if(x!=0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("updatestudent.jsp");
			request.setAttribute("UPDATION", "Updation completed....");
			rd.forward(request,response);
		}
	}

}
