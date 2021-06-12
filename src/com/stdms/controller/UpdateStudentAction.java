package com.stdms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stdms.dao.SMSDao;
import com.stdms.model.StudentBin;

/**
 * Servlet implementation class UpdateStudentAction
 */
@WebServlet("/UpdateStudentAction")
public class UpdateStudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	PrintWriter out=response.getWriter();
//	out.println("<h1>Update Record</h1>");
		String roll_no=request.getParameter("roll_no");
//		System.out.println(roll_no); check 1
		SMSDao d=new SMSDao();
		StudentBin sb=d.updateRecord(roll_no); 
		
//		Forwarding object on update page
		RequestDispatcher rd = request.getRequestDispatcher("updatestudent.jsp");
		request.setAttribute("UPDATE", sb);
		rd.forward(request, response);
		
	}


}
