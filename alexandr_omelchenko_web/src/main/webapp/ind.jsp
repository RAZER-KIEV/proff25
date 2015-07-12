<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 06.07.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%!
    int count=0;
%>
<%
    count++;
    out.println(count);
%>
<h2>Hello Alexandr</h2>

<p>Parag</p>
<a href="http://ya.ru">Ссылка</a> <br/>
<!--<img src="duke.running.gif"/>-->
<q>Cicitata</q>

<ul>
    <li>item 1</li>
    <li>item 2</li>
    <li>item 3</li>
</ul>

<ol>
    <li>Элемент 1</li>
    <li>Элемент 1</li>
    <li>Элемент 1</li>
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
</body>
</html>