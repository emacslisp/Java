<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="com.lab.User" scope="session"></jsp:useBean>
<jsp:setProperty name="user" property="email" value="abc@gmail.com"/>
<jsp:setProperty property="password" name="user" value="123456"/>
</body>
</html>