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
<table>
    <tr>
        <td align="right"><label for="username">Пользователь:</label></td>
        <td align="left"><input id="username" name="username" tabindex="1" type="text" /></td>
    </tr>
    <tr>
        <td align="right"><label for="password">Пароль:</label></td>
        <td align="left"><input id="password" name="password" tabindex="2" type="password" /></td>
    </tr>
    <tr>
        <td></td>
        <td align="left">
        </td>
    </tr>
    <tr>
        <td align="left">
            <a href="/account/lost_password">Восстановление пароля</a>
        </td>
        <td align="right">
            <input type="submit" name="login" value="Вход &#187;" tabindex="5"/>
        </td>
    </tr>
</table>





<table border="1" width="100%">
      <tr>
        <td width="33%">Раздел 1</td>
        <td width="33%">Раздел 2</td>
        <td width="33%">Раздел 3</td>
     </tr>
        <a href="google.com.ua">Some google promotion</a>
    <tr>
        <th width="16.66%">Что-то</th>
        <th width="16.66%">Раздел 2</th>
        <th width="16.66%">как- то</th>
        <th width="16.66%">Раздел 4</th>
        <th width="16.66%">НОвость</th>
        <th width="16.66%">Раздел 6</th>
    </tr> <br>
    <tr>
        <ul>
            <li>item 1</li>
            <li>item 2</li>
            <li>item 3</li>
        </ul>
    </tr>
</table>






<%!
int i = 1;
%>

<%
    i++;

    out.println("посещений: "+i);
%>


<h2>Форма для получения имени</h2>
<form action="/great.html" method=GET>
    Имя <br><input type=text name="login"
                   value="Введите Ваше имя"><br>

    <input type=submit value="Отправить">

</form>
<h3> приветсвую ${name} ! </h3>


</body>
</html>