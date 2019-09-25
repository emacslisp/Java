<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
private String name = "this is declare.jsp";
private String getInfo() {
	return name;
}
%>

<%
out.println(getInfo());
%>
</body>
</html>