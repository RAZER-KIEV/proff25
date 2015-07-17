<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17.07.2015
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>drivers</title>
</head>
<body>
${driversList}

<form action="/create.html" method="get">
  <table>
    <tr>
      <td>
        <input type="submit" value="Create New Driver">
      </td>
    </tr>
  </table>
</form>
</body>

</html>
