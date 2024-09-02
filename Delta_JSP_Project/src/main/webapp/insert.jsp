<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insert your Employee Data</h1>
<form action ="homeServlet" method=post>
<input type="hidden" name=opr value="insert">
id <input type="number" name =id><br>
Name <input type="text" name =name><br>
City <input type="text" name =city><br>
Mobile Number <input type="text" name =mobile><br>
<br>

<button type="submit">Insert Data</button>
</form>

<form action ="homeServlet" method=post >
<input type="hidden" name=opr value="datafetch">
<button type="submit">View data </button>
</form>


</body>
</html>