<%@ page import="java.sql.*, utils.Baseconnect" %>
<html>
<head>
  <jsp:include page="header.jsp" />
  <link rel="stylesheet" href="CSS/bootstrap.min.css">
  <style>
     body {
            background-color:#D6EFFF;
            color: #003366;
            font-family: Arial, sans-serif;
        }
   h1 {
 			font-family: 'Roboto', sans-serif;
  			font-size: 36px;
  			font-weight: 600;
  			color: #003366;
}
  
  
    table { border-collapse: collapse; width: 100%; margin-top: 20px; }
    th, td { border: 1px solid #0056b3; padding: 10px; text-align: left; }
    th { background-color: #f2f2f2; }
    input, button { margin: 5px; padding: 8px; }
    table {box-shadow:20px 20px 20px  rgba(0,0,0,0.5);
			border-radius:15px;
			background:rgba(255,255,255,0.1);
			backdrop-filter:blur(10px);
            }
  </style>
  <title>Timetable</title>
</head>
<body>
  <h1>Timetable</h1>
  <table>
    <tr><th>ID</th><th>Subject</th><th>Day</th><th>Start</th><th>End</th><th>Actions</th></tr>
<%
try (Connection conn = Baseconnect.getconnection()) {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM timetable");
    while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("subject") %></td>
        <td><%= rs.getString("day") %></td>
        <td><%= rs.getTime("start_time") %></td>
        <td><%= rs.getTime("end_time") %></td>
        <td>
            <form action="edit.jsp" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                <button type="submit" class="btn btn-warning btn-sm">Re_Edit</button>
            </form>
            <form action="DeleteServlet" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this entry?');">Delete</button>
            </form>
        </td>
    </tr>
<%
    }
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>
  </table>
  <br>
  <a href="import.jsp" class="btn btn-primary">Add New Timetable Entry</a><br><br>
  <jsp:include page="footer.jsp" />s
</body>
</html>
