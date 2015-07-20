<%--
  Created by IntelliJ IDEA.
  User: bosyi
  Date: 08.07.15
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <h3>TAXI 102</h3>
  <p style="color: red">${message}</p>
  <form action="backToDashboard" method="post">
    <input type="hidden" name="login" value="${login}">
    <input type="submit" value="Back to dashboard">
  </form>
  <p>
    ${clients}
  </p>
</body>
</html>
