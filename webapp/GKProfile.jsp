<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Lecture Dashboard</title>
  <link href="CSS/bootstrap.min.css" rel="stylesheet">
  <link href="CSS/styles.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #eaf6fd;
      font-family: Arial, sans-serif;
    }
    .sidebar {
      min-height: 100vh;
      background-color: #137ab8;
      color: white;
      padding-top: 20px;
    }
    .sidebar a {
      color: white;
      padding: 13px 20px;
      display: block;
      text-decoration: none;
      font-size: 16px;
    }
    .sidebar a:hover {
      background-color: #0f5c8c;
    }
    .form-container {
      background-color: white;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      margin: 0 40px 0 40px;
      border: 1px solid blue;
    }
    .form-title {
      font-size: 30px;
      font-weight: bold;
      text-align: center;
      margin-bottom: 20px;
      color: #495057;
    }
    .form-label {
      font-weight: bold;
      color: black;
    }
    .form-control {
      border-radius: 5px;
    }
    .primary{
      border: none;
      background-color: #137ab8;
      color: white;
      padding: 10px 20px;
      display: block;
      text-decoration: none;
      font-size: 16px;
    }
    .primary:hover {
      background-color: #0f5c8c;
      width:100%;
      text-align:left;
    }
    .btn-primary {
      border-radius: 5px;
      background-color: #007bff;
      border: none;
      padding: 10px 20px;
      font-size: 16px;
    }
    .btn-primary:hover {
      background-color: #0056b3;
    }
    .logout {
      position: absolute;
      bottom: 20px;
    }
    .logout a {
      color: white;
      padding-left: 20px;
      text-decoration: none;
      display: block;
      
    }
    .logout a:hover {
      background-color: #0f5c8c;
      width:100%;
      
    }
  </style>
</head>
<body>

<%
    String success = (String) request.getAttribute("successMessage");
    String error = (String) request.getAttribute("errorMessage");
    if (success != null) {
%>
    <script>alert("<%= success %>");</script>
<%
    } else if (error != null) {
%>
    <script>alert("<%= error %>");</script>
<%
    }
%>
	<script>
		function validateExamForm() {
		    var questionid = document.getElementById("questionid").value.trim();
		
		    if (questionid === "") {
		        alert("Question ID must not be empty.");
		        return false; // Prevent form submission
		    }
		
		    return true; // Allow form submission
		}
	</script>

<div class="container-fluid">
  <div class="row">
    <!-- Sidebar -->
    <nav class="col-md-2 sidebar">
      <div class="profile">
      	<i style="font-size: 70px;">👤</i>
        <span>Lecture Profile</span>
      </div>
      <a href="#">📊 Dashboard</a>
      <a href="#">📝 Assignments</a>
      <a href="#">🗓️ Schedule</a>
      
      <form action="Details" method="post" class="text-center mt-3">
        <button type="submit" class="primary" >📄 View All Questions</button>
     </form>
     
     <form action="answer" method="post" class="text-center mt-3">
        <button type="submit" class="primary" >✍️ View All Answers</button>
     </form>
     
      <div class="logout">
        <a href="#">➡️ Log out</a>
      </div>
    </nav>

    <!-- Main Content -->
    <main class="col-md-10 pt-3">
    
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
		
      <div class="form-container">
        <h2 class="form-title">ADD QUESTION</h2>
        
        <form action="addExam" method="post" onsubmit="return validateExamForm();">
          <div class="form-group mb-3">
            <label for="questionid" class="form-label">Question ID</label>
            <input type="text" class="form-control" id="questionid" name="questionid" placeholder="Enter your question id">
          </div>
          <div class="form-group mb-3">
            <label for="question1" class="form-label">Question 1</label>
            <input type="text" class="form-control" id="question1" name="question1" placeholder="Enter question 1">
          </div>
          <div class="form-group mb-3">
            <label for="question2" class="form-label">Question 2</label>
            <input type="text" class="form-control" id="question2" name="question2" placeholder="Enter question 2">
          </div>
          <div class="form-group mb-3">
            <label for="question3" class="form-label">Question 3</label>
            <input type="text" class="form-control" id="question3" name="question3" placeholder="Enter question 3">
          </div>
          <div class="form-group mb-3">
            <label for="question4" class="form-label">Question 4</label>
            <input type="text" class="form-control" id="question4" name="question4" placeholder="Enter question 4">
          </div>
          <div class="form-group mb-3">
            <label for="question5" class="form-label">Question 5</label>
            <input type="text" class="form-control" id="question5" name="question5" placeholder="Enter question 5">
          </div>
          <div class="form-group text-center">
            <button type="submit" class="btn btn-primary">💾 Save</button>
          </div>
        </form>
        
      </div>
      
    </main>
    
    
  </div>
</div>
<div style="color: white; font-size: small; text-align: center; padding: 10px; background-color: rgb(90, 90, 90);">
        <!-- Logo -->
        <img src="LOGO/logo.png" alt="Logo" style="width: 150px; height: auto; margin-bottom: 20px;">

        <div style="display: flex; justify-content: center; flex-wrap: wrap; margin-bottom: 20px;">
            <div style="margin: 0 15px;">Information Technology</div>
            <div style="margin: 0 15px;">Engineering</div>
            <div style="margin: 0 15px;">Management</div>
            <div style="margin: 0 15px;">Medicine</div>
            <div style="margin: 0 15px;">Languages</div>
        </div>

        <p>Copyright � 2025 Online Examination Website. All rights reserved.<br>penguin.lk</p>
</div>
<div style="background-color: DodgerBlue; height :5px;">
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
