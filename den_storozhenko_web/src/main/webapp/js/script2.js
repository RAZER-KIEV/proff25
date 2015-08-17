
//function isCorrect(){
//    var text1 = document.getElementById('text1').value;
//    var text2 = document.getElementById('text2').value;
//    var node = document.getElementById('answer');
//    if (text1===text2 || text1.length<=6 || text2.length<=6){
//        node.innerHTML = '<label>INCORRECT DATA</label>';
//        return false;
//    }
//    else{
//        return true;
//    }
//}
var req = new XMLHttpRequest();
req.onreadystatechange = function(){
    if (req.readyState==4 && req.status==200){
        document.getElementById('answer').innerHTML = '<label>'+req.responseText+'</label>';
    }
}
function check() {
    var text1 = document.getElementById('text1').value;
    var text2 = document.getElementById('text2').value;
    req.open("GET", "/ajax?login=" + text1 + "&password=" + text2, true);
    req.send();
}