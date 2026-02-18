<%@ page language="java" import ="java.sql.*"contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my page</title>
</head>
<body bgcolor='turquoise'>
<%
out.print("welcome to jsp");
%>
<h3>sum is </h3>
<p></p>
<h3>random no is <%= Math.random() %>
<%!
  int f(){
	int a=5;
	int b=10;
	return (a+b);
}
%>

<%=f() %>

</body>
</html>