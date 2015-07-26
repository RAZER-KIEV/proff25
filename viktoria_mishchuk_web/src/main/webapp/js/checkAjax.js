

var ajax = new XMLHttpRequest();
ajax.onreadystatechange = function () {
    if (ajax.readyState == 4 && ajax.status == 200) {
        var name = document.getElementById("send");
        name.innerHTML = ajax.responseText;
    }
};

    function send(arg) {
        var login = document.getElementById("login").value;
        ajax.open('GET', '/ajax?name=' + login);
        ajax.send();
    }