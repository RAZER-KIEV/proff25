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

<p> Message: <%= request.getAttribute("message") %></p>
<form action="/createEditOrder" method="post">
  <p>Order id: <input type="text" name="orderId"/></p>
  <p>Client id: <input type="text" name="clientId"/></p>
  <p>Amount: <input type="text" name="amount"/></p>
  <p>Address From: <input type="text" name="addressFrom" ></p>
  <p>Address To:  <input type="text" name="addressTo" ></p>
  <input type="submit" name="submit" value="Create/Edit Order"/>
  <button formaction="/backToDashboard"  type="submit" formmethod="post" name="BacktoDASHBOARD" value="Back to DASHBOARD!">Back to DASHBOARD!</button>
</form>
</body>
</html>