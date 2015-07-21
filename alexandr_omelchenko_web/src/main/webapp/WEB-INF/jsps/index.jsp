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
    <title>authentification</title>
</head>
<body>
<form action = "/welcome.html" methods="POST">
  <input type = "text" name = "login"
         value ="Alex"/>
  <input type = "text" name = "password"
         value ="a44n73"/>
  <input type = "submit" value = "ok"/>
</form>
<tr>
  <td>${name}</td>
</tr>
</body>
</html>