package org.afdemp.bootcamp2.lesson5.project.controllers;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afdemp.bootcamp2.lesson5.project.dao.StudentDAO;
import org.afdemp.bootcamp2.lesson5.project.domain.Student;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		//reading parameters from request
		String name = request.getParameter("studentname");
		String surname = request.getParameter("studentsurname");
		String am = request.getParameter("studentam");
			
		RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");

		try {

			if(name == null || name.length() < 2
					|| surname == null || surname.length() < 2
					|| am == null || am.length() != 9) {
		
				
				request.setAttribute("errormessage", "Not valid data!");
				
				rd.forward(request, response);
				return;
			}
						

			Student student = new Student(name, surname, am);

			StudentDAO sdao = new StudentDAO();

			
			sdao.saveStudent(student); //store student to database

			

			request.setAttribute("message", "Registration completed successfully!");
                        
			rd.forward(request, response);
			return;

		} catch (Exception e) {
			
			request.setAttribute("errormessage", e.getMessage());
			
			rd.forward(request, response);	
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
