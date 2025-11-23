<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Exam Questions</title>
  <link href="CSS/bootstrap.min.css" rel="stylesheet">
  <link href="CSS/styles.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #eaf6fc;
    }

    .container-box {
      background-color: white;
      border: 1px solid #007bff;
      border-radius: 10px;
      padding: 20px;
      margin-top: 30px;
      box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.1);
    }

    .question-box {
      border: 1px solid blue;
      border-radius: 10px;
      padding: 15px;
      margin-bottom: 20px;
      background-color: #f9f9ff;
    }

    .question-label {
      font-weight: bold;
      font-size: 1.1rem;
    }
    .submit-btn {
      border-radius: 5px;
      background-color: #007bff;
      border: none;
      padding: 10px 20px;
      font-size: 16px;
      color:white;
    }
    .form-control {
      background-color: #ebf5fb;
      border: none;
    }
	.form-control1 {
      background-color: white;
      border: none;
      border-radius:5px;
      width:100%;
      height: 35px;
      padding-left: 13px;
    }
    .mark-note {
      font-size: 0.9rem;
      color: #555;
    }
  </style>
</head>
<body>



	<nav class="navbar navbar-expand-lg px-4">
	    <a class="navbar-brand d-flex align-items-center" href="profile.jsp">
	        <img src="LOGO/logo.png" alt="Owling Logo">
	        <span class="fw-bold text-primary">Penguin.lk</span>
	    </a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
	        <span class="navbar-toggler-icon"></span>
	    </button>
	
	    <div class="collapse navbar-collapse" id="navMenu">
	        <ul class="navbar-nav ms-auto">
	            <li class="nav-item"><a class="nav-link" href="profile.jsp"><b>Profile</b></a></li>
	            <li class="nav-item"><a class="nav-link" href="#"><b>Tab 02</b></a></li>
	            <li class="nav-item"><a class="nav-link" href="#"><b>Tab 03</b></a></li>
	            <li class="nav-item"><a class="nav-link" href="#"><b>Tab 04</b></a></li>
	            <li class="nav-item"><a class="nav-link" href="addFeedback.jsp"><b>Feedbacks and Reports</b></a></li>
	        </ul>
	    </div>
	</nav>
	<div class="container mt-4">
  
    <form action="#" method="post" onsubmit="return confirm('Are you sure you want to submit answers?');">
      
      <div class="question-box">
      	<div class="mb-4">
        <label for="sid" class="form-label">Enter SID</label>
        <input type="text" class="form-control" id="sid" name="sid" placeholder="Student ID">
      	</div> 
      </div>
      
 

      <!-- Question 1 -->
      <div class="question-box">
        <div class="question-label">Question 1</div>
        <div class="mark-note">marked out of 5.00</div>
        <input type="text" class="form-control1" name="question1"  readonly/>
        <input type="text" class="form-control mt-2" name="answer1" placeholder="Enter answer" />
      </div>

      <!-- Question 2 -->
      <div class="question-box">
        <div class="question-label">Question 2</div>
        <div class="mark-note">marked out of 5.00</div>
        <input type="text" class="form-control1" name="question2"  readonly/>
        <input type="text" class="form-control mt-2" name="answer2" placeholder="Enter answer" />
      </div>

      <!-- Question 3 -->
      <div class="question-box">
        <div class="question-label">Question 3</div>
        <div class="mark-note">marked out of 5.00</div>
        <input type="text" class="form-control1" name="question3"  readonly/>
        <input type="text" class="form-control mt-2" name="answer3" placeholder="Enter answer" />
      </div>

      <!-- Question 4 -->
      <div class="question-box">
        <div class="question-label">Question 4</div>
        <div class="mark-note">marked out of 5.00</div>
        <input type="text" class="form-control1" name="question4"  readonly/>
        <input type="text" class="form-control mt-2" name="answer4" placeholder="Enter answer" />
      </div>

      <!-- Question 5 -->
      <div class="question-box">
        <div class="question-label">Question 5</div>
        <div class="mark-note">marked out of 5.00</div>
        <input type="text" class="form-control1" name="question5"  readonly/>
        <input type="text" class="form-control mt-2" name="answer5" placeholder="Enter answer" />
      </div>

      <div class="text-center">
        <button type="submit" class="submit-btn">💾 Submit Answers</button>
      </div>

    </form>
  
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>