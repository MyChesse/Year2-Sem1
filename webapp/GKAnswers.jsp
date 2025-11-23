<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Exam Details</title>
  <link href="CSS/bootstrap.min.css" rel="stylesheet">
  <link href="CSS/styles.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
	  .sidebar {
	    min-height: 100vh;
	    background-color: #343a40;
	    color: white;
	    padding-top: 1rem;
	  }
	
	  .sidebar a {
	    color: white;
	    padding: 10px 15px;
	    display: block;
	    text-decoration: none;
	  }
	
	  .sidebar a:hover {
	    background-color: #495057;
	  }
	
	  table {
	    width: 100%;
	    table-layout: fixed;
	    
	  }

	  th, td {
	    word-wrap: break-word;
	    text-align: center;
	    padding: 10px;
	  }
	
	  th:nth-child(1), td:nth-child(1) { width: 5%; }
	  th:nth-child(2), td:nth-child(2) { width: 10%; }
	  th:nth-child(3),
	  th:nth-child(4),
	  th:nth-child(5),
	  th:nth-child(6),
	  th:nth-child(7),
	  td:nth-child(3),
	  td:nth-child(4),
	  td:nth-child(5),
	  td:nth-child(6),
	  td:nth-child(7) { width: 15%; }
	  th:nth-child(8), td:nth-child(8) { width: 15%; }
	</style>

</head>
<body>

	<nav class="navbar navbar-expand-lg px-4">
	    <a class="navbar-brand d-flex align-items-center" href="profile.jsp">
	        <img src="LOGO/logo.png" alt="Owling Logo">
	    </a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
	        <span class="navbar-toggler-icon"></span>
	    </button>
	
	    
	     <div class="collapse navbar-collapse" id="navMenu">
	        <ul class="navbar-nav ms-auto">
	            <li class="nav-item"><a class="nav-link" href="profile.jsp"><span class="fw-bold text-primary">Penguin.lk</span></a></li>
	        </ul>
	    </div>
	    
	  </nav>
          <table class="table table-bordered table-hover mb-0 text-center">
            <thead class="custom-header" >
              <tr>
              	<th>ID</th>
                <th>SID</th>
                <th>QUESTION 1 ANSWERS</th>
                <th>QUESTION 2 ANSWERS</th>
                <th>QUESTION 3 ANSWERS</th>
                <th>QUESTION 4 ANSWERS</th>
                <th>QUESTION 5 ANSWERS</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="a" items="${answer}">
              
                <tr>
                  <td>${a.id}</td>
                  <td>${a.sid}</td>
                  <td>${a.answer1}</td>
                  <td>${a.answer2}</td>
                  <td>${a.answer3}</td>
                  <td>${a.answer4}</td>
                  <td>${a.answer5}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


