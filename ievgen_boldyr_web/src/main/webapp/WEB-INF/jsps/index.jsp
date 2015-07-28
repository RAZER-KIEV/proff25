<%--<%@ page import="sun.util.calendar.LocalGregorianCalendar" %>--%>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 06.07.15
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>George Rublev</title>
  <script src="js/script.js">

  </script>
</head>
<%@ page import="java.util.Date" %>
<body>
<c:out value="${name}"/>
<table>
  <tr>
    <td><input type="text" id="t1"></td>
  </tr>
  <tr>
    <td><input type="text" id="t2"></td>

  </tr>
  <tr>
    <td><p id="tUnsver"></p></td>
  </tr>
  <tr>
    <td><button type="button" onclick="send()">PUSH</button> </td>
  </tr>
</table>


<form action="/dashboard.html" method="get" >
  <input type="text" name="login" value="Login" align="centre"/>
  <input type="password" name="paswwd" value="password"/>
  <input type="submit" value="send"/>
</form>
</body>
</html>
