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
<body>
<h2> welcome to landing page....ready for sweet disaster</h2>

<%
if(session.getAttribute("user")==null){
	response.sendRedirect("pages/login-form.jsp?type=0");
}
%>

</body>
</html>