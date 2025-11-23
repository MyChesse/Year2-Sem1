<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback and Report</title>
</head>
<body>
	<table>
	<c:forEach var ="feed" items ="${feedDetails}"> <%-- data from Servlet --%>

		<%-- assign to the variables --%>
		<c:set var="id" value="${feed.id}"/>
		<c:set var="name" value="${feed.name}"/>
		<c:set var="email" value="${feed.email}"/>
		<c:set var="phone" value="${feed.phone}"/>
		<c:set var="username" value="${feed.userName}"/>
		<c:set var="password" value="${feed.password}"/>
		
		<tr>
			<td>Feedback ID</td>
			<td>${feed.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${feed.name}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${feed.email}</td>
		</tr>
		<tr>
			<td>Phone</td>
			<td>${feed.phone}</td>
		</tr>
		<tr>
			<td>User Name</td>
			<td>${feed.userName}</td> 
		</tr>
		<tr>
			<td>Password</td>
			<td>${feed.password}</td>
		</tr>
		
	</c:forEach>	
	</table>
	
	<%-- need to pass the details, to updatefeedback.jsp --%>
	<c:url value="updatefeedback.jsp" var ="feedupdate">
		
		<%-- give upper variables as values --%>
		<c:param name="id" value="${id}"></c:param>
		<c:param name="name" value="${name}"></c:param>
		<c:param name="email" value="${email}"></c:param>
		<c:param name="phone" value="${phone}"></c:param>
		<c:param name="uname" value="${username}"></c:param>
		<c:param name="pass" value="${password}"></c:param>
		
	</c:url>
	
	<a href="${feedupdate} "> <%-- pass the variable of <c:url> --%>
	<input type="button" name="update" value="Update My Data"> <%-- button performs anchor tag --%>
	</a>
	
	<br>
	<c:url value="deletefeedback.jsp" var="feeddelete">
		<c:param name="id" value="${id}"></c:param>
		<c:param name="name" value="${name}"></c:param>
		<c:param name="email" value="${email}"></c:param>
		<c:param name="phone" value="${phone}"></c:param>
		<c:param name="uname" value="${username}"></c:param>
		<c:param name="pass" value="${password}"></c:param>
	</c:url>
	<a href="${feeddelete}">
	<input type="button" name="delete" value="Delete My Account">
</body>
</html>