<%--
  страница со списком функций (доступна после аутентификации)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<frameset rows="64,*">
    <frame name="titlePage" scrolling="no" noresize="noresize" target="menuPage" src="title.html">
    <frameset cols="226,*">
        <frame name="menuPage" target="mainPage" src="menu.html">
        <frame name="mainPage" src="main.html">
    </frameset>
    <noframes>
        <body><p>ups</p></body>
    </noframes>
</frameset>

</html>
