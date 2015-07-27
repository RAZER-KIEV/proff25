<%--
  Created by IntelliJ IDEA.
  User: GFalcon
  Date: 18.07.15
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Language" content="en-us"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Taxi DB</title>
    <style type="text/css">
        .style1 {
            text-align: center;
        }

        .style2 {
            font-size: smaller;
        }
    </style>
</head>

<frameset rows="80,*">
    <frame name="title" scrolling="no" noresize="noresize" target="menu" src="title.html">
    <frameset cols="226,*">
        <frame name="menu" target="main" src="menu.html">
        <frame name="main" src="main.html">
    </frameset>
    <noframes>
        <body>

        <table style="width: 90%" align="center">
            <tr>
                <th colspan="2" class="style1">
                    <h3>Система управления службой такси</h3>
                </th>
            </tr>
            <tr>
                <td colspan="2" class="style1">
                    Управление заказами
                </td>
            </tr>
            <tr>
                <td style="width: 50%">
                    <ul>
                        <li><>Сформировать заказ</li>
                        <li>Отредактировать заказ</li>
                    </ul>
                </td>
                <td style="width: 50%">
                    <ul>
                        <li>Вывести список заказов порциями по 5</li>
                        <li>Вывести список заказов на сумму в диапазоне</li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="style1">Управление клиентами</td>
            </tr>
            <tr>
                <td style="width: 50%">
                    <ul>
                        <li>Зарегистрировать клиента</li>
                    </ul>
                </td>
                <td style="width: 50%">
                    <ul>
                        <li>Вывести список клиентов</li>
                        <li>Список клиентов, наездивших на сумму более...</li>
                        <li>Вывести список клиентов за последний месяц</li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="style1">Управление водителями</td>
            </tr>
            <tr>
                <td style="width: 50%">
                    <ul>
                        <li><a href="createDriver.html">
                            Создать водителя
                        </a>
                        </li>
                        <li>Редактировать водителя</li>
                    </ul>
                </td>
                <td style="width: 50%">
                    <ul>
                        <li><a href="drivers.html">Вывести список водителей</a></li>
                    </ul>
                </td>
            </tr>

            <tr>
                <td colspan="2" class="style1">Администрированиe</td>
            </tr>
            <tr>
                <td style="width: 50%">
                    <ul>
                        <li>Редактировать оператора</li>
                    </ul>
                </td>

                <td style="width: 50%">
                    <ul>
                        <li><a href="operators.html">
                            Вывести список операторов</a></li>
                    </ul>
                </td>
            </tr>

            <tr>
                <td colspan="2">@developers:
                    <ul class="style2">
                        <li>Alexandr Omelchenko</li>
                        <li>Bogdan Iavorsky</li>
                        <li>Oleg 4ymak</li>
                        <li>Oleksii Khalikov</li>
                        <li>Nick Martin</li>
                    </ul>
                </td>
            </tr>
        </table>

        </body>
    </noframes>
</frameset>
</html>
