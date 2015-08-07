var req = new XMLHttpRequest();
req.onreadystatechange = function(){
    if (req.readyState==4 && req.status==200){
        document.getElementById('span').innerHTML = '<span>'+req.responseText+'</span>';
    }
}

function tryRegister(){
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    var ident = document.getElementById('id').value;
    req.open("GET", "/registerSuccess?login="+login+"&password="+password+"&confirmPassword="+confirmPassword+"&ident="+ident, true);
    req.send();
}