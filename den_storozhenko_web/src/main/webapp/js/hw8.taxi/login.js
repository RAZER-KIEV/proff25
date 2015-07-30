$(document).ready(function(){
    $('#button').bind('click',function(){
        $.ajax({
                url: '/showFreeOrders',
                type: "POST",
                data: {phone: $('#login').val(), password: $('#password').val()},
                success: function (res) {
                    if (res.length==0){
                        $('#span').html('<font id="info" color="RED">'+"Phone and password incorrect. Try again."+'</font>');
                    }
                    else{

                        var result = $('<select id="order"></select>');
                        for(var i=0;i<res.length;i++){
                            result.append($('<option><font color="YELLOW">'+res[i].amount+'|'+res[i].addressFrom+'|'+res[i].addressTo+'|'+res[i].id+'</font></option>'));
                        }
                        $('#header').html($('<h1>Take order</h1><span id="span"></span>'));
                        $('#content').html(result);
                        $('#footer').html($('<button id="take" class="button">TAKE ORDER</button>'));
                    }
                }
            }
        )
    });

    $("body").on('click', '#take', function(){
        $.ajax({
                url: '/takeOrder',
                type: "POST",
                data: {order: $('#order').val()},
                success: function (res) {
                    if (res==="-"){
                        $('#span').html($('<font id="info" color="RED">'+"Order taking error. Try again."+'</font>'));
                    }
                    else{
                        $('#span').html($('<font id="info" color="BLUE">'+"Order \""+$('#order').val()+"\" was taken."+'</font>'));
                        $("#order option:selected").remove();
                    }
                }
            }
        )
    });
});

function onLoad(){
    $.ajax({
            url: '/driver.html',
            type: "GET",
            success: function (res) {
                if ($('#isLogined').val()==='true'){
                    $.ajax({
                            url: '/getFreeOrders',
                            type: "POST",
                            success: function (res) {
                                var result = $('<select id="order"></select>');
                                for (var i = 0; i < res.length; i++) {
                                    result.append($('<option><font color="YELLOW">' + res[i].amount + '|' + res[i].addressFrom + '|' + res[i].addressTo + '|' + res[i].id + '</font></option>'));
                                }
                                $('#header').html($('<h1>Take order</h1><span id="span"></span>'));
                                $('#content').html(result);
                                $('#footer').html($('<button id="take" class="button">TAKE ORDER</button>'));
                            }
                        }
                    );
                }
            }
        }
    )
}