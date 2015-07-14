<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 11.07.2015
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi Authentication</title>
</head>
<body>
<%! int count=0; %>
Logining retry: <%=count%>
<form id="myAuthForm" action="/auth" method="post">
  <p> Введите логин: <input type="text" name="login"> <br></p>
  <p> Введите проль:<input type="password" name="password"></p>
  <input type="submit" name="enter" value="Log in">
</form> <br>

<form id="regForm" action="/register" method="post">
  <input type="submit" name="register" value="Registeration">
</form>
</body>
</html>
