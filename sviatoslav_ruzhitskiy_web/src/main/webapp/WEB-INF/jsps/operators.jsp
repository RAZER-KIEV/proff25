<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hw8.taxi.domain.Operator" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 19.07.2015
  Time: 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>список Операторов</title>
  <link href="/css/hw8CSS.css" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">
<form>
  <button formaction="/backToDashboard"  type="submit" formmethod="post" name="BacktoDASHBOARD" value="Back to DASHBOARD!">Back to DASHBOARD!</button>
</form>
<table>
  <caption><H1>Operators</H1></caption>
  <thead>
  <tr>
    <th align="left">Operator Id</th>
    <th align="left">login</th>
    <th align="left">inn</th>
    <th align="left">password</th>
    <th align="left">passDate</th>
    <th align="left">is Blocked</th>
    <th align="left">is SuperAdmin</th>
    <th align="left">wrong Pass</th>
  </tr>
  </thead>
  <c:forEach var="operator" items="${list}" >
    <tr>
      <td>${operator.id}</td>
      <td>${operator.login}</td>
      <td>${operator.inn}</td>
      <td>${operator.password}</td>
      <td>${operator.passDate}</td>
      <td>${operator.isBlocked}</td>
      <td>${operator.isSuperAdmin}</td>
      <td>${operator.wrongPass}</td>
    </tr>
  </c:forEach>
</table>
  </div>
</body>
</html>