/**
 * Created by RAZER on 27.07.2015.
 */
$(document).ready(function(){
    var div1 = $('#div1');
    var div2 = $('#div2');
    var div3 = $('#div3');
    var nwel = $('<div id="div4">New ONE DIV</div>');
    div1.css('color','red');
    div2.css('border','medium solid red');
    div2.css('font-weight','medium');
    div3.css('font-weight','medium');
    //$(document).append(nwel);
    $('#oneBody').append(nwel);


})