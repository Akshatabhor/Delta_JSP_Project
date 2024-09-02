<%@page import="com.project.bean.Emp" %>
<%@page import="com.project.dao.SqlQueries" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	List<Emp> al = SqlQueries.datafetch();
	%>
	<table border='2'>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>City</th>
			<th>Mobile</th>
		</tr>
	
	<%
	for (Emp x : al) 
	{
	%>
	<tr>
		<td><%=x.getId()%></td>
		<td><%=x.getName()%></td>
		<td><%=x.getCity()%></td>
		<td><%=x.getMobile()%></td>
		<td>
			<form action ="homeServlet" method=post>
			<input type ="hidden" name=opr value="update">
			<input type ="hidden" name=id value=<%=x.getId()%>>
			<button type="submit">Update</button>
			</form>
			
		</td>
		<td>
			<form action="homeServlet" method=post>
			<input type="hidden" name=opr value="delete">
			<input type="hidden" name=id value=<%=x.getId()%>>
			<button type="submit">Delete</button>
			</form>
		</td>
	</tr>
	<% } %>
</table>
</body>
</html>