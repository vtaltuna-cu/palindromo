<#include "_layout_embedded.ftl">

<#macro js_Doc_Ready>
   
</#macro>

<#macro main>
    <div class="result-bar">
        <div class="d-flex align-items-center">
            <h6 class="">¿Estás buscando ${search}?</h6>
        </div>
    </div>
    <div class="search-result">
        <div class="row text-center">
            <h1 class="fa fa-search"></h1>
            <h3>Lo sentimos, no encontramos resultados</h3>
            <h6>Por favor, inténtalo nuevamente</h6>
        </div>
    </div>
</#macro>
        
<@page/>