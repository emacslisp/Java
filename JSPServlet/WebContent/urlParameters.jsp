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
	String name = request.getParameter("username");
	out.print(name);
%>
<%@ include file="Partial/Date.jsp" %>

<jsp:include page="Partial/Date.jsp" />
</body>
</html>