<%--
  Created by IntelliJ IDEA.
  User: GFalcon
  Date: 19.07.15
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form>
  <input type="button"
         value="Вывести весь список клиентов"
         onclick="location.href='clientslistAll.html'"
         width="90%">
<br/>
  <input type="button"
         value="Вывести всех клиентов, делавших заказы за последний месяц"
         onclick="location.href='ClientsMadeOrdersDuringLastMonth.html'"
         width="90%">
</form>
<form action="/clientsPortinedByTen.html", method="get">
    <input type="text" name="portion">
    <input type="submit" value="Вывести всех клиентов указанной порцией">
</form>
<form action="/ClientsWithOrderAmountMoreThen.html", method="get">
  <input type="text" name="value">
  <input type="submit" value="Вывести всех клиентов наездивших на сумму больше указанной">
</form>
</body>
</html>
