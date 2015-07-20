<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1 align="center">AUTHENTICATION SUCCESS<br> ${hello}</h1>
<font color="BLUE">${info}</font>
<font color="RED">${error}</font>
<form action="/regCl" method="POST">
    <input type="submit" value="Register client"/>
</form>
<form action="/showByPort" method="GET">
    <input type="submit" value="Show clients by portion"/>
    <input type="number" name="size" value="10" placeholder="Portion size"/>
</form>
<form action="/showGtSum" method="GET">
    <input type="submit" value="Show clients gt sum"/>
    <input type="number" name="sum" value="50" placeholder="Sum"/>
</form>
<form action="/showClientsLastMonth" method="GET">
    <input type="submit" value="Show clients last month"/>
</form>
<form action="/createOrder" method="GET">
    <input type="submit" value="Create order"/>
</form>
<form action="/editOrder" method="GET">
    <input type="submit" value="Edit order"/>
</form>
<form action="/showOrdersBySum" method="GET">
    <input type="submit" value="Show orders by sum"/>
    <input type="number" name="from" placeholder="From"/>
    <input type="number" name="to" placeholder="To"/>
</form>
<form action="/showOrders" method="GET">
    <input type="submit" value="Show orders porced"/>
</form>
<form action="/editOrder1" method="GET">
    <input type="submit" value="Create/edit order(new)"/>
</form>
<% if (request.getAttribute("role").equals("SUPERADMIN") || request.getAttribute("role").equals("ADMIN")){
%>
<a href="/editOperator" name="/editOperator">Edit operator</a><br>
<a href="/unlockClear" name="/unlockClear">Unlock operator/clear attempts to enter password</a>
<%}%>
<form action="/logout" method="GET">
    <input type="submit" value="Log out"/>
</form>
</body>
</html>
