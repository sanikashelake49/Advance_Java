package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class LoginAuth
 */
@WebServlet("/loginauth")
public class LoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement prp;
	MysqlDataSource ds;
	ResultSet rs;
	//String qry="insert into customer values(?,?)";
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		//get the values from client
		String userId=request.getParameter("user").trim();
		String userName=request.getParameter("pwd").trim();
		String qry="select * from customer where id=? and name=?";
		//RS
		
		
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
			prp.setString(2,userName);
			
			rs=prp.executeQuery();
			
			if(rs.next()) //this condition will be true when userid and pass matches
			     response.sendRedirect("signup.html");
			else
			{
				PrintWriter out=response.getWriter();
				out.print("error");
			}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get the connection
		//preparedstatement prp
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
