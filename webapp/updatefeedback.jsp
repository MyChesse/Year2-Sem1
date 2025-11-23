<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <% %> use this mark to run java code in jsp --%>
	<%
	//useraccount.jsp names as parameter names
	String id =request.getParameter("id"); 
	String name =request.getParameter("name"); 
	String email =request.getParameter("email"); 
	String phone =request.getParameter("phone"); 
	String userName =request.getParameter("uname"); 
	String password =request.getParameter("pass"); 
	%>
		<form action="update" method ="post">
			Feedback ID : <input type ="text" name ="cusid" value ="<%=id %>" readonly><br> 
			Name : <input type ="text" name ="name" value ="<%=name %>"><br>
			Email : <input type ="email" name ="email" value ="<%=email %>"><br>
			Phone : <input type ="tel" name ="phone" value ="<%=phone %>"><br>
			User Name : <input type ="text" name ="uname" value ="<%=userName %>"><br>
			Password : <input type ="password" name ="pass" value ="<%=password %>"><br>
			
			<input type ="submit" name ="submit" value ="Update My Data"><br>
			
		</form>
		
</body>
</html>