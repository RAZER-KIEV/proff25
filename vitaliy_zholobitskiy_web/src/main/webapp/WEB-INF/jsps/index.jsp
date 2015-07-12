<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
    <style>
        .rightpic {
            float: left; /* Выравнивание по левому краю */
            margin:  5px 5px 0 0; /* Отступы вокруг фотографии */
        }
    </style>
</head>
<body >
<table border="3" width="100%">
    <tr>
        <th colspan="2" width="33%">Заголовок №1</th>
        <th colspan="2" width="33%">Заголовок №2</th>
        <th colspan="2" width="33%">Заголовок №3</th>
    </tr>
    <tr>
        <th colspan="6">
            hello ${name}
            <%!
                int counter=0;
                public Date getDate(){
                    return new Date();
                }
            %>
            Вы зашли к нам
            <%
                counter+=1;
                out.println(counter);
            %>
            раз
            <br>
            <%out.println(getDate()); %>
        </th>
    </tr>
    <tr width="100%">
        <th width="16%">Меню №1</th>
        <th width="16%">Меню №2</th>
        <th width="16%">Меню №3</th>
        <th width="16%">Меню №4</th>
        <th width="16%">Меню №5</th>
        <th width="16%">Меню №6</th>
    </tr>
    <tr width="100%">
        <th colspan="2" width="16%"><ul>
            <li>Меню №1</li>
            <li>Меню №2</li>
            <li>Меню №3</li>
            <li>Меню №4</li>
            <li>Меню №5</li>
            <li>Меню №6</li>
        </ul></th>
        <th colspan="4" width="16%">
            <p><img src="http://mnemonikon.ru/images/270.jpg" class="rightpic"/>
                <a href="https://ru.wikipedia.org/wiki/HTML">HTML</a> (от англ. HyperText Markup Language — «язык гипертекстовой разметки») — стандартный язык разметки документов во Всемирной паутине. Большинство веб-страниц содержат описание разметки на языке HTML (или XHTML). Язык HTML интерпретируется браузерами; полученный в результате интерпретации форматированный текст отображается на экране монитора компьютера или мобильного устройства.

            Язык HTML является приложением SGML (стандартного обобщённого языка разметки) и соответствует международному стандарту ISO 8879.

            Язык XHTML является более строгим вариантом HTML, он следует всем ограничениям XML и, фактически, XHTML можно воспринимать как приложение языка XML к области разметки гипертекста.

            Во всемирной паутине HTML-страницы, как правило, передаются браузерам от сервера по протоколам HTTP или HTTPS, в виде простого текста или с использованием шифрования.
        </p>
        </th>
    </tr>
    <tr>
        <th colspan="6">
            ©just1ce 2015 Kyiv
        </th>
    </tr>
</table>
</body>
</html>
