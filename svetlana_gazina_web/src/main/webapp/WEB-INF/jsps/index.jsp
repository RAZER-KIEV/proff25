<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 06.07.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Authentication</title>
</head>
<body background="image/taxi.jpg">

<%!
    int i = 1;
%>

<%
    i++;

    out.println("visited: "+i);
%>

<table style="color: gold" align="center">
  <tr>
    <td align="right"><label for="username">Login:</label></td>
    <td align="left"><input id="username" name="username" tabindex="1" type="text" style="border-radius: 5px" /></td>
  </tr>
  <tr>
    <td align="right"><label for="password">Password:</label></td>
    <td align="left"><input id="password" name="password" tabindex="2" type="password" style="border-radius: 5px"/></td>
  </tr>
  <tr>
    <td></td>
    <td align="left">
    </td>
  </tr>
  <tr>
    <td align="right">
        <form action="/dashboard" method="POST">
            <input type="hidden" name="login" value=<%= request.getParameter("login") %>>
            <input type="hidden" name="password" value=<%= request.getParameter("password") %>>
            <input type="submit" value="Go!" style="border-radius: 5px">
            <br>
            <a href="/registerClient" style="color: darkorange">Forgot your password?</a>
        </form>
    </td>
  </tr>
</table>

</body>
</html>
