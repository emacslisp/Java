
<%
	String uid = (String)session.getAttribute("user");
	if (uid == null)
	{
%>
<jsp:forward page="index.jsp" />
<%	
	}
	else
	{
		out.println(" <h1>You have successfully created the Session of User : " +uid+"</h1>");
%>
<a href="logout.jsp">Logout</a>
<%
}
%>
