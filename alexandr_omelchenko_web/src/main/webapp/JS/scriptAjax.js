
var req;

function start(){
    console.log('in start')
    req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if(req.readyState==4 && req.status==200){
          //  alert(req.responseText);
            var name = document.getElementById("sr");
            name.innerHTML = req.responseText;
        }
    }
}

function ajaxF(){
    console.log('in ajax')
    req.open("GET", '/ajax?login=' + document.getElementById('w1').value, true);
req.send();
}