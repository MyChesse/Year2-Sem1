<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Update Question</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #ecf4fe;
    }
    .form-container {
      background-color: white;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      margin-top: 40px;
      border: 1px solid blue;
    }
    .form-title {
      font-size: 30px;
      font-weight: bold;
      text-align: center;
      margin-bottom: 20px;
      color: #495057;
    }
    label, .form-label {
      font-family: sans-serif;
      font-weight: bold;
      color: black;
    }
    .form-control {
      border-radius: 5px;
      border: 1px solid #ced4da;
    }
    .form-control:focus {
      border-color: #007bff;
      box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
    }
    .btn-primary {
      border-radius: 5px;
      background-color: #007bff;
      border: none;
      padding: 10px 0px;
      font-size: 16px;
      display: block;
      margin: 0 auto;
      width: 150px;
    }
    .btn-primary:hover {
      background-color: #0056b3;
    }
    .form-group {
      margin-bottom: 20px;
    }
    .sidebar .btn {
      white-space: nowrap;
      width: 100%;
    }
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
    .custom-header {
      background-color: #0000FF;
      color: white;
    }
  </style>
</head>
<body>
	

	<%
		String id = request.getParameter("id");
		String questionid = request.getParameter("questionid");
		String question1 = request.getParameter("question1");
		String question2 = request.getParameter("question2");
		String question3 = request.getParameter("question3");
		String question4 = request.getParameter("question4");
		String question5 = request.getParameter("question5");
	%>
	
  <div class="container">
    
    <form action="updateExam" method="post" class="form-container">
    	<h2 class="form-title">Update Question</h2>
    	<br>
    	<div class="form-group row">
          <label for="id" class="col-form-label col-sm-2">ID</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="id" name="id" value="<%= id %>" readonly>
          </div>
        </div>
        <div class="form-group row">
          <label for="questionid" class="col-form-label col-sm-2">Question ID</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="questionid" name="questionid" value="<%= questionid %>" readonly>
          </div>
        </div>
        <div class="form-group row">
          <label for="question1" class="col-form-label col-sm-2">Question 1</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="question1" name="question1" value="<%= question1 %>">
          </div>
        </div>
        <div class="form-group row">
          <label for="question2" class="col-form-label col-sm-2">Question 2</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="question2" name="question2" value="<%= question2 %>">
          </div>
        </div>
        <div class="form-group row">
          <label for="question3" class="col-form-label col-sm-2">Question 3</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="question3" name="question3" value="<%= question3 %>">
          </div>
        </div>
        <div class="form-group row">
          <label for="question4" class="col-form-label col-sm-2">Question 4</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="question4" name="question4" value="<%= question4 %>">
          </div>
        </div>
        <div class="form-group row">
          <label for="question5" class="col-form-label col-sm-2">Question 5</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="question5" name="question5" value="<%= question5 %>">
          </div>
        </div>
        <div class="form-group text-center">
          <button type="submit" class="btn btn-primary"> 💾 Update Exam</button>
        </div>
      </form>

  </div>
</body>
</html>

