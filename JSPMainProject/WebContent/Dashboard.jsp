<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.lab.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
</head>
<body>
<p> this is user Dashboard</p>

<%
User user = (User)request.getSession().getAttribute("session");

out.print(user.getEmail() + "Login successfully");
%>

<a href="<%= request.getContextPath() %>/Logout">Log out</a>
</body>
</html>