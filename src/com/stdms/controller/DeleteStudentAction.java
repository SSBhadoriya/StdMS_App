package com.stdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stdms.dao.SMSDao;
import com.stdms.model.StudentBin;

/**
 * Servlet implementation class DeleteStudentAction
 */
@WebServlet("/DeleteStudentAction")
public class DeleteStudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roll_no=Integer.parseInt(request.getParameter("roll_no"));
		SMSDao d=new SMSDao();
		int x=d.deleteRecord(roll_no);
//		System.out.println("value return: "+x);
		if(x!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("viewallstudents.jsp");
			request.setAttribute("DELETE","Serial number "+roll_no+" deleted...");
			List<StudentBin> list=d.getStudents();
			request.setAttribute("STUDENT", list);
			rd.forward(request, response);
		}
	}

}
