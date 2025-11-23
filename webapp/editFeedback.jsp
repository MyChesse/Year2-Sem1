<%@ page import="module.Feedback" %>
<%@ page session="true" %>

<%
    Feedback feedback = (Feedback) request.getAttribute("feedback");

    if (feedback == null) {
        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect("profile.jsp");
            return;
        }

        int feedbackId = Integer.parseInt(idParam);
        services.FeedbackService service = new services.FeedbackService();
        feedback = service.getFeedbackById(feedbackId);

        if (feedback == null) {
            response.sendRedirect("profile.jsp");
            return;
        }

        request.setAttribute("feedback", feedback); // store for reuse
    }
%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"/>
    <title>Edit Feedback</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light" background ="LOGO/background.jpg">

<div class="container mt-5">
    <h3 class="text-center mb-4">Edit Feedback / Report</h3>

    <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
    <% } %>

    <form action="edit" method="post" class="border border-primary rounded p-4 bg-white shadow-sm">
        <input type="hidden" name="id" value="<%= feedback.getId() %>">

        <div class="mb-3">
            <label class="form-label">Type</label>
            <select name="type" class="form-select" required>
                <option value="feedback" <%= "feedback".equals(feedback.getType()) ? "selected" : "" %>>Feedback</option>
                <option value="report" <%= "report".equals(feedback.getType()) ? "selected" : "" %>>Report</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Content</label>
            <textarea name="content" class="form-control" rows="5" required><%= feedback.getContent() %></textarea>
        </div>

        <div class="d-flex justify-content-start">
            <button type="submit" class="btn btn-success">Update</button>
            <a href="profile.jsp" class="btn btn-secondary ms-2">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>
