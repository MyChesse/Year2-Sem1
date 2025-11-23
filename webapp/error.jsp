<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"/>
    <meta charset="UTF-8">
    <title>Error Page</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .error-box {
            border: 2px solid #0d6efd; /* Bootstrap blue */
            background-color: #e9f5ff;
            color: #0d6efd;
            padding: 30px;
            border-radius: 10px;
            margin-top: 60px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }

        .custom-button {
            background-color: #1f5f8b;
            border: none;
            color: white;
            padding: 10px 24px;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
        }

        .custom-button:hover {
            background-color: #155d74;
        }
    </style>
</head>
<body class="bg-light" background ="LOGO/background.jpg">

<div class="container d-flex justify-content-center">
    <div class="error-box col-md-8 col-lg-6">
        <h3 class="mb-3">⚠️ Error</h3>

        <c:if test="${not empty error}">
            <p class="mb-4 fw-semibold">${error}</p>
        </c:if>

        <a href="addFeedback.jsp">
            <button class="custom-button">Back to Feedback</button>
        </a>
    </div>
</div>

</body>
</html>
