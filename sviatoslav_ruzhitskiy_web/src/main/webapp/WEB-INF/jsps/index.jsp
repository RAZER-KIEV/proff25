<%--
  Created by IntelliJ IDEA.
  User: jax
  Date: 14.07.15
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <style>
    body{ background: url(/image/taxi.jpg)}
  </style>
</head>
<body>

<center>
  <h2 style="color:white">Authorization!!!!</h2>

  <form name ="forma1" action="/dashboard.jsp">



    <table border="0" cellspacing="5" cellpadding="5">

      <tr>
        <td align="right" valign="top" style="color:white">Enter login</td>
        <td><input type="text" name="login" size="25"
                   maxlength="15" value="Login"><br></td>
      </tr>
      <tr>
        <td align="right" valign="top" style="color:white">Enter password</td>
        <td><input type="password" name="pass" size="25"
                   maxlength="15" value="password"><br></td>
      </tr>

      <tr>
        <td><input type="submit" name="submit" value="РђРІС‚РѕСЂРёР·Р°С†РёСЏ">
        </td>
      </tr>

    </table>









  </form>

</center>
</body>