/**
 * Created by ivan on 20.07.15.
 */
var req = new XMLHttpRequest();

function print() {
    document.writeln('Hello, world!');
}

function printArgs(param) {
    document.writeln('Hello, world! Getted param is:' + param);
}

//print();
printArgs(2324);

function check() {
    var str1 = document.getElementById('1').value;
    var str2 = document.getElementById('2').value;

    if (str1 === str2) {
        document.writeln('Ou yee, babe!');
    }
    else {
        document.writeln('Shit!');
    }
}

function sendRequest() {
    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (req.readyState === 4 && reqStatus == 200) {
            var login = document.getElementById('1').value;
                document.writeln(ajax.responseText);
        }
    };
    ajax.open('GET','/ajax?login='+ login);
    ajax.send();
}
