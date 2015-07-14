<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 06.07.15
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Site by Ivan_K</title>
    <link href="style.css" rel="stylesheet">
    <style>
        .leftimg {
            float:left; /* Выравнивание по левому краю */
            margin: 7px 7px 7px 0; /* Отступы вокруг картинки */
        }
        TABLE {
            border-collapse:  collapse;
            width: 100%;
        }
        TD {
            border: 1px solid black;
        }
        DIV {
           padding: 5px;
        }
    </style>
</head>
<div id="header">
    <table style="border: 1px ActiveBorder; width: 100%; height: 100%">
        <td><h2 align="center">PARTITITION 1</h2></td>
        <td><h2 align="center">PARTITITION 2</h2></td>
        <td><h2 align="center">PARTITITION 3</h2></td>
    </table>
</div>
<div id="commercial">
    <table>
        <td>
            <p align="center">google content</p>
        </td>
        <td>
            <%
                out.println(new Date());
            %>
        </td>
        <td>
            <%!
                int i=0;

            %>
        </td>
    </table>
</div>
<div id="menu">
    <table style="border: 1px ; width: 100%; height: 100%">
        <nav>
            <td bgcolor="#C9D8C9" align="center" valign="center" ><a href="">Main</a></td>
            <td bgcolor="#C9D8C9" align="center" valign="center" ><a href="">News</a></td>
            <td bgcolor="#C9D8C9" align="center" valign="center" ><a href="">Weather</a></td>
            <td bgcolor="#C9D8C9" align="center" valign="center" ><a href="">Blog</a></td>
            <td bgcolor="#C9D8C9" align="center" valign="center" ><a href="">Multimedia</a></td>
            <td bgcolor="#C9D8C9" align="center" valign="center" ><a href="">Contacts</a></td>
        </nav>
    </table>
</div>
<div id="content">
  <table style="border: 1px solid lightsteelblue; width: 100%; height: 100%">
      <td style="width: 20%" align="left" valign="center">
          <ul>
              <li>list 1</li>
              <li>list 2</li>
              <li>list 3</li>
              <li>list 4</li>
              <li>list 5</li>
              <li>list 6</li>
              <li>list 7</li>
          </ul>
      </td>
      <td>
          <p align="justify"> <img src="Bender.png" class="leftimg">Бендер (полное имя Бендер Сгибальщик Родригес (мекс. Bender Bending Rodríguez), также Гибочный модуль № 22 (Bending Unit #22) —
              промышленный робот, предназначенный для сгибания металлических балок для будок самоубийств,
              персонаж мультсериала Futurama. Лучший друг главного героя сериала Филиппа Фрая. Левша. Мизантроп.
              Кулинар. Отличается скверным характером, массой вредных привычек — курит сигары и бухает
              (алкоголь нужен ему для восстановления энергии, см. серию про глобальное потепление), а также
              маниакальной страстью ко лжи и воровству. Регулярно втравливает коллег во всевозможные неприятности.
              В общем Бендер — полная противоположность роботам, построенным по принципу Трех законов роботехники.
              Неудивительно, что он стал самым популярным персонажем всего сериала. </p>
      </td>
  </table>
</div>
<div id="footer">
    <p align="left">@copyrigt: site by Ivan_K</p>
</div>

</body>
</html>
