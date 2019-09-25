<%@page import="java.util.Date" %>
<%@page import="com.lab.*" %>
<p>this is partial page</p>
<p>Date: </p>
<%= new Date() %>

<%
TextOutput output = new TextOutput();
out.println(output.getInfo());
%>