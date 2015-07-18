
<%@ page import="java.util.List" %>
<%@ page import="taxi.domain.*" %>
<%--
  лист таксистов
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>operators</title>
</head>
<body>
<%List<Operator> operators = (List<Operator>)request.getAttribute("operatorsList");
    if (operators!=null){%>
<table border="1" title="Operators" width="100%">
    <caption><H1>Operators</H1></caption>
    <thead>
    <tr>
        <th align="left">Login</th>
        <th align="left">Password</th>
        <th align="left">Individual Tax Number</th>
        <th align="left">Last Password ChangeDate</th>
        <th align="left">Is It Blocked</th>
        <th align="left">Unsuccessful Login Tries</th>
    </tr>
    </thead>
    <%
        for(Operator op: operators){
    %>
    <tr>
        <td><% out.println(op.getLogin());%></td>
        <td><% out.println(op.getPassword());%></td>
        <td><% out.println(op.getIndividualTaxpayerNumber());%></td>
        <td><% out.println(op.getLastPasswordChangeDate());%></td>
        <td><% out.println(op.getIsBlocked());%></td>
        <td><% out.println(op.getUnsuccessfulLoginTries());%></td>
    </tr>

    <%}%>
</table>
<%} %>

</body>

</html>
