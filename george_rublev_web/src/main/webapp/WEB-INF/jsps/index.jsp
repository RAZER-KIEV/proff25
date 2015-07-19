<%--<%@ page import="sun.util.calendar.LocalGregorianCalendar" %>--%>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 06.07.15
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>George Rublev</title>
</head>
<%@ page import="java.util.Date" %>
<body>

<table width="100%">

  <tr>
    <td colspan="2"></td>
    <td colspan="2"></td>
    <td colspan="2"></td>
  </tr>
  <tr>
    <td colspan="6">

      ${nameLog}
      <br>
      ${name}

    </td>
  </tr>
  <tr>
    <td><a href="http://www.yandex.ru">yandex</a> </td>
    <td><a href="http://www.google.com.au">google au</a> </td>
    <td>3</td>
    <td>4</td>
    <td>5</td>
    <td></td>
  </tr>
  <tr>
    <td colspan="2">
      <ul>
        <li><a href="http://www.yandex.ru">yandex</a></li>
        <li><a href="http://www.google.com.au">google au</a></li>
        <li>3</li>
        <li>4</li>
        <li>5</li>
        <li>6</li>
      </ul>
    </td>
    <td colspan="4">

      <table>
        <tr>
          <td><img src="../../CyrusAudioDACXPPlus_6baf9262c3ee8859736b909bee5b4b6f.jpg"> </td>
          <td>Интегральный транзисторный усилитель мощностью 40 Вт, удобный для работы с различными устройствами благодаря расширенному спектру  цифровых входов. К нему вы можете подключить до 5 различных цифровых источников сигнала, в том числе компьютер, теленфизор и спутниковый ресивер. Cyrus 6 DAC  спроектирован в соответствии со всеми принципами Cyrus, вы можете быть уверены в действительно высококачественном звучании.

            Cyrus 6 DAC одинаково хорошо интегрируется как в стерео системы Hi-Fi класса, так и в системы домашнего кинотеатра на основе DVD или Blue ray проигрывателей. Цифровые входы и встроенный ЦАП резко улучшают качество звучания.
          </td>
        </tr>
      </table>

    </td>
  </tr>
  <tr>
    <td colspan="6" align="centre"><p align="centre">RGS</p><br>

      <% out.println(new Date());
      %>

    </br>
    <br>
      <%!
        int i=-3;
      %>
    <%
      i++;
      out.println(i);

    %>
    </td>
  </tr>

</table>
<br>
<form action="/dashboard.html" method="get">

  <input type="text" name="login" value="Sidor"/>
  <input type="submit" value="send"/>

</form>

</body>
</html>
