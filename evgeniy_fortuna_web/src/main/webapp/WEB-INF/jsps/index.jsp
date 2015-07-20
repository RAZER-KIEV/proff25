    <%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 06.07.15
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>
    <head>
        <title></title>
        <link rel="stylesheet" href="css/style.css">
        </link>
        <p>
        <div>
            eeee
        </div>
        </p>

        <ol class="brown">

        </ol>

    </head>
    <body>
    <p> Parag </p>

    <table border="1" width="100%">
        <thead>
        <tr>
            <th width="17%" colspan="2">1</th>
            <th width="17%" colspan="2">2</th>
            <th width="17%" colspan="2">3</th>
        </tr>

        <tr>
            <th width="17%" colspan="6">
                <a href="ya.ru">Google Advert</a>
            </th>
        </tr>

        <tr>
            <th width="17%">
                <a href="y.ru">Menu 1</a>
            </th>
            <th width="17%">
                <a href="y.ru">Menu 2</a>
            </th>
            <th width="17%">
                <a href="y.ru">Menu 3</a>
            </th>
            <th width="17%">
                <a href="y.ru">Menu 4</a>
            </th>
            <th width="17%">
                <a href="y.ru">Menu 5</a>
            </th>
            <th width="17%">
                <a href="y.ru">Menu 6</a>
            </th>
        </tr>

        <tr>
            <th width="17%" colspan="2">
                <ul class="brown">
                    <li>${name}</li>
                    <li>item 2</li>
                    <li>item 3</li>
                    <li>item 1</li>
                    <li>item 2</li>
                    <li>item 3</li>
                    <li>item 1</li>
                    <li>item 2</li>
                    <li>item 3</li>
                    <li>item 1</li>
                    <li>item 2</li>
                    <li>item 3</li>
                    <li>item 1</li>
                    <li>item 2</li>
                    <li>item 3</li>
                </ul>
            </th>
            <th width="17%" colspan="4">
                <table border="1">
                    <tr>
                        <th>
                            <%!
                                int i = -1;
                            %>
                            <%
                                out.println(i++);
                            %>
                        </th>
                    </tr>
                </table>
            </th>
        </tr>

        </thead>

    </table>

    <form action="/great.html" method="GET">
        <input type = "text" name="login"> <br/>
        <input type="submit" value="send"/>

    </form>



    </body>
    </html>
