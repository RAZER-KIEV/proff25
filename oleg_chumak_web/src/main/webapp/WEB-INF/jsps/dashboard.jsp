<%--
  страница со списком функций (доступна после аутентификации)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<frameset rows="64,*">
    <frame name="titlePage" scrolling="no" noresize="noresize" target="menuPage" src="title.jsp">
    <frameset cols="226,*">
        <frame name="menuPage" target="mainPage" src="menu.jsp">
        <frame name="mainPage" src="mainView.jsp">
    </frameset>
    <noframes>
        <body><p>ups</p></body>
    </noframes>
</frameset>

</html>
