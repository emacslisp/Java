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

<%
String ip = request.getHeader("X-Forwarded-For");  
if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
    ip = request.getHeader("Proxy-Client-IP");  
}  
if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
    ip = request.getHeader("WL-Proxy-Client-IP");  
}  
if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
    ip = request.getHeader("HTTP_CLIENT_IP");  
}  
if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
    ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
}  
if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
    ip = request.getRemoteAddr();  
}
out.println("<br/>");
out.println(ip);
%>

<%

String userAgent = request.getHeader("user-agent");
out.println("<br/>");
out.println("user agent is " + userAgent);

%>

<%

String port = request.getHeader("remote-port");
out.println("<br/>");
out.println("remote port is " + port);

%>

<%
	ServletContext context = getServletContext();
	String adminName = (String)context.getInitParameter("AdminName");
	out.println("<br/>");
	out.println("get config from ServletContext: AdminName " + adminName);
%>
</body>
</html>