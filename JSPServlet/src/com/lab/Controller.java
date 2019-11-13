package com.lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String user = request.getParameter("user");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("  <head>");
		out.println("    <title>jsp title</title>");
		out.println("  </head>");
		out.println("");
		out.println("  <body>");
		out.println("  <p> username: " + user + "</p>");
		out.println("  </body>");
		out.println("</html> ");

		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("  <head>");
		out.println("    <title>jsp title</title>");
		out.println("  </head>");
		out.println("");
		out.println("  <body>");
		out.println("  <p> post username: " + user + "</p>");
		out.println("  </body>");
		out.println("</html> ");

		out.flush();
	}

}
