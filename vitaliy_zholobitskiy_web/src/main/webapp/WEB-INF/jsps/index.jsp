<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="css/index.css">
</head>

<body >

<form name="authorization" action="/auth.html" method="post">
    <table id="login_table">
        <tbody>
        <tr><td>
            <table cellpadding="0" cellspacing="20" width="400">
                <tbody>
                <tr>
                    <td></td>
                    <td class="auth_title" colspan="2">Привет!</td>
                </tr>
                <tr>
                    <td class="auth_title" colspan="2"><font color="RED">${info}</font> </td>
                </tr>
                <tr>
                    <td class="auth_cell_titles">Логин</td>
                    <td class="auth_cell" width="100%">
                        <input name="login" style="width: 100%;" class="auth" type="text"   />
                    </td>
                </tr>
                <tr>
                    <td class="auth_cell_titles">Пароль</td>
                    <td class="auth_cell">
                        <input name="password" style="width: 100%;" class="auth" type="password" />
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td class="auth_submit" align="left">
                        <input value="Войти" name="submit" id="auth_submit_button" type="submit" />
                    </td>
                </tr>
                </tbody></table>
        </td></tr>
        </tbody>
    </table>
</form>
<form  action="/register" method="get">
    <input class="auth_title" value="Регистрация" name="submit_reg" id="register_button1" type="submit" />
</form>
</body>
</html>
