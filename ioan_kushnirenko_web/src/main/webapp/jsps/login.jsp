<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12.07.15
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Exercises</title>
  <link rel="stylesheet" href="css/style.css"></link>
  <style >
    body{
      background-image: url(street_taxi.jpg);
      background-position: left, right;
    }
    table{
      vertical-align: middle;
    }
  </style>
</head>
<body>
<p>${Error}</p>
<form action = "dashboard.jsp" method="GET">
  <%!

  %>

  <%
  %>


    <table>
      <tr height="250px"></tr>
      <tr>
        <td  width="35%"></td>
        <td  width="35%"></td>
        <td  width="30%">
          <form action = "dashboard.jsp" method="GET" style="width: 300px; background: #f0f0f0; padding: 10px">
            <fieldset align="right">
              <legend align="center"><b>Registration:</b></legend>
              Your login: <input type="text" name = "login" value = ""/><br/>
              Password: <input type="password" name="passw" value=""><br/>
              <input type="submit" value="Send"/>
            </fieldset>
          </form>
      </tr>
      </table>
</body>
</html>
