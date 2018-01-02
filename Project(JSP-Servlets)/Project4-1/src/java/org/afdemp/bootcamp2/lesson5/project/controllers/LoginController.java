package org.afdemp.bootcamp2.lesson5.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.afdemp.bootcamp2.lesson5.project.dao.UserDAO;
import org.afdemp.bootcamp2.lesson5.project.domain.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("UTF-8");
                
                HttpSession Session = request.getSession(true); 
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		RequestDispatcher loginfail = request.getRequestDispatcher("/login.jsp");
		RequestDispatcher loginsuccess = request.getRequestDispatcher("/register.jsp");
		
		UserDAO udao = new UserDAO();
		
		User user = null;
			
		
		try {
			
			user = udao.authenticateUser(username, password);
			Session.setAttribute("loginUserName", username);
			loginsuccess.forward(request, response);			
			
		} catch (Exception e) {
			
			request.setAttribute("message", e.getMessage());
			loginfail.forward(request, response);
			
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
