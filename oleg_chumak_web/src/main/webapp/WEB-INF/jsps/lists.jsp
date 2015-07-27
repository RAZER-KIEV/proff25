<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 27.07.15
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>
<head>
  <title>Отчеты</title>
</head>
<body onload=init()>
<button onclick = "clients()"> Список всех клентов </button>
<button onclick = "drivers()"> Список всех водителей </button>
<button onclick = "orders()"> Список всех заказов </button>
<button onclick = "clientsMonth()"> Список клиентов, делавших заказы в прошлом месяце </button>
<button onclick = "ordersPortioned()"> Список заказов, порциями по 5</button>
<button onclick = "clientsPortioned()"> Список клиентов, порциями по 10</button>
<button onclick = "ordersAmount()"> Список заказов, суммой свыше </button>
<input type="text" id="orMin"> <p> до </p>
<input type="text" id="orMax"> <p> центов </p>
<button onclick = "clientsAmount()"> Список клиентов, сделавших заказы в обьеме более </button>
<input type="text" id="clAm"> <p> центов </p>
<h2 id="message"></h2>
<div id="tableField"></div>
</body>
</html>
