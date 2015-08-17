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
  <title>Create/Edit Order Page</title>
  <link href="/css/hw8CSS.css" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">
<%
  String  message = (String)request.getAttribute("message");
%>
<p>System Message:  <%= message %> </p>
<p> Message: <%= request.getAttribute("message") %></p>
<fieldset>
  <legend>Create/Edit Operator</legend>
<form action="/createEditOperator" method="post">
  <p>Operator Id: <input type="text" name="id"/></p>
  <p>login: <input type="text" name="login"/></p>
  <p>inn: <input type="text" name="inn"/></p>
  <p>password: <input type="text" name="password" ></p>
  <p>is Blocked:  <input type="text" name="isBlocked" ></p>
  <p>is SuperAdmin:  <input type="text" name="isSuperAdmin" ></p>
  <p>wrong Pass:  <input type="text" name="wrongPass" ></p>
  <input type="submit" name="submit" value="Create/Edit Operator"/>
  <button formaction="/backToDashboard"  type="submit" formmethod="post" name="BacktoDASHBOARD" value="Back to DASHBOARD!">Back to DASHBOARD!</button>
</form>
  </fieldset>
  </div>
</body>
</html>