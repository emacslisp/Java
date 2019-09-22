<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
java.util.Date today = new java.util.Date();
String text = "Today's Date is: " + today.toString();

out.println(text);
%>
<br/>
<%=
	new java.util.Date()
%>
</body>
</html>