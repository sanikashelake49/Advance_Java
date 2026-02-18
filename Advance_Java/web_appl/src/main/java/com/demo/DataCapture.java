package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class DataCapture
 */
@WebServlet(description = "this is sign process", urlPatterns = { "/DataCapture" })
public class DataCapture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement prp;
	MysqlDataSource ds;
	String qry="insert into customer values(?,?)";
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataCapture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType( "text/html");
		//capturing data entered by user
		String userId=request.getParameter("user");
		String userPwd=request.getParameter("pwd");
		
		PrintWriter out=response.getWriter();
		out.print("user data is "+userId+" "+userPwd);
		
		try
		{
		//now we are injecting user details into database table
		ds=new MysqlDataSource();
		
		ds.setUser("root");
		ds.setPassword("root");
		ds.setServerName("localhost");
		ds.setDatabaseName("db_j2ee");
		ds.setPort(3306);
		
		
			
			conn=ds.getConnection();
		    prp=conn.prepareStatement(qry);
		
		    prp.setInt(1, Integer.parseInt(userId));
			prp.setString(2,userPwd);
			
			prp.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

}
