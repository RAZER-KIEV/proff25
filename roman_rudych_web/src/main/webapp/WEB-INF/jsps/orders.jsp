<%@ page import="hw8.taxi.domain.Order" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 07.08.2015
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>${title}</div>
<p></p>
<%
  List<Order> list = (List<Order>)request.getAttribute("list");
    for(Order ls : list) {
      out.print(ls + "</br>");
    }

%>
</body>
</html>
