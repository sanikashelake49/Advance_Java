<%@page import="java.io.IOException"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileWriter"%>
<%@page import="com.mysql.cj.jdbc.MysqlDataSource"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer data</title>
</head>
<body bgcolor="beige" text="violet">
<jsp:useBean id="cust" class="com.bean.CustomerBean"> <!-- creates an instance --></jsp:useBean>
<!-- injects the value into the bean thru setter method -->
<jsp:setProperty name="cust" param="custId" property="custId"/>
<jsp:setProperty name="cust" param="custName" property="custName"/>

<!-- fetching the data -->
<h3> CUSTOMER DATA IS</h3>
<jsp:getProperty name="cust" property="custId"/>
<jsp:getProperty name="cust" property="custName"/>
 
<!--   ${cust.custId}<!-- EXPRESSION LANG -->
 ${cust.custName}
 

 
 </body>
 </html>
 
 <%
 Connection conn;
 PreparedStatement prp;
 String qry="insert into data values(?,?)";
 MysqlDataSource ds;
 
 String id=request.getParameter("custId");
 String name=request.getParameter("custName");
 try{
	 ds=new MysqlDataSource();
	 ds.setUser("root");
	 ds.setPassword("root");
	 ds.setServerName("localhost");
	 ds.setDatabaseName("db_j2ee");
	 ds.setPort(3306);
	 
	 conn=ds.getConnection();
	 prp=conn.prepareStatement(qry);
	 
	 prp.setInt(1, Integer.parseInt(id));
	 prp.setString(2, name);
	 
	 int row=prp.executeUpdate();
	 if(row>0)
		 System.out.println("success");
	 
 }catch(Exception e){ 
	 e.printStackTrace();
 }
 %>
 
 <%
   FileWriter fw=null;
   
   
   
   String id1=request.getParameter("custId");
   String name1=request.getParameter("custName");
   
   try{
   
   String path="D:\\SOFTRA_J2EE\\web_appl\\file\\bean.txt";
   
   fw=new FileWriter(path,true);
   
   
	   
	  //int num=Integer.parseInt(id1);
	   fw.write(id1);
	   fw.write("#");
	   fw.write(name1);
	   fw.write("#");
   
   System.out.println(id1);
   
   }catch(Exception e)
   {
	  // fw.close();
	   e.printStackTrace();
   }finally{
	   try{
		   fw.close();
	   }catch(IOException e){
		   e.printStackTrace();
	   }
   }
   
   
   
   
   
 
 %>
 
 