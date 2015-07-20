<%@ page import="comandWork.domain.Taxi" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 14.07.2015
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
      <h1 align="center">Taxi full list</h1>
      <div>
          <%
              List<Taxi> list = (List<Taxi>)request.getAttribute("list");
              for (Taxi taxi : list) {
                  out.println(taxi);
              }
          %>
      </div>
<body>

</body>
</html>
}

