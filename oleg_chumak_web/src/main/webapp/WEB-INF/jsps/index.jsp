<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%--<style>
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
    </style>--%>
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
        };

        var authRequest = new XMLHttpRequest();
        authRequest.onreadystatechange = function () {
            if (authRequest.readyState == 4
                    && authRequest.status == 200) {
                if (authRequest.responseText == '1') {
                    window.location = '/dashboard.html';
                } else {
                    document.getElementById('loginMessage').innerHTML = 'Login password dont mathch';
                }
            }
        };

        function sendAuthRequest(login, password) {
            authRequest.open('POST', 'auth2?login='+login + '&password=' + password,true);
            authRequest.send();
        };

        var loginPattern = /^\w{4,}$/;
        var passwordPattern = /^(?=[^ \\&]{8,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\d).*/;
        var individualTaxpayerNumberPattern = /^\d{10}$/;
        function validateLogin() {
            var messagePlace = document.getElementById('message');
            var login = document.getElementById('loginRegister').value;
            if (loginPattern.test(login)) {
                messagePlace.innerHTML = 'Login correct';
                send(login);
            } else {
                messagePlace.innerHTML = 'Login incorrect';
            }
        };
        function validatePassword() {
            var messagePlace = document.getElementById('passwordRegisterMessage');
            if (!passwordPattern.test(document.getElementById("password").value)) {
                messagePlace.innerHTML = 'Bad password. Not less than 8 symbols. Without spaces. At last one big letter and one number';
                return false;
            } else {
                return true;
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
            sendAuthRequest(document.getElementById('loginLogin').value, document.getElementById('passwordLogin').value);
        };

        function showRegisterPlace() {
            document.getElementById('loginPlace').style.display = 'none';
            document.getElementById('registerPlace').style.display = 'inline';
        };

        function hideRegisterPlace() {
            document.getElementById('registerPlace').style.display = 'none';
        };
    </script>
</head>
<body onload="hideRegisterPlace()">
    <main>
        <div id="loginPlace">
            <p id="loginMessage"></p>
            <p>Login</p>
            <input id="loginLogin" type="text">
            <br>
            <p>Password</p>
            <input id="passwordLogin" type="password">
            <br>
            <button onclick="auth()">Login</button>
            <br>
            <button onclick="showRegisterPlace()">or Register</button>
        </div>
        <div id="registerPlace">
            <p id="registerMessage"></p>
            <p>Login</p>
            <p id="loginRegisterMessage" style="color: red"></p>
            <input id="loginRegister" type="text" onchange="validateLogin()">
            <br>
            <p>Password</p>
            <p id="passwordRegisterMessage" style="color: red"></p>
            <input id="passwordRegister" type="password" onchange="validatePassword()">
            <br>
            <p>Password Confirmation</p>
            <p id="passwordConfirmationRegisterMessage" style="color: red"></p>
            <input id="passwordConfirmationRegister" type="password" onchange="confirmPasswords()">
            <br>
            <p>Individual Taxpayer Number</p>
            <p id="individualTaxpayerNumberRegisterMessage" style="color: red"></p>
            <input id="individualTaxpayerNumberRegister" type="text" onchange="validateIndividualTaxpayerNumber()">
            <br>
            <button onclick="testtt()">Register</button>
        </div>
    </main>
</body>
</html>
