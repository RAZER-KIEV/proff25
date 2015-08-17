//var req = new XMLHttpRequest();
//req.onreadystatechange = function(){
//    if (req.readyState==4 && req.status==200){
//        if (req.responseText=="Login and password incorrect. Try again."){
//            document.getElementById('info').innerHTML = '<font id="info" color="BLUE">'+req.responseText+'</font>';
//        }
//        else {
//            document.getElementById('bd').innerHTML = '<body><div id="table_div"></div></body>';
//            var arr = req.responseText.split("<br>");
//            var arr1 = "";
//            for (var i=0;i<arr.length-1;i++){
//                var temp = arr[i].split(" ");
//                arr1+='<tr><td>'+temp[0]+'</td><td>'+temp[1]+'</td><td>'+temp[2]+'</td><td>'+temp[3]+'</td><td>'+temp[4]+'</td><tr>';
//            }
//            document.getElementById('table_div').innerHTML = '<div>' + '<table class="table1"><tr><td><strong>Id</strong></td><td><strong>Name</strong></td><td><strong>Surname</strong></td><td><strong>Phone</strong></td><td><strong>Car number</strong></td></tr>'+arr1+'</table>' + '</div>';
//        }
//    }
//}
//function check() {
//    var text1 = document.getElementById('login').value;
//    var text2 = document.getElementById('password').value;
//    req.open("GET", "/ajaxlogin?login="+text1+"&password="+text2, true);
//    req.send();
//}

$(document).ready(function(){
    $('#button').bind('click',function(){
        $.ajax({
            url: '/ajaxlogin',
            type: "POST",
            data: {login: $('#login').val(), password: $('#password').val()},
            success: function (res) {
                if (res.length==0){
                    $('#info').append('<font id="info" color="RED">'+"Login and password incorrect. Try again."+'</font>');
                }
                else{
                    var result = $('<ul></ul>');
                    for(var i=0;i<res.length;i++){
                        result.append($('<li><font color="YELLOW">'+res[i].surname+'</font></li>'));
                    }
                    $('#wrapper').hide();
                    $('#bd').append(result);
                }
            }
        }
        )
    });
});
