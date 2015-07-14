<%--
 Created by IntelliJ IDEA.
 User: oTTo
 Date: 13.01.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel = "stylesheet" href = "css/style.css">
<html>
<head>
  <title>Задание на каскадные таблицы</title>
</head>
<body>
<%--<h3>Покрасьте меня в розовый цвет (color:pink).</h3>--%>
<p>Данный элемент должен остаться неоформленным.</p>

<p id='greycol'>Покрасьте меня в серый цвет (color:grey).</p>

<div>Данный элемент должен остаться неоформленным.</div>
<div>
  <p>Покрасьте меня в красный цвет (color:red).</p>
  <span><p>Покрасьте меня в коричневый цвет (color:brown).</p></span>

  <div style="">Покрасьте меня в серебряный цвет (color:silver)</div>
</div>
<h4>Данный элемент должен остаться неоформленным.</h4>

<p>Покрасьте меня в зеленый цвет (color:green).</p>

<p class='yellowcol'>Покрасьте меня в желтый цвет (color:yellow).</p>

<div class='yellowcol'>Покрасьте меня в синий цвет (color:blue).</div>
<div style="border: dashed">Покрасьте меня в оливковый цвет (color:olive)</div>
</body>
</html>