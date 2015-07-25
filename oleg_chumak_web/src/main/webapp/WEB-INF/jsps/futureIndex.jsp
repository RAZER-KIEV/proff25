<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        body {
            background: #f06d06;
            font-size: 80%;
            padding: 20px;
        }

        main {
            position: relative;
            background: white;
            height: 200px;
            width: 60%;
            margin: 0 auto;
            padding: 20px;
            resize: both;
            overflow: auto;
        }

        main div {
            background: black;
            color: white;
            width: 50%;
            transform: translate(-50%, -50%);
            position: absolute;
            top: 50%;
            left: 50%;
            padding: 20px;
            resize: both;
            overflow: auto;
        }
    </style>
    <script>
        var loginUniqueCheckRequest = new XMLHttpRequest();
        loginUniqueCheckRequest.onreadystatechange = function () {
            if (loginUniqueCheckRequest.readyState == 4
                    && loginUniqueCheckRequest.status == 200) {
                if (loginUniqueCheckRequest.responseText == '1') {
                    document.getElementById('message').innerHTML = 'Login correct and unique';
                } else {
                    document.getElementById('message').innerHTML = 'Login correct and not unique';
                }
            }
        }
        var loginPattern = /^\w{4,}$/;
        var passwordPattern = /^(?=[^ \\&]{8,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\d).*/;
        var individualTaxpayerNumberPattern = /^\d{10}$/;
        function validateLogin() {
            var messagePlace = document.getElementById('message');
            var login = document.getElementById('login').value;
            if (loginPattern.test(login)) {
                messagePlace.innerHTML = 'Login correct';
                send(login);
            } else {
                messagePlace.innerHTML = 'Login incorrect';
            }
        };
        function validatePassword() {
            var messagePlace = document.getElementById('message');
            if (passwordPattern.test(document.getElementById("password").value)) {
                messagePlace.innerHTML = 'Login correct';
            } else {
                messagePlace.innerHTML = 'Login incorrect';
            }
        };
        function confirmPasswords() {
            var password = document.getElementById('password').value;
            var passwordConfirmation = document.getElementById('passwordConfirmation').value;
            if (password == passwordConfirmation) {
            } else {
            }
        };

        function validateIndividualTaxpayerNumber() {
            individualTaxpayerNumberPattern.test(document.getElementById('individualTaxpayerNumber').value)
        }

        function send(login) {
            loginUniqueCheckRequest.open('POST', 'checkLogin?login='+login,true);
            loginUniqueCheckRequest.send();
        };

        function auth() {

        };
    </script>
</head>
    <main>
        <div id="loginPlace">
            <p id="loginMessage"></p>
            <input id="loginLogin" type="text" onchange="validateLogin()">
            <input id="passwordLogin" type="password">
            <button onclick="test()">Register</button>
        </div>
        <div id="registerPlace">
            <p id="message"></p>
            <input id="loginRegister" type="text" onchange="validateLogin()">
            <input id="passwordRegister" type="password" onchange="validatePassword()">
            <input id="passwordConfirmationRegister" type="password" onchange="confirmPasswords()">
            <input id="individualTaxpayerNumberRegister" type="text" onchange="validateIndividualTaxpayerNumber()">
            <button onclick="test()">Register</button>
        </div>
    </main>
</body>
</html>
