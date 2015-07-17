<%--
  лист таксистов
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
