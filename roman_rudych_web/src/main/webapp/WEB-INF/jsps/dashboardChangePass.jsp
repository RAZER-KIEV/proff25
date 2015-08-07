<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<h1 align="center">Change password for ${name}</h1>

<table border="0" cellspacing="100" width="100%"  >
  <th align="center" >
    <form action="/dashboardChangePass.html" method="post">
      <p><strong>Set new password: </strong>
        <input type="password" name="password"/> </p>
      <p><strong>Confirm password: </strong>
        <input type="password" name="passwordConfirmed"/> </p>
      <p><font color="red"> ${warning}</font> </p>
      <input type="submit" value="Change password"/>

    </form>
  </th>

</table>

</body>
</html>
