<%@ page import="cache.dao.Dao" %>
<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 06.07.15
--%>
<%!int a;%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<table border="1" width="90%">
    <thead>
    <tr>
        <td width = "15%"colspan="2">Odin</td>
        <td width = "15%"colspan="2">Loki</td>
        <td width = "15%"colspan="2">Thore</td>
    </tr>
    </thead>
    <tbody>
    <tr><td width = "15%" colspan="6"><p></p> </td>
    <tr>
        <td width = "15%">
            <form action="/medium.html" method="get"></form>
            <input type="submit" value="destroy"/>
        </td>
        <td width = "15%">
            <a href="ya.ru">ya.ru</a> <br/></td>
        <td width = "15%">
            <a href="mail.ru">mail.ru</a> <br/></td>
        <td width = "15%">
            <a href="vk.com">vk.com</a> <br/></td>
        <td width = "15%">
            <a href="youtube.com">youtube.com</a> <br/></td>
        <td width = "15%">
            <a href="ex.ua">ex.ua</a> <br/></td>
    </tr>
    <tr>
        <td height="400" width="15%" colspan="2">
            ${us1}
            <br/>
            ${us2}
                <br/>
            ${us3}
                <br/>
            ${us4}
                <br/>
            ${us5}
                <br/>
            ${us6}
                <br/>
            ${us7}
                <br/>
            ${us8}
                <br/>
            ${us9}
                <br/>
            ${us10}
                <br/>
            ${name}
                <br/>
    <tr>
        <td>
            <br/>
        </td>
    </tr>
    </td>
    </tr>
    </tbody>
</table>
</body>
</html>
