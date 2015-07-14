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
</head>
<body>
<%
  String login = (String)session.getAttribute("name");
  if(login==null){
 response.sendRedirect("/WEB-INF/jsps/index.jsp");
  }

%>
<p>Your Login:  <%= login %> </p>
<h1>YOU WELCOME ON DASHBOARD!</h1>
</body>
</html>
