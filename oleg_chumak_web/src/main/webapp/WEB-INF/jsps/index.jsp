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
                    document.getElementById('loginRegisterMessage').innerHTML = '';
                } else {
                    document.getElementById('loginRegisterMessage').innerHTML = 'Login not unique';
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


        var registerRequest = new XMLHttpRequest();
        registerRequest.onreadystatechange = function () {
            if (registerRequest.readyState == 4
                    && registerRequest.status == 200) {
                if (registerRequest.responseText == '1') {
                    showLoginPlace();
                    document.getElementById('loginMessage').innerHTML = 'You can log in now';
                } else {
                    document.getElementById('registerMessage').innerHTML = 'Something go wrong';
                }
            }
        };

        function sendRegisterRequest(login, password, itn) {
            registerRequest.open('POST', 'register2?login='+login + '&password=' + password + '&itn=' + itn,true);
            registerRequest.send();
        };


        var loginPattern = /^\w{4,}$/;
        var passwordPattern = /^(?=[^ \\&]{8,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\d).*/;
        var individualTaxpayerNumberPattern = /^\d{10}$/;

        function validateLoginTypo() {
            if (loginPattern.test(document.getElementById('loginRegister').value)) {
                send(document.getElementById('loginRegister').value);
                return true;
            } else {
                document.getElementById('loginRegisterMessage').innerHTML = 'Need be more that 4 symbols';
                return false;
            }
        };

        function validatePassword() {
            if (passwordPattern.test(document.getElementById('passwordRegister').value)) {
                document.getElementById('passwordRegisterMessage').innerHTML = '';
                return true;
            } else {
                document.getElementById('passwordRegisterMessage').innerHTML = 'Bad password. Not less than 8 symbols. Without spaces. At last one big letter and one number';
                return false;
            }
        };

        function confirmPasswords() {
            var password = document.getElementById('passwordRegister').value;
            var passwordConfirmation = document.getElementById('passwordConfirmationRegister').value;
            if (password == passwordConfirmation) {
                document.getElementById('passwordConfirmationRegisterMessage').innerHTML = '';
                return true;
            } else {
                document.getElementById('passwordConfirmationRegisterMessage').innerHTML = 'Passwords do not match';
                return false;
            }
        };

        function validateIndividualTaxpayerNumber() {
            if (individualTaxpayerNumberPattern.test(document.getElementById('individualTaxpayerNumberRegister').value)) {
                document.getElementById('individualTaxpayerNumberRegisterMessage').innerHTML = '';
                return true;
            } else {
                document.getElementById('individualTaxpayerNumberRegisterMessage').innerHTML = 'Only 10 digits';
                return false;
            }
        };

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

        function showLoginPlace() {
            document.getElementById('loginPlace').style.display = 'inline';
            document.getElementById('registerPlace').style.display = 'none';
        };

        function hideRegisterPlace() {
            document.getElementById('registerPlace').style.display = 'none';
        };

        function register() {
            var validateLoginTypoBoolean = validateLoginTypo();
            console.log(validateLoginTypoBoolean);
            var validatePasswordBoolean = validatePassword();
            console.log(validatePasswordBoolean);
            var confirmPasswordsBoolean = confirmPasswords();
            console.log(confirmPasswordsBoolean);
            var validateIndividualTaxpayerNumberBoolean = validateIndividualTaxpayerNumber();
            console.log(validateIndividualTaxpayerNumberBoolean);
            if (validateLoginTypoBoolean && validateLoginTypoBoolean && confirmPasswordsBoolean && validateIndividualTaxpayerNumberBoolean) {
                console.log('true');
                sendRegisterRequest(document.getElementById('loginRegister').value, document.getElementById('passwordRegister').value, document.getElementById('individualTaxpayerNumberRegister').value);
            } else {
                console.log('false');
            }
        }
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
            <input id="loginRegister" type="text" onchange="validateLoginTypo()">
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
            <button onclick="register()">Register</button>
        </div>
    </main>
</body>
</html>
