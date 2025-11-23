<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/CSS/bootstrap.min.css" rel="stylesheet">
    <link href="CSS/bootstrap.min.css" rel="stylesheet">
    <link href="CSS/styles.css" rel="stylesheet">
    
    <style>
    .link{
      border: none;
      background-color:white;
      color: black;
      margin-top: -7px;
      padding: 0 20px;
      display: block;
      text-decoration: none;
      font-size: 16px;
    }
    .link:hover{
    	color:blue;
    }
    </style>
</head>
<body class="bg-light" background ="LOGO/background.jpg">

<nav class="navbar navbar-expand-lg px-4">
    <a class="navbar-brand d-flex align-items-center" href="About.jsp">
        <img src="LOGO/logo.png" alt="Owling Logo">
        <span class="fw-bold text-primary">Penguin.lk</span>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav ms-auto">
            <li class="nav-item"><a class="nav-link" href="profile.jsp"><b>Profile</b></a></li>
            <li class="nav-item">
            	<form action="viewExam" method="post" class="text-center mt-3">
			        <button type="submit" class="link" ><b>View Questions</b></button>
			     </form>
            </li>
            <li class="nav-item"><a class="nav-link" href="#"><b>Tab 03</b></a></li>
            <li class="nav-item"><a class="nav-link" href="#"><b>Tab 04</b></a></li>
            <li class="nav-item"><a class="nav-link" href="addFeedback.jsp"><b>Feedbacks and Reports</b></a></li>
            <li class="nav-item"><a href="LectureLogin.jsp" class="nav-link text-danger">Login</a></li>
        </ul>
    </div>
</nav>
<!-- Welcome Section -->
<section class="text-center py-5">
  <div class="container">
    <h2 class="text-primary">Welcome to the Online Examination System</h2>
    <p class="lead">Take your exams anytime, anywhere – securely and efficiently.</p>
    <img src="LOGO/logo.png" class="img-fluid rounded mt-4" alt="Online Exam" />
  </div>
</section>

<!-- How It Works -->
<section class="py-5 bg-white">
  <div class="container">
    <h3 class="text-success text-center mb-4">How It Works</h3>
    <div class="row text-center">
      <div class="col-md-4">
        <div class="p-3 border rounded shadow-sm">
          <h5 class="text-primary">1. Register</h5>
          <p>Create an account to get started with your exams.</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="p-3 border rounded shadow-sm">
          <h5 class="text-success">2. Choose Exam</h5>
          <p>Select the subject or test you want to take.</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="p-3 border rounded shadow-sm">
          <h5 class="text-secondary">3. Start Exam</h5>
          <p>Begin your exam and get real-time results instantly.</p>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Exam Categories -->
<section class="py-5" style="background-color: #f1f1f1;">
  <div class="container">
    <h3 class="text-center text-primary mb-4">Available Exam Categories</h3>
    <div class="row text-center">
      <div class="col-md-3 mb-3">
        <div class="p-3 border rounded bg-white shadow-sm">Aptitude Tests</div>
      </div>
      <div class="col-md-3 mb-3">
        <div class="p-3 border rounded bg-white shadow-sm">Technical Exams</div>
      </div>
      <div class="col-md-3 mb-3">
        <div class="p-3 border rounded bg-white shadow-sm">Mock Interviews</div>
      </div>
      <div class="col-md-3 mb-3">
        <div class="p-3 border rounded bg-white shadow-sm">Final Assessments</div>
      </div>
    </div>
  </div>
</section>

<!-- Why Choose Us -->
<section class="py-5 bg-white">
  <div class="container">
    <h3 class="text-success text-center mb-4">Why Choose Our Platform?</h3>
    <div class="row">
      <div class="col-md-6">
        <ul class="list-group list-group-flush">
          <li class="list-group-item">✔ Fast and intuitive interface</li>
          <li class="list-group-item">✔ Timed exams with progress tracking</li>
          <li class="list-group-item">✔ Secure login and exam access</li>
        </ul>
      </div>
      <div class="col-md-6">
        <ul class="list-group list-group-flush">
          <li class="list-group-item">✔ Detailed result reports</li>
          <li class="list-group-item">✔ Admin and student dashboards</li>
          <li class="list-group-item">✔ 24/7 support</li>
        </ul>
      </div>
    </div>
  </div>
</section>

<!-- Call to Action -->
<section class="text-center py-5" style="background-color: #007bff; color: white;">
  <div class="container">
    <h2>Ready to take your first exam?</h2>
    <p class="lead">Join thousands of students succeeding with our online platform.</p>
    <a href="Register.jsp" class="btn btn-light mt-3">Register Now</a>
  </div>
</section>
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
</body>
</html>