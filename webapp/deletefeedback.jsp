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
	String id =request.getParameter("id"); 
	String name =request.getParameter("name"); 
	String email =request.getParameter("email"); 
	String phone =request.getParameter("phone"); 
	String userName =request.getParameter("uname"); 
	String password =request.getParameter("pass"); 
	%>
	
		<h1>Feedback Delete</h1>
		<form action="delete" method ="post">
			Feedback ID : <input type ="text" name ="feedId" value ="<%=id %>" readonly><br> 
			Name : <input type ="text" name ="name" value ="<%=name %>" readonly><br>
			Email : <input type ="email" name ="email" value ="<%=email %>" readonly><br>
			Phone : <input type ="tel" name ="phone" value ="<%=phone %>" readonly><br>
			User Name : <input type ="text" name ="uname" value ="<%=userName %>" readonly><br>
			
			
			<input type ="submit" name ="submit" value ="Delete My Account"><br>
			
		</form>

</body>
</html>