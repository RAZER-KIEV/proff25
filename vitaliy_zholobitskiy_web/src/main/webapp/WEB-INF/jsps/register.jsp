<%--
  Created by IntelliJ IDEA.
  User: just1ce
  Date: 15.07.2015
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="css/register.css">
</head>
<body>
<form name="registration" action="/confirm_register" method="post">
  <table id="register_table">
    <tbody>
    <tr><td>
      <table cellpadding="0" cellspacing="20" width="400">
        <tbody>
        <tr>
          <td></td>
          <td class="reg_title" colspan="2">Регистрация</td>
        </tr>
        <tr>
          <td class="reg_title" colspan="2"><font color="RED">${info}</font> </td>
        </tr>
        <tr>
          <td class="reg_cell_titles">Введите логин</td>
          <td class="reg_cell" width="100%">
            <input name="login" style="width: 100%;" type="text"   />
          </td>
        </tr>
        <tr>
          <td class="reg_cell_titles">Введите пароль</td>
          <td class="reg_cell">
            <input name="password" style="width: 100%;"  type="password" />
          </td>
        </tr>
        <tr>
          <td class="reg_cell_titles">Подтвердите пароль</td>
          <td class="reg_cell">
            <input name="confirm_password" style="width: 100%;"  type="password" />
          </td>
        </tr>
        <tr>
          <td>
          </td>
          <td class="reg_submit" align="left">
            <input value="Регистрация" name="submit" id="reg_submit_button" type="submit" />
          </td>
        </tr>
        </tbody></table>
    </td></tr>
    </tbody>
  </table>
</form>
</body>
</html>
