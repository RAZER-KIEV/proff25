<%--
  Created by IntelliJ IDEA.
  User: GFalcon
  Date: 19.07.15
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Language" content="en-us"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <base target="main"/>
    <style type="text/css">
        .style1 {
            text-align: center;
        }
    </style>
</head>

<body>
<p>Меню</p>

<form method="post" class="style1">
    <fieldset name="grpOrderControls">
        <legend><span lang="ru">Работа с заказами</span></legend>
        <input name="btnCreateOrder"
               type="button"
               value="Оформить"
               onclick="top.frames['main'].location.href=''"
               style="width: 90%"/>
        <br/>
        <input name="btnEditOrder"
               type="button"
               value="Редактировать"
               onclick="top.frames['main'].location.href=''"
               style="width: 90%"/>
        <br/>
        <input name="btnGetOrderReports"
               type="button"
               value="Отчеты"
               onclick="top.frames['main'].location.href=''"
               style="width: 90%"/>
        <br/>
    </fieldset>

    <fieldset name="grpClientsControl">
        <legend><span lang="ru">Клиенты</span></legend>
        <input name="btnCreateClient"
               type="button"
               value="Зарегистрировать"
               onclick="top.frames['main'].location.href='startRegisterClient.html'"
               style="width: 90%"/>
        <br/>
        <input name="btnGetClientReport"
               type="button"
               value="Отчеты"
               onclick="top.frames['main'].location.href='clientReport.html'"
               style="width: 90%"/>
        <br/>
    </fieldset>

    <fieldset name="grpDriverControl">
        <legend><span lang="ru">Водители</span></legend>
        <input name="btnCreateDriver"
               type="button"
               value="Зарегистрировать"
               onclick="top.frames['main'].location.href='createDriver.html'"
               style="width: 90%"/>
        <br/>
        <input name="btnGetDriverReport"
               type="button"
               value="Отчеты"
               onclick="top.frames['main'].location.href='drivers.html'"
               style="width: 90%"/>
        <br/>
    </fieldset>
</form>

<form method="post" class="style1">
    <fieldset name="grpAdmin">
        <legend>Admin panel</legend>
        <input  name="btnUpdateOperator"
                type="button"
                value="Изменить оператора"
                onclick="top.frames['main'].location.href=''"
                style="width: 90%"/>
        <br/>
        <input name="btnGetOperatorsList"
               type="button"
               value="Список операторов"
               onclick="top.frames['main'].location.href='operators.html'"
               style="width: 90%"/>
        <br/>
    </fieldset>
</form>

</body>
</html>
