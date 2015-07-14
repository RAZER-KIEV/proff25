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
</head>
<body>
<p>${Error}</p>
<form action = "/client.html" method="GET">
  <%!

  %>

  <%
  %>


  <fieldset>
    <legend>Registration:</legend>
    Your login: <input type="text" name = "login" value = ""/><br/>
    Password: <input type="password" name="passw" value=""><br/>
    <input type="submit" value="Send"/>
  </fieldset>
</form>
</body>
</html>
