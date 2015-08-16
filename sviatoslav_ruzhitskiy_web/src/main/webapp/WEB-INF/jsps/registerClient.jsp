<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 15.07.2015
  Time: 19:00
  To change this template use File | Settings | File Templates.
  зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Форма создания клиента</title>
  <link href="/css/hw8CSS.css" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">
<h1>CLIENT REGISTERATION PAGE</h1>
<p>STATUS: <%= request.getAttribute("status") %></p>
<fieldset>
  <legend>Create new Client</legend>
<form action="/createClient" method="post">
  <p>Name: <input type="text" name="name"/> </p>
  <p>Sur name: <input type="text" name="surname"/>  </p>
  <p>Phone: <input type="text" name="phone"/></p>
  <p>Adress: <input type="text" name="adress" > </p>
    <input type="submit" name="createClient" value="Create Client!"/>
  <button formaction="/backToDashboard"  type="submit" formmethod="post" name="BacktoDASHBOARD" value="Back to DASHBOARD!">Back to DASHBOARD!</button>
</form>
</fieldset>
  </div>
</body>
</html>
