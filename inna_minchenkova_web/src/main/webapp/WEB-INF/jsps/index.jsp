<%--
  Created by IntelliJ IDEA.
  User: Inna
  Date: 06.07.2015
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Hello Inna</h2>


${name}

<form action = "/great.html" method="GET">
  <input type="text" name="login"> <br/>
  <input type="password">
  <select name="sex">
    <option value="man"> Мужчина </option>
    <option value="woman"> Женщина </option>
  </select>
  <input type="submit" value="send"/>

</form>

<p style="background-color: blue">Parag<p/>
<a href="ya.ru">Ссылка</a> <br/>
<img src=""/>
<q/>Citata<q/>
<ul>
  <li>item1</li>
  <li>item2</li>
</ul>
<ol>
  <li>Элемент1</li>
  <li>Элемент2</li>
</ol>

<table border="1">
  <thead>
  <tr>
    <th>1</th>
    <th>2</th>
    <th>3</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>1</td>
    <td>2</td>
    <td>3</td>
  </tr>
  <tr>
    <td>3</td>
    <td>2</td>
    <td>1</td>
  </tr>
  </tbody>
  <tfoot></tfoot>
</table>
<%! private int accessCount = 0; %>
Количество посещений страницы:
<%= ++accessCount %>
</body>
</html>
