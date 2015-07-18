<%--
  Created by IntelliJ IDEA.
  User: GFalcon
  Date: 18.07.15
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Language" content="en-us" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Меню</title>
<base target="основная" />
<style type="text/css">
  .style1 {
    text-align: center;
  }
</style>
</head>

<body>

<p><span lang="ru">Меню</span></p>
<form method="post">
  <div class="style1">
      <fieldset name="grpOrderControls">
        <legend><span lang="ru">Работа с заказами</span></legend>
        <input name="btnCreateOrder" type="button" value="Оформить" style="width: 90%" /><br />
        <input name="btnEditOrder" type="button" value="Редактировать" style="width: 90%" /><br />
        <input name="btnGetOrderReports" type="button" value="Отчеты" style="width: 90%" />
      </fieldset>
      <fieldset name="grpClientsControl">
        <legend><span lang="ru">Клиенты</span></legend>
          <input name="btnCreateClient" type="button" value="Зарегистрировать" style="width: 90%" /><br />
          <input name="btnGetClientReport" type="button" value="Отчеты" style="width: 90%" />
      </fieldset>
      <fieldset name="grpDriverControl">
        <legend><span lang="ru">Водители</span></legend>
        <input name="btnCreateDriver" type="button" value="Зарегистрировать" style="width: 90%" /><br />
        <input name="btnGetDriverReport" type="button" value="Отчеты" style="width: 90%" />
      </fieldset>
  </div>
</form>

<form>
  <div class="style1">
    <fieldset name="grpAdmin">
      <legend><span lang="ru">Администрирование</span></legend>
      <input name="btnGetOperatorList" type="button" value="Список операторов" style="width: 90%" /><br />
      <input name="btnEditOperator" type="button" value="Изменение оператора" style="width: 90%" />
    </fieldset>
  </div>
</form>
</body>

</html>
