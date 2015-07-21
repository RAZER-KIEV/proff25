<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 12.07.15
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Driver"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="operator.jsp"></jsp:include>
<br>
<%Driver driverss = (Driver) request.getAttribute("driverList");
if(driver != null){
  %>
<table>

  <tr>
    <td>ID</td>
    <td>name</td>
    <td>phone</td>
    <td>car model</td>
    <td>car number</td>
  </tr>
  <%
    for(Driver driver1 : driverss){
  %>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
<%}%>
</table>
<%--&lt;%&ndash;&lt;%&ndash;%>--%>
}

%>



</body>
</html>
