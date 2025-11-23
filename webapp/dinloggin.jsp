<%@ page import="java.sql.*" %>
<%@ page import="utils.Baseconnect" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null) {
        Connection conn = Baseconnect.getconnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean validUser = false;

        try {
            // Check if user exists in the database
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {
                validUser = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (validUser) {
            session.setAttribute("user", username);
            response.sendRedirect("welcome.jsp");
        } else {
            out.println("<p style='color:red;'>Invalid username or password.</p>");
        }
    }
%>

<!DOCTYPE html>
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
  
  .containerr {
            max-width: 900px;
            margin: 50px auto;
            padding: 20px;
             border-radius: 5px;
            background-color: blur;
           box-shadow: 0 0 15px rgba(0, 0, 0, 3);
		   box-shadow:20px 20px 20px  rgba(0,0,0,3);
			border-radius:15px;
			background:rgba(255,255,255,0.1);
			backdrop-filter:blur(10px);
         
            
           
            border: 5px solid #ccc; padding: 10px; ;
        }
  
    input, button { margin: 5px; }
    .form-container { max-width: 400px; margin: auto; }
  </style>
  
    <title>Login</title>
</head>
<body>


  <div class="containerr">
  <div class="form-container">
    <h2>Login</h2>
    <form action="import.jsp" method="POST">
    
    
     <div class="form-floating mb-3">
        <input type="text" class="form-control" name="username"  required>
        <label for="username">Username : </label>
      </div>
    
    <div class="form-floating mb-3">
        <input type="password" class="form-control"  name="password"  required>
        <label for="password">Password : </label>
      </div>
            <button type="submit" class="btn btn-primary">Loggin</button><br><br><br>
    </form>
    </div></div>
    
    <jsp:include page="footer.jsp" />
</html>
