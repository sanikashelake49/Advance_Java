package com.jdbc;


import java.sql.Connection;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.util.db.MyConn;
import com.util.db.MysqlDbConn;

public class DemoJdbcStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn; //to hold the connection-Interface
		Statement st;//to embed the sql query
		String qry="insert into customer values(1,'java')";
		MysqlDataSource ds;  //	
		try {
		/*ds=new MysqlDataSource();
		//injecting the details of the db
		ds.setUser("root");//default user name
		ds.setPassword("root"); //password
		ds.setServerName("localhost"); //127.0.0.1(ANOTHER OPTION) db resides locally in this case
		ds.setDatabaseName("db_j2ee");//checks for the table in this folder
		ds.setPort(3306);  //port no where db listens to the request from the client-reserved port no
		
		//get the connection*/
		// conn=ds.getConnection();...3
		//conn=MysqlDbConn.getMyConnection();..2//conn contains whole information
			//MysqlDbConn ds=new MysqlDbConn();
		st=MyConn.getState();
		//embed the sql query
		//st=conn.createStatement();..1
		//execute the query
		int row =st.executeUpdate(qry);//perform insert,update,delete operations
		if(row>0)
			 System.out.println("success");
		else 
			System.out.println("fail");
		
		}catch(Exception e) {
			e.printStackTrace();
	}
	}

}
