<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOut</title>
</head>
<body>
	<% session.invalidate(); %>
	<!-- <jsp:forward page="login.jsp"/> -->
	<% 
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	%>
</body>
</html>