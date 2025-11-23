<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Question</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #ecf4fe;
            padding: 20px;
        }
        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
            border: 1px solid #dee2e6;
        }
        .form-title {
            font-size: 24px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
            color: #495057;
        }
        .form-label {
            font-weight: bold;
            color: #495057;
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
            padding: 10px 20px;
            font-size: 16px;
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 150px;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .form-group {
            margin-bottom: 20px;
            
        }
    </style>
</head>
<body>

<!-- Display alert messages -->
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

<div class="container">
    <div class="form-container">
        <h2 class="form-title">ADD QUESTION</h2>

        <form action="addExam" method="post">
            <div class="form-group row">
                <label for="questionid" class="col-form-label col-sm-2">Question ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="questionid" name="questionid" placeholder="Enter your question id">
                </div>
            </div>
            <div class="form-group row">
                <label for="question1" class="col-form-label col-sm-2">Question 1</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="question1" name="question1" placeholder="Enter question 1">
                </div>
            </div>
            <div class="form-group row">
                <label for="question2" class="col-form-label col-sm-2">Question 2</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="question2" name="question2" placeholder="Enter question 2">
                </div>
            </div>
            <div class="form-group row">
                <label for="question3" class="col-form-label col-sm-2">Question 3</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="question3" name="question3" placeholder="Enter question 3">
                </div>
            </div>
            <div class="form-group row">
                <label for="question4" class="col-form-label col-sm-2">Question 4</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="question4" name="question4" placeholder="Enter question 4">
                </div>
            </div>
            <div class="form-group row">
                <label for="question5" class="col-form-label col-sm-2">Question 5</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="question5" name="question5" placeholder="Enter question 5">
                </div>
            </div>
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
