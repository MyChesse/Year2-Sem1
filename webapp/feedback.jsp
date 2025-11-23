<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bg-light">

	
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card shadow">
                <div class="card-header text-center bg-primary text-white">
                    <h4>User Confirmation</h4>
                </div>
                <div class="card-body">
                    <form action="log" method="post">
                        <div class="mb-3">
                            <label for="userid" class="form-label">User ID</label>
                            <input type="text" class="form-control" id="userid" name="uid" placeholder = "Enter your id" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="pass" required>
                        </div>
                        <input type="submit" name="submit" value="login" class="btn btn-primary w-100">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


	
</body>
</html>