<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.Date" %>
<%@page import="com.lab.*" %>
<p>Date: </p>
<%= new Date() %>

<%
TextOutput output = new TextOutput();
out.println(output.getInfo());
%>
</body>
</html>