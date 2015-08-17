<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 7/16/2015
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
  страница со списком функций (доступна после аутентификации)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head >
  <title>Yeah!</title>

</head>
<body background="image/taxi.jpg">
<h1 align="center" style="color: lavenderblush">Authentication Success!</h1>
<center>
  <form>
    <label style="color: gold">Show Clients By Portion</label><br>
    <input id="portion" type="text" name="portion" value="Portion..." style="border-radius: 10px" onclick="this.value=''"/>
    <input id="byPortion" formaction="/showClientsByPortion" formmethod="post" type="submit" value="Show" style="border-radius: 5px" align="right"/><br>
    <label style="color: gold">Show Clients With Sum Greater Than</label><br>
    <input id="sum" type="text" name="sum" value="Sum..." style="border-radius: 10px" onclick="this.value=''"/>
    <input id="gtSum" formaction="/showClientsGtSum" formmethod="post" type="submit" value="Show" style="border-radius: 5px" align="right"/><br>
    <label style="color: gold">Show Clients For The Last Month</label><br>
    <input id="lastMonth" formaction="/showClientsLastMonth" formmethod="post" type="submit" value="Show" style="border-radius: 5px" align="right"/><br>
  </form>
</center>

</body>
</html>
