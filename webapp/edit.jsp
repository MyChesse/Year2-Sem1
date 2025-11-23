<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    // Fetch the timetable id passed from the servlet (via request)
    int id = Integer.parseInt(request.getParameter("id"));
    String subject = request.getParameter("subject");
    String day = request.getParameter("day");
    String startTime = request.getParameter("start_time");
    String endTime = request.getParameter("end_time");
%>
<html>
<head>
   <jsp:include page="header.jsp" />
   <link rel="stylesheet" href="CSS/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <h2>Edit Timetable Entry</h2>
    <!-- Form to update the timetable entry -->
    <form action="UpdateServlet" method="post">
      <!-- Hidden input to pass the id for updating -->
      <input type="hidden" name="id" value="<%= id %>" />
      
      <!-- Subject Input -->
      <div class="mb-3">
        <label>Subject</label>
        <input type="text" class="form-control" name="subject" value="<%= subject %>" required>
      </div>

      <!-- Day Input -->
      <div class="mb-3">
        <label>Day</label>
        <input type="text" class="form-control" name="day" value="<%= day %>" required>
      </div>

      <!-- Start Time Input -->
      <div class="mb-3">
        <label>Start Time</label>
        <input type="time" class="form-control" name="start_time" value="<%= startTime %>" required>
      </div>

      <!-- End Time Input -->
      <div class="mb-3">
        <label>End Time</label>
        <input type="time" class="form-control" name="end_time" value="<%= endTime %>" required>
      </div>

      <!-- Submit Button -->
      <button type="submit" class="btn btn-success">Update</button>
    </form>
  </div>
  
  <jsp:include page="footer.jsp" />
</body>
</html>
