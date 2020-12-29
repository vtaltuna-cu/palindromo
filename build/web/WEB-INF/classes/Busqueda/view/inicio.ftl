<#include "_layout.ftl">

<#macro js_Doc_Ready>

    $.ajax({url: "${baseUrl}/Search?str=${search}",  
            success: function(result){
            $('.main-data').html(result);
        }});   
    
    $('#search-btn').on('click', function(e){
        var searchtext = $('input[name=search-text]').val();
        cambiar(searchtext, 1, 12);
    });
    
    $('#main').on('click', 'a.page-link', function(e){
        var searchtext = $('#searched-text').val();
        var pagenumber = $(this).attr('page-number');
        cambiar(searchtext, pagenumber, 12);
    });
    
    function cambiar(searchtext, page, size){
        $('.main-data').html('<div class="justify-content-center text-center"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only"></span>Cargando Datos...</div>');
        $.ajax({url: "${baseUrl}/Search?str="+searchtext+"&page="+page+"&size="+size,  
            success: function(result){
            $('.main-data').html(result);
        }});  
        $('input[name=search-text]').val("");
    }
        
</#macro>

<#macro main>
    <div class="container main-data" >
    </div>
</#macro>
        
<@page/>