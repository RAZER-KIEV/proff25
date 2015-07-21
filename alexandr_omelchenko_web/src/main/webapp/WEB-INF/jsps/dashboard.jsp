<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12.07.2015
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashbord</title>
</head>
<body>

<tr>
  <td>${name}, welcome to Taxi Service</td>
</tr>
<form action = "/ShowOperators.html" methods="POST">
  <input type = "submit" value = "ShowOperators"/>
</form>
</body>
</html>