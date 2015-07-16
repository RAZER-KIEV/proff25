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
        response.sendRedirect("/WEB-INF/jsps/index.jsp");
  }
  sysMessage= (String) session.getAttribute("sysMessage");


%>
<p>Your Login:  <%= login %> </p>
<p>System Message:  <%= sysMessage %> </p>
<h1>YOU WELCOME ON DASHBOARD!</h1>
<form>
    <p><button formaction="/goToRegisterClient" formmethod="post">Register new Client</button></p>
    <p><button formaction="/createClientsInDB" formmethod="post">Generate random Clients In DB</button></p>
    <p><button formaction="/showClientsByPortion" formmethod="post">Show Clients By Portion</button></p>
    <p><button formaction="/showClientsGtSum" formmethod="post">Show Clients Gt Sum</button></p>
    <p><button formaction="/showClientsLastMonth" formmethod="post">Show Clients Last Month</button></p>



</form>
</body>
</html>
