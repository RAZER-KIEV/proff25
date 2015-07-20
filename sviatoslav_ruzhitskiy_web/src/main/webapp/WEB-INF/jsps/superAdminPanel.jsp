<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 20.07.2015
  Time: 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> You are SuperAdmin! Respect, Dude! </title>
</head>
<body>
<fieldset>
  <legend>SUPERADMIN PANEL</legend>
<form>
  <p><button formaction="/showOperators" formmethod="post">Show Operators</button> <button formaction="/goToCreateUpdateOperator" formmethod="post">Create Edit Operator</button>
    <button formaction="/createClientsInDB" formmethod="post">Generate random Clients In DB</button></p>
</form>
  </fieldset>
</body>
</html>
