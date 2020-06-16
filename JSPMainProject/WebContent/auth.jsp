
<%@page import="com.lab.User" %>
<%
	User user = (User)request.getSession().getAttribute("session");
	if (user == null)
	{
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
%>
