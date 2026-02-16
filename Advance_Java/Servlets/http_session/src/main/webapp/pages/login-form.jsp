<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<base href="<%=basePath%>">
<body >
<%
if(request.getParameter("type").equals("0")){
	out.print("invalid credential,please login again");
}

%>

 </body>
 
<form action="auth">
<input type="text" name="user" values="" placeholder="enter username">
<input type="password" name="pwd" values="" placeholder="enter password">
<input type="submit" value="login" > 
</form>>


</html>