<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 11.07.2015
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DASHBOARD</title>
    <link href="/css/hw8CSS.css" rel="stylesheet"/>

</head>
<body>
<%! String login;
    String sysMessage;
%>


<%
   if(login==null){
        login = (String)session.getAttribute("operlogin");
        response.sendRedirect("/auth");
  }
  sysMessage= (String) session.getAttribute("sysMessage");


%>
<p>Your Login:  <%= login %> </p>
<p>System Message:  <%= sysMessage %> </p>
<h1>YOU WELCOME ON DASHBOARD!</h1>
<form action="/showClientsGtSum" method="post">
    <p><button formaction="/goToRegisterClient" formmethod="post">Register new Client</button></p>
    <p><button formaction="/createClientsInDB" formmethod="post">Generate random Clients In DB</button></p>
    <p><button formaction="/showClientsByPortion" formmethod="post">Show Clients By Portion</button></p>
    <p><input type="submit" name="submit" value="Show Clients Gt Sum"> <input name="sum" type="text"/> Set minimal sum</p>
    <p><button formaction="/showClientsLastMonth" formmethod="post">Show Clients Last Month</button></p>
    <p><button formaction="/goToCreateOrder" formmethod="post">Create/Edit Order</button></p>
    <p><input formaction="/showOrders" type="submit" name="submit" value="show Orders"> <input name="from" type="text"/> <input name="to" type="text"/> Set Diapason(From , ToS)</p>
    <p><button formaction="/showOrdersByPortion" formmethod="post">Show Orders By Portion </button></p>


</form>
</body>
</html>
