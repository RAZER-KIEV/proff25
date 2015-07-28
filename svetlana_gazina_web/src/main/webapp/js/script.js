/**
 * Created by Sveta on 7/20/2015.
 */
$(document).ready(function(){
   $('#1').css('color','red');
   $('#2').css({border:'4px solid red', 'font-weight':'bold', 'border-radius':'10px', backgroundColor:'white'});
   $('#3').css('font-weight','bold');
   var el = $('<div>Fourth element</div>');
   $('#b').append(el);
   alert("Hello!");

})




