<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
    <style>
        *{
            color: #FFF;
            font-size: 24px;
            font-family: "Century Gothic","Lucida Grande",Helvetica,Arial,sans serif;
        }

        body {
            background: #212028;
        }

        input {
            color: #000;
            text-align: left;
        }

        #login_table {
            border-radius: 10px ;
            border: rgba(235, 131, 70, 0.99) 1px solid;
            background: #8589b8 top left repeat-x;
            display: block;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-left: -200px;
            margin-top: -150px;

        }

        .auth_cell_titles {
            border-radius: 10px ;
            color: #481540;
            font-size: 11pt;
        }

        .auth_title {
            color: #481540;
            border-radius: 10px ;
            padding-bottom: 20px;
        }

        .auth_submit a {
            border-style: ridge ;
            font-size: 9pt;
            margin-left: 30px;
        }

        #auth_submit_button {
            border-radius: 10px ;
            font-size: 24px;
        }
    </style>
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
                    <td></td>
                    <td class="auth_submit" align="left">
                        <input value="Войти" name="submit" id="auth_submit_button" type="submit" />
                    </td>
                </tr>
                </tbody></table>
        </td></tr>
        </tbody>
    </table>
</form>
</body>
</html>
