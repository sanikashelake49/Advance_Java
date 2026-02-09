package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import com.util.db.MysqlDbConn;

public class Demo_RS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		PreparedStatement prp;
		ResultSet rs;
		String qry="select * from customer";
		MysqlDbConn ds=new MysqlDbConn();
		conn=ds.getMyConnection();
		try {
		prp=conn.prepareStatement(qry);
		rs=prp.executeQuery();
		while(rs.next()) {
			System.out.println("id is "+rs.getInt("id"));
			System.out.println("name is "+rs.getString(2));
		}
		

	}catch(Exception e) {
		e.printStackTrace();}
	}

}
