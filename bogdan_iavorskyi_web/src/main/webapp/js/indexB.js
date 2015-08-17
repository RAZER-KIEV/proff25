/**
 * Created by bosyi on 27.07.15.
 */
$(document).ready(function() {
        $('#main').bind('click',ajaxC);
    }
);

function ajax() {
    $.ajax({
        url : 'ajaxB',
        success : function (res) {
            var strL = res.split('|');
            var ul = $('<ul></ul>');
            for (var i = 0; i < strL.length; i++) {

                ul.append('<li>' + strL[i] + '</li>');
            }
            $('body').append(ul);
        },
        type : 'post'
    })
};

function ajaxC() {
    $.ajax({
        url : 'ajaxC',
        success : function (result) {
            if (result.length == 0)
                return;
            var table = $('<table></table>');
            table.append('<thead><th>name</th><th>telefon</th><th>marka</th><th>number</th></thead>');
            var tbody = $('<tbody></tbody>');
            for (var i = 0; i < result.length; i++) {
                var row = $('<tr></tr>');
                row.append('<td>' + result[i].name + '</td>');
                row.append('<td>' + result[i].telefon + '</td>');
                row.append('<td>' + result[i].marka + '</td>');
                row.append('<td>' + result[i].number + '</td>');
                tbody.append(row);
            }
            table.append(tbody);
            $('#table').append(table);
        },
        type : 'post'
    })
};

/*
function ajax() {
    $.ajax({
        url : 'ajaxB',
        success : function (res) {
            var strL = res.split('|');
            for (var i = 0; i < strL.length; i++) {

                $('body').append('<p>' + strL[i] + '</p>');
            }
        },
        type : 'post'
    })
};*/
