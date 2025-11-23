<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="module.Student" %>
<%@ page session="true" %>

<%
    Integer sid = (Integer) session.getAttribute("sid");
    if (sid == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"/>
    <title>Add Feedback / Report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <script>
        function validateForm() {
            var text = document.getElementById("type").value.trim();
            if (text == "") {
                alert("Feedback Type cannot be empty.");
                return false;
            }
            return true;
        }
    </script>
    
</head>
<body class="bg-light" background ="LOGO/background.jpg">

<div class="container mt-5">
    <h3 class="text-center mb-4">New Feedback / Report</h3>

    <form action="add" method="post" class="border border-primary rounded p-4 bg-white shadow-sm" onsubmit="return validateForm();">
        <div class="mb-3">
            <label class="form-label">Type</label>
            <select name="type" class="form-select" id="type" >
            
                <option value="">-- Select Type --</option>
                <option value="feedback">Feedback</option>
                <option value="report">Report</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Content</label>
            <textarea name="content" class="form-control" rows="5" id="text" required></textarea>
        </div>

        <div class="d-flex justify-content-start">
            <button type="submit" class="btn btn-success">Submit</button>
            <a href="profile.jsp" class="btn btn-secondary ms-2">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>