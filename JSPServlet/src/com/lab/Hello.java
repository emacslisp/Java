package com.lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void printOutHtmlPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("  <head>");
		out.println("    <title>jsp title</title>");
		out.println("  </head>");
		out.println("");
		out.println("  <body>");
		out.println("  <p>this is a page from sub function</p>");
		out.println("  </body>");
		out.println("</html> ");

		out.flush();
    }
    
    private void getUrlParameters(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String user = request.getParameter("user");
    	PrintWriter out = response.getWriter();
    	out.print(user);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this.printOutHtmlPage(request, response);
		
		this.getUrlParameters(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
