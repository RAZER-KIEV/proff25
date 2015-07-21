/**
 * Created by RAZER on 20.07.2015.
 */

/*
val = new Array(0,1,2,3,4,5,6,7,8,9);
lav= new Array();
for(var i = 9; i>= 0; i--){
    document.write(val[i]);
}*/
function check(){
  var node = document.getElementsByName('spn');
    var input1 = document.getElementsByName('text1');
    var input2 = document.getElementsByName('text2');
    var output = document.getElementsByName('myP');
    var text1 = input1.valueOf(input1);
    var text2 = input2.valueOf(input2);
    if(text1==text2){
        output.input.value='Дa!';
    }

  label= node.innerHTML='<p>No</p>';
  text1 = node.innerHTML='<input type="text" name="text1" />';
    text2 = node.innerHTML='<input type="text" name="text2" />';
    if(text1==text2){
        console.log('Say Yes');
        label.input.value='Yes';
    } else
        console.log('Say No');

}
