package com.demo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(description = "My own Servlet", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub  //init command 
		System.out.println("initialized");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroyed");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//setting the MIME type to text/html
		response.setContentType("text/html");
		//sending the output to the browser
		PrintWriter out=response.getWriter();//text display son the browser
		HttpSession session=request.getSession();
		out.println("<html><body bgcolor='cyan'>");
		out.print("<h2>welcome to servlet </h2>");
		
	    	out.print(session.getAttribute("<table>\r\n"
	    			+ "    <tr>\r\n"
	    			+ "        <th>ID</th>\r\n"
	    			+ "        <th>Password</th>\r\n"
	    			+ "    </tr>\r\n"
	    			+ "    <tr>\r\n"
	    			+ "        <td></td>\r\n"
	    			+ "        <td></td>\r\n"
	    			+ "    </tr>\r\n"
	    			+ "    <tr>\r\n"
	    			+ "        <td></td>\r\n"
	    			+ "        <td></td>\r\n"
	    			+ "    </tr>\r\n"
	    			+ "</table>\r\n"
	    			+ ""));
		//out.print(Math.random());
		
		
	}

}
