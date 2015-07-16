<%--
  Created by IntelliJ IDEA.
  User: just1ce
  Date: 16.07.2015
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="css/registerClient.css">
</head>
<body>
<form name="registration" action="/client_register" method="post">
  <table id="register_table">
    <tbody>
    <tr><td>
      <table cellpadding="0" cellspacing="20" width="400">
        <tbody>
        <tr>
          <td></td>
          <td class="reg_title" colspan="2">Регистрация Клиента</td>
        </tr>
        <tr>
          <td class="reg_title" colspan="2"><font color="RED">${info}</font> </td>
        </tr>
        <tr>
          <td class="reg_cell_titles">Введите Имя</td>
          <td class="reg_cell" width="100%">
            <input name="name" style="width: 100%;" type="text"   />
          </td>
        </tr>
        <tr>
          <td class="reg_cell_titles">Введите Фамилию</td>
          <td class="reg_cell">
            <input name="surname" style="width: 100%;"  type="text" />
          </td>
        </tr>
        <tr>
          <td class="reg_cell_titles">Введите аддрес</td>
          <td class="reg_cell">
            <input name="address" style="width: 100%;"  type="text" />
          </td>
        </tr>
        <tr>
          <td class="reg_cell_titles">Введите телефон</td>
          <td class="reg_cell">
            <input name="phone" style="width: 100%;"  type="text" />
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
