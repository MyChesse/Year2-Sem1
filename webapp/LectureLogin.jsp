<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login | Penguin.lk</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="CSS/bootstrap.min.css" rel="stylesheet">
    <link href="CSS/styles.css" rel="stylesheet">
    
    <style>
        body {
            background-color: #eaf6fd;
            font-family: Arial, sans-serif;
        }

        .navbar {
            background-color: #ffffff;
            border-bottom: 2px solid #007bff;
        }

        .navbar-brand img {
            height: 40px;
            margin-right: 10px;
        }

        .login-container {
            height: 100vh;
        }

        .card {
            border-radius: 15px;
        }

        footer {
            background-color: rgb(90, 90, 90);
            color: white;
            font-size: small;
            text-align: center;
            padding: 10px;
        }

        footer img {
            width: 150px;
            margin-bottom: 20px;
        }

        .footer-links {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            margin-bottom: 20px;
        }

        .footer-links div {
            margin: 0 15px;
        }
    </style>
</head>
<body>

<!-- Navigation -->
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

<!-- Login Form Centered -->
<div class="container login-container d-flex justify-content-center align-items-center">
    <div class="card p-5 shadow-sm" style="min-width: 350px;margin-top: -5px;">
        <h3 class="text-center mb-4 text-primary">Login to Penguin.lk</h3>
        <form action="lectureLogin" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>

            <div class="mb-3">
                <label for="role" class="form-label">Login As:</label>
                <select class="form-select" id="role" name="role" required>
                    <option value="lecture">Lecture</option>
                    <option value="admin">Admin</option>
                </select>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form>

        <% String error = (String) request.getAttribute("errorMessage");
           if (error != null) { %>
            <div class="alert alert-danger mt-3 text-center"><%= error %></div>
        <% } %>
    </div>
</div>

<!-- Footer -->
<footer>
    <img src="LOGO/logo.png" alt="Logo">
    <div class="footer-links">
        <div>Information Technology</div>
        <div>Engineering</div>
        <div>Management</div>
        <div>Medicine</div>
        <div>Languages</div>
    </div>
    <p>&copy; 2025 Online Examination Website. All rights reserved.<br>penguin.lk</p>
</footer>

<!-- Footer Color Strip -->
<div style="background-color: DodgerBlue; height :5px;"></div>

<!-- Bootstrap JS (for navbar toggling) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
