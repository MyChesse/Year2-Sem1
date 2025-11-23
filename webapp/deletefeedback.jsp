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
=======
<%
    String idParam = request.getParameter("id");
    if (idParam == null) {
        response.sendRedirect("profile.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"/>
    <title>Confirm Delete</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light" background ="LOGO/background.jpg">

<div class="container mt-5">
    <div class="card p-4 shadow-sm">
        <h4 class="mb-3">Are you sure you want to delete this feedback/report?</h4>

        <form action="delete" method="post">
            <input type="hidden" name="id" value="<%= idParam %>">
            <button type="submit" class="btn btn-danger">Yes, Delete</button>
            <a href="profile.jsp" class="btn btn-secondary ms-2">Cancel</a>
        </form>
    </div>
</div>

</body>
</html>

