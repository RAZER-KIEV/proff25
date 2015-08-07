<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 13.07.2015
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User registration</title>
</head>
<body>
      <table border="0" cellspacing="100" width="100%"  >
        <th align="center" >
          <form action="/registerAction.html" method="post">
            <p><strong>Login: </strong>
              <input type="text" name="login"/> <br/></p>
            <p><strong>ID: </strong>
              <input type="text" name="id"/> </p>
            <p><strong>Password: </strong>
              <input type="password" name="password"/> </p>
            <p><strong>Confirm password: </strong>
              <input type="password" name="passwordConfirm"/> </p>
            <p><font color="red"> ${warningReg}</font> </p>
            <input type="submit" value="Register"/>

          </form>
        </th>
      </table>

</body>
</html>
