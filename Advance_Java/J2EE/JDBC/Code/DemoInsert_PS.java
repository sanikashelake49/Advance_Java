package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.db.MysqlDbConn;

public class DemoInsert_PS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Connection conn;
      PreparedStatement prp;
      String qry="insert into customer values(?,?)";  //?-in parameters
      MysqlDbConn ds=new MysqlDbConn();
      conn=ds.getMyConnection();
      try {
      prp=conn.prepareStatement(qry);
      //set the IN-PARAMETERS
      prp.setInt(1, Integer.parseInt(args[0]));
      prp.setString(2,args[1]);
      int row=prp.executeUpdate();
      if(row>0)
    	  System.out.println("success");
      
	}
	catch(Exception e) {
		e.printStackTrace();
		}

   }
	
}
