<%@ page import="hw8.taxi.domain.Operator" %>
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
<div class="wrapper">
<%! String login;
    String sysMessage;
    Operator operator;
%>


<%
   if(login==null){
        login = (String)session.getAttribute("operlogin");
   }
   sysMessage= (String) session.getAttribute("sysMessage");
    operator = (Operator) session.getAttribute("operator");
%>
<h1>YOU WELCOME ON DASHBOARD!</h1>
<h3>Your Login:  "<%= login %>",  System Message:  "<%= sysMessage %>"</h3>


   <% if(operator.getIsSuperAdmin()){ %>
<jsp:include page="superAdminPanel.jsp" />
   <% } %>

<fieldset>
    <legend>Operator panel</legend>
<form action="/showClientsGtSum" method="post">
    <p><button formaction="/goToRegisterClient" formmethod="post">Register new Client</button></p>
    <p></p>
    <p><button formaction="/showClientsByPortion" formmethod="post">Show Clients</button></p>
    <p><input type="submit" name="submit" value="Show Clients Gt Sum"> <input name="sum" type="text"/> Set minimal sum</p>
    <p><button formaction="/showClientsLastMonth" formmethod="post">Show Clients Last Month</button></p>
    <p><button formaction="/goToCreateOrder" formmethod="post">Create/Edit Order</button></p>
    <p><input formaction="/showOrders" type="submit" name="submit" value="Show Orders"> <input name="from" type="text"/> <input name="to" type="text"/> Set Diapason(From-To)</p>
    <p><button formaction="/showOrdersByPortion" formmethod="post">Show Orders By Portion </button> Works slowly, because there are lot of requests to DataBase</p>


</form>
    </fieldset>
    </div>
</body>
</html>
