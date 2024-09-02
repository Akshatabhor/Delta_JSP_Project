<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.project.bean.Emp" %> 
  <%@page import="com.project.dao.SqlQueries" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
Emp ob=SqlQueries.update(id);
%>>

<h1>Data are</h1>

<form action ="homeServlet" method =post>
<input type="hidden" name=opr value="edit">
<input type = "hidden" name = id value = <%= ob.getId()%>> <br><br>
name<input type="text" name=name value=<%=ob.getName() %>><br>
city<input type="text" name=city value=<%=ob.getCity() %>><br>
mobile no<input type="text" name=mobile value=<%=ob.getMobile() %>><br><br>
<button type="submit">Update</button>


</form>
</body>
</html>