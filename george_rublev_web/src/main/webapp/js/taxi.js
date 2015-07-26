/**
 * Created by Well on 21.07.2015.
 */

var ajax = new XMLHttpRequest();

ajax.onreadystatechange = function () {
    if (ajax.readyState === 4 && ajax.status === 200) {
        if (ajax.responseText !== 'false') {
            //var div = document.getElementById('resp');
            //div.innerHTML = ajax.responseText;//ajax.responseText.split('|');
            document.write(ajax.responseText);
            resp.innerHTML=ajax.responseText;

        } else {
            alert('Login or Password - FAILED!!!!');
        }
    }
};


    function check() {
        console.log('check on');
        var ajax = new XMLHttpRequest();

        var login = document.getElementById("login").value;
        var pass = document.getElementById("pass").value;
        var resp = document.getElementById("resp").value;
        var dr =document.getElementsByName("dr").value;
        ajax.open('GET', '/indexTaxi.html?login=' + login + '&pass=' + pass);
        ajax.send();

        ajax.onreadystatechange = function () {
            if (ajax.readyState === 4 && ajax.status === 200) {
                if (ajax.responseText !== 'false') {
                    document.write(ajax.responseText);
                    resp.innerHTML=ajax.responseText;
                } else {
                    alert('Login or Password - FAILED!!!!');
                }
            }
        }
        console.log('/indexTaxi.html?login=' + login + '&pass=' + pass);
    }
var name = document.getElementById("resp");
var login;
var pass;
var stat='0';
var but='0';

var ajax = new XMLHttpRequest();
ajax.onreadystatechange = function () {
    if (ajax.readyState == 4 && ajax.status == 200) {


        var inputDate = ajax.responseText;
        var inputSplit = inputDate.split('|');
        if(inputSplit[0] !== "ok") {
            document.getElementById("error").innerHTML=inputSplit[0];
        }
        else
        {
            document.getElementById("logid").innerHTML='Login: '+login+'<br><p id="error" color="red"> </p><br><button onclick="reload()">Log Out</button>';
            document.getElementById("error").innerHTML='Connected.';
            document.getElementById("resp").innerHTML=inputSplit[5];
            document.getElementById("menu").innerHTML=inputSplit[4];
            login=inputSplit[1];
            pass=inputSplit[2];
            stat=inputSplit[3];
        }

        //resp.innerHTML
        //name.innerText ='<p>'+ inputSplit[5]+'</p>';
        //logid.innerHTML = inputSplit[0];
        console.log(ajax.responseText);
        console.log(login);
        console.log(pass);
    }
};

function send(butt) {
    but=butt;
    login = document.getElementById("login").value;
    pass = document.getElementById("pass").value;
    ajax.open('POST', '/indexTaxi.html?login=' + login+'&&pass='+pass+'&status='+stat+'&buton='+but,true);
    console.log('/indexTaxi.html?login='+login+'&&pass='+pass+'&status='+stat+'&buton='+but,true);
    ajax.send();
}

function menuButt(butt){
    but=butt;
    ajax.open('POST', '/indexTaxi.html?login=' + login+'&&pass='+pass+'&status='+stat+'&buton='+but,true);
    console.log('/indexTaxi.html?login='+login+'&&pass='+pass+'&status='+stat+'&buton='+but,true);
    ajax.send();
}

function reload(){
    location.reload();
}