package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.db.MysqlDbConn;

public class Demo_Start_BulkOprs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		Statement st;
		MysqlDbConn ds=new MysqlDbConn();  //reusability
		conn=ds.getMyConnection();
		
		try {
			//set the auto commit feature to false
			conn.setAutoCommit(false);
			st=conn.createStatement();
			//conn.setAutoCommit(false);
			st.addBatch("insert into customer values(11,'java')"); //adding the data which is more that 1 line
			st.addBatch("insert into customer values(22,'spring')");
			st.addBatch("insert into customer values(33,'springboot')");
			
			//execute the batch
			st.executeBatch();
			//commit the operation
			//conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			try {
				conn.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
