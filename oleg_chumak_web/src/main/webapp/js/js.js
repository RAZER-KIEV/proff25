$(document).ready(function(){
        var result;
        $('#1').bind('click', function(){
            $.ajax({url:'/newajax', success:function(res){
                var taxists = res.split(',');
                for(var i = 0; i < taxists.size; i++){
                    result.append('<td>' + taxists[i]+ '</td>');
                }
                document.write(res);
                $('body').append('<tr>result</tr>');
            }
            })
        });
    }
)