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
<form action="/createOrder" method="POST">
    <input type="submit" value="Create order"/>
</form>
<form action="/editOrder" method="POST">
    <input type="submit" value="Edit order"/>
</form>
<form action="/showOrdersBySum" method="POST">
    <input type="submit" value="Show orders by sum"/>
    <input type="number" name="from" placeholder="From"/>
    <input type="number" name="to" placeholder="To"/>
</form>
<form action="/showOrders" method="POST">
    <input type="submit" value="Show orders porced"/>
</form>
<form action="/createOrder1" method="POST">
    <input type="submit" value="Create order(new)"/>
</form>
<form action="/editOrder1" method="POST">
    <input type="submit" value="Edit order(new)"/>
</form>
</body>
</html>
