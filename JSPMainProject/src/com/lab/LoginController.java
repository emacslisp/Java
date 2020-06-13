package com.lab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lab.User;
import com.lab.bll.UserBLL;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		request.setAttribute("username", username);
		
		User user = new User(username, password);
		UserBLL userBLL = new UserBLL();
		if (user.validate() && userBLL.validUserNamePassword(username, password)) {
			request.getSession().setAttribute("session", user);
			// request.getRequestDispatcher("/Dashboard.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/Dashboard.jsp");
		} else {
			if(user.getMessage() != "") {
				request.setAttribute("validationMessage", user.getMessage());
			} else {
				request.setAttribute("validationMessage", "Username and password are not valid");
			}
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
