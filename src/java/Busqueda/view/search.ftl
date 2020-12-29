<#include "_layout_embedded.ftl">

<#macro js_Doc_Ready>
   
</#macro>

<#macro main>
    <div class="result-bar">
        <div class="d-flex align-items-center">
            <h6 class="">Resultados para: <b id="searched-text">${search}</b></h6>
            <div class="ms-auto ">
                <div class="dropdown">
                    <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="order-selector" data-bs-toggle="dropdown" aria-expanded="false">
                        Ordenar por: Destacados
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="order-selector">
                        <li><a class="dropdown-item" href="#">Destacados</a></li>
                        <li><a class="dropdown-item" href="#">Menor precio</a></li>
                        <li><a class="dropdown-item" href="#">Mayor precio</a></li>
                        <li><a class="dropdown-item" href="#">Menor descuento</a></li>
                        <li><a class="dropdown-item" href="#">Mayor descuento</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-3 d-none d-xl-block"></div>
        <div class="col">
            <div class="search-result row row-cols-1 row-cols-sm-2 row-cols-md-3  g-4">
                <#if list?has_content>
                    <#list list as item>
                    <div class="col">
                        <div class="card h-100">
                            <img src="http://${item.image}" class="card-img-top " alt="...">
                            <div class="card-body">
                                <p class="card-text"><strong class="p-1">${item.brand}</strong>${item.desription}</p>
                                <h5 class="card-title">$${item.finalPrice} <#if item.discount><span class="badge rounded-pill bg-danger">${item.percent}%</span></#if></h5>
                                <#if item.discount><p class="card-text "><del>$${item.price}</del></p></#if>
                                <div class="w-100"></div>
                            </div>
                            <div class="card-footer">
                                <div class="d-flex">
                                    <small class="btn-transport "><span class="fa fa-truck "></span>Despacho</small>
                                    <small class="btn-warehouse  "><span class="fa fa-warehouse "></span>Retiro</small>
                                </div>
                                <div class="add-cart ">Agregar</div>
                            </div>
                        </div>
                    </div>
                    </#list>
                <#else>
                    <div>No existen elementos que mostrar</div>
                </#if>
            </div>
            <div class="paging">
                <div class="container">
                    <nav>
                        <ul class="pagination justify-content-center">
                            <li class="page-item <#if pagina == 1>disabled</#if>">
                                <a class="page-link" href="#" page-number="${pagina-1}" tabindex="-1"><span class="fa fa-chevron-left"></span></a>
                            </li>
                            <#local contador = 0>
                            <#if pagina lte 3>
                                <#local inicio = 1>
                            <#else>
                                <#local inicio = pagina-2>
                                <li class="page-item disabled"><a class="page-link" href="#">...</a></li>
                            </#if>
                            <#list inicio..paginas as i>
                                <li class="page-item <#if pagina == i>active</#if>"><a class="page-link" href="#" page-number="${i}">${i}</a></li>
                                <#local contador = contador +1>
                                <#if contador gte 5>
                                    <#break>
                                </#if>
                            </#list>
                            <#if pagina + 2 lt paginas>
                                <li class="page-item disabled"><a class="page-link" >...</a></li>
                            </#if>
                            <li class="page-item <#if pagina == paginas>disabled</#if>">
                                <a class="page-link " href="#" page-number="${pagina+1}"><span class="fa fa-chevron-right"></span></a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</#macro>
        
<@page/>