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

<script>
	function SubmitExamForm() {
		 var questionid = document.getElementById("questionid").value.trim();
		
		  if (questionid === "") {
		      alert("Are you sure you want to delete this exam?");
		      return false; // Prevent form submission
		  }
		
		  return true; // Allow form submission
	}
</script>

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
                <th>QUESTION ID</th>
                <th>QUESTION 1</th>
                <th>QUESTION 2</th>
                <th>QUESTION 3</th>
                <th>QUESTION 4</th>
                <th>QUESTION 5</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="e" items="${exam}">
              
              <c:set var="id"  value="${e.id}"/>
              <c:set var="questionid"  value="${e.questionid}"/>
              <c:set var="question1"  value="${e.question1}"/>
              <c:set var="question2"  value="${e.question2}"/>
              <c:set var="question3"  value="${e.question3}"/>
              <c:set var="question4"  value="${e.question4}"/>
              <c:set var="question5"  value="${e.question5}"/>
              
                <tr>
                  <td>${e.id}</td>
                  <td>${e.questionid}</td>
                  <td>${e.question1}</td>
                  <td>${e.question2}</td>
                  <td>${e.question3}</td>
                  <td>${e.question4}</td>
                  <td>${e.question5}</td>
                  <td>
                  	<form action="GKUpdate.jsp" method="post" style="display:inline;">
					  <input type="hidden" name="id" value="${e.id}" />
					  <input type="hidden" name="questionid" value="${e.questionid}" />
					  <input type="hidden" name="question1" value="${e.question1}" />
					  <input type="hidden" name="question2" value="${e.question2}" />
					  <input type="hidden" name="question3" value="${e.question3}" />
					  <input type="hidden" name="question4" value="${e.question4}" />
					  <input type="hidden" name="question5" value="${e.question5}" />
					  <button type="submit" class="btn btn-warning btn-sm">✏️ Edit</button>
					</form>
					
					<form action="deleteExam" method="post" style="display:inline;" onsubmit="return SubmitExamForm();">
					   <input type="hidden" name="id" value="${e.id}" />
					   <button type="submit" class="btn btn-danger btn-sm">🗑 Delete</button>
					</form>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


