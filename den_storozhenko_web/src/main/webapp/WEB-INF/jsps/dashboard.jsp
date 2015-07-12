<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1 align="center">AUTHENTICATION SUCCESS<br> Hello, ${login}!</h1>
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
</body>
</html>
