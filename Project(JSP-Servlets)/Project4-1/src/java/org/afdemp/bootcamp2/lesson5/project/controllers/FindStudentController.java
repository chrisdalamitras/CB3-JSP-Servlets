package org.afdemp.bootcamp2.lesson5.project.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afdemp.bootcamp2.lesson5.project.dao.StudentDAO;
import org.afdemp.bootcamp2.lesson5.project.domain.Student;

/**
 * Servlet implementation class FindStudentController
 */
@WebServlet("/findstudent")
public class FindStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");

		RequestDispatcher rd = request.getRequestDispatcher("/results.jsp");
		
		StudentDAO sdao = new StudentDAO();

		ArrayList<Student> reslist = null;
	
		try {
						
			reslist = sdao.findStudentByKeyword(keyword);
			
			request.setAttribute("students-results", reslist);
			
			rd.forward(request, response);
			return;			
			
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
