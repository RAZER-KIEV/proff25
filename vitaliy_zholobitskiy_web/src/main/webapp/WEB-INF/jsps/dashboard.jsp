
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<!--
<table id="register_table" border="2px">
  <tbody>
  <tr>
    <td>
    <form  action="/client_reg_page" method="get">
      <input class="reg_title" value="Регистрация клиента" name="submit_reg" id="register_button" type="submit" />
    </form>
    </td>
  </tr>
  <tr>
    <td>
    <form  action="/showClientsByPortion" method="get">
      <input class="reg_title" value="10" name="portion" id="portion" type="text" />
      <input class="reg_title" value="Вывести всех клиентов порциями" name="submit_reg" id="showClientsByPortion_button" type="submit" />
    </form>
    </td>
  </tr>
  <tr>
    <td>
    <form  action="/showClientsGtSum" method="get">
      <input class="reg_title" value="0" name="sum" id="sum" type="text" />
      <input class="reg_title" value="Вывести всех клиентов наездивших на сумму больше указанной" name="submit_reg" id="showClientsGtSum_button" type="submit" />
    </form>
    </td>
  </tr>
  <tr>
    <td>
    <form  action="/showClientsLastMonth" method="get">
      <input class="reg_title" value="Вывести всех клиентов, делавших заказы за последний месяц" name="submit_reg" id="showClientsLastMonth_button" type="submit" />
    </form>
    </td>
  </tr>
  <tr>
    <td>
      <form  action="/order" method="get">
        <input class="reg_title" value="Создать/Редактировать заказ" name="order" id="create_order" type="submit" />
      </form>
    </td>
  </tr>
  <tr>
    <td>
      <form  action="/showOrders" method="post">
        <input class="reg_title" value="Показать заказы на суму в диазоне" id="showOrders" type="submit" />
        <input class="reg_title" value="0" name="from" id="from" type="text" />
        <input class="reg_title" value="0" name="to" id="to" type="text" />
      </form>
    </td>
  </tr>
  <tr>
    <td>
      <form  action="/showOrdersByPortion" method="get">
        <input class="reg_title" value="Показать заказы порциями по 5"  id="showOrdersByPortion" type="submit" />
      </form>
    </td>
  </tr>
  <tr>
    <td>
      <form  action="/logout" method="get">
        <input class="reg_title" value="10" name="portion" id="portion" type="text" />
        <input class="reg_title" value="Вывести всех клиентов порциями" name="submit_reg" id="showClientsByPortion_button" type="submit" />
      </form>
    </td>
  </tr>

  </tbody>
</table>
-->
<table class="simple-little-table" cellspacing='0'>
  <tr>
    <td>
      <form  action="/client_reg_page" method="get">
        <input class="reg_title" value="Регистрация клиента" name="submit_reg" id="register_button" type="submit" />
      </form>
    </td>
  </tr><!-- Table Header -->

  <tr>
    <td>
       <form  action="/showClientsByPortion" method="get">
         <input class="reg_title" value="Вывести всех клиентов порциями" name="submit_reg" id="showClientsByPortion_button" type="submit" />
         <input class="reg_title" value="10" name="portion" id="portion" type="text" />
        </form>
    </td>
  </tr><!-- Table Row -->

  <tr>
    <td>
      <form  action="/showClientsGtSum" method="get">
        <input class="reg_title" value="Вывести всех клиентов наездивших на сумму больше указанной" name="submit_reg" id="showClientsGtSum_button" type="submit" />
        <input class="reg_title" value="0" name="sum" id="sum" type="text" />
      </form>
    </td>
  </tr><!-- Darker Table Row -->

  <tr>
    <td>
      <form  action="/showClientsLastMonth" method="get">
        <input class="reg_title" value="Вывести всех клиентов, делавших заказы за последний месяц" name="submit_reg" id="showClientsLastMonth_button" type="submit" />
      </form>
    </td>
  </tr>

  <tr>
    <td>
      <form action="/order" method="get">
        <input class="reg_title" value="Создать заказ" name="order" id="create_order" type="submit" />
      </form>
    </td>
  </tr>
  <tr>
    <td>
      <form  action="/editOrderPage" method="get">
        <input class="reg_title" value="Редактировать заказ" name="order" id="eidt_order" type="submit" />
      </form>
    </td>
  </tr>

  <tr>
    <td>
      <form  action="/showOrders" method="post">
        <input class="reg_title" value="Показать заказы на суму в диазоне" id="showOrders" type="submit" />
        <input class="reg_title" value="0" name="from" id="from" type="text" />
        <input class="reg_title" value="0" name="to" id="to" type="text" />
      </form>
    </td>
  </tr>

  <tr>
    <td>
      <form  action="/showOrdersByPortion" method="get">
        <input class="reg_title" value="Показать заказы порциями по 5"  id="showOrdersByPortion" type="submit" />
      </form>
    </td>
  </tr>

  <tr>
    <td>
      <form  action="/logout" method="get">
        <input class="reg_title" value="Выйти" name="logout" id="logout" type="submit" />
      </form>
    </td>
  </tr>
</table>
</body>
</html>
