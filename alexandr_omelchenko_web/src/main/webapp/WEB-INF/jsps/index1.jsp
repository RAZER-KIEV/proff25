<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 07.07.2015
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index1</title>
</head>
<body>
<form action = "/great.html" methods="GET">
  <input type = "text" name = "login"
         value ="Alexandr"/>
  <input type = "submit" value = "ok"/>
</form>
<tr>
  <td>${name}</td>
</tr>
<tr>
  <td>${hello}</td>
</tr>
</body>
</html>
