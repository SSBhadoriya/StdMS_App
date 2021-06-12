package com.stdms.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ViewAction
 */
@WebServlet(description = "doGet() method used here beacuse redirected via link not by jsp", urlPatterns = { "/ViewAction" })
public class ViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out=response.getWriter();
//		out.print("ViewAction Controller servlet");
		SMSDao d=new SMSDao();
		List<StudentBin> list=d.getStudents();
		RequestDispatcher rd=request.getRequestDispatcher("viewallstudents.jsp");
		request.setAttribute("STUDENT", list);
		rd.forward(request, response);
				}

}
