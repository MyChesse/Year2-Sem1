<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Table</title>

    <!-- Inline CSS styling -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fa;
            margin: 0;
            padding: 30px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
        }

        th {
            background-color: #007bff;
            color: white;
            padding: 12px;
            text-align: center;
        }

        td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ccc;
        }

        form {
            display: inline;
        }

        input[type="submit"], button {
            padding: 6px 12px;
            font-size: 14px;
            color: white;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button {
            background-color: #dc3545;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        button:hover {
            background-color: #c82333;
        }

        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>

<h2>Customer Profile Table</h2>

<table>
  <thead>
    <tr>
      <th>Email</th>
      <th>Name</th>
      <th>Password</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="cus" items="${customer}">
     <tr>
        <td>${cus.email}</td>
        <td>${cus.name}</td>
        <td>${cus.password}</td>

        <td>
          <form action="update.jsp" method="post">
            <input type="hidden" name="email" value="${cus.email}">
            <input type="hidden" name="name" value="${cus.name}">
            <input type="hidden" name="password" value="${cus.password}">
            <input type="submit" value="Update Profile">
          </form>
        </td>

        <td>
          <form action="deleteCustomer" method="post">
            <input type="hidden" name="email" value="${cus.email}">
            <button type="submit">Delete</button>
          </form>
        </td>
     </tr>
   </c:forEach>
  </tbody>
</table>
 <a href = "KSadmin.jsp">
 <button type ="submit">Submit</button>
 </a>
</body>
</html>
