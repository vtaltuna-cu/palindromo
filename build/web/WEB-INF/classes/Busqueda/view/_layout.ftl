<#macro top_header>
    <div class="container">
        <div class="linea">
            <p>Servicio al cliente de Lider: WhatsApp <b>+56957211492</b></p>
            <p>Horario: de lunes a viernes de 8:00 a 22:00 y sábado, domingo, festivos de 9:00 a 22:00</p>
        </div>
    </div><!-- .container -->
</#macro>
    
<#macro page_header>
    <div class="d-flex align-items-center flex-wrap">
        <div class="m-1">
            <div class="logo p-2" >
                <img class="img img-fluid" alt="Lider Logo" src="https://www.lider.cl/supermercado/contentassets/img/icons/lider-logo.svg"> 
            </div>
        </div>
        <div class="m-1">
            <div class="header-menu d-none d-md-block p-2">
                <nav class="navbar  navbar-light ">
                    <div class="container-fluid">
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="true" aria-label="Toggle navigation">
                          <span class="navbar-toggler-icon"></span>
                        </button>
                        <a class="navbar-brand" href="#">Categorias</a>
                    </div>
                </nav>
            </div>
        </div>
        <div class="flex-grow-1 m-1">
            <div class="search-box input-group">
                <button class="btn btn-outline-secondary" type="button" id="search-btn"><span class="fa fa-search"></span></button>
                <input type="text" class="form-control" placeholder="¿Qué estás buscando?" aria-label="Busqueda" name="search-text">
            </div>
        </div>
        <div class="m-1">
            <div class="cart p-2">
                <i class="fa fa-shopping-cart"></i>
                <span class="items">0</span>
            </div>
        </div>
        <div class="m-1">
            <div class="dept d-none d-xl-block p-2">
                <a href="#"><span class="fa fa-check"></span>Supermercado</a>
            </div>
        </div>
    </div>
</#macro> 
    
<#macro main>
    
</#macro>

<#macro page_footer>
    <div class="container">
        <p>Lider.cl - Razón Social: Lider Domicilio Ventas y Distribución Limitada, RUT: 78.968.610-6, es administrada y representada por Sermob Limitada, la que a su vez es representada por Matías Puente S. Dirección: Avenida del Valle N° 725, Huechuraba, Chile.</p>
    </div><!-- .container -->
</#macro>

<#macro includeJS>

</#macro>
    
<#macro js_Doc_Ready>
    
</#macro>

    
<#macro page>
<!DOCTYPE html>
<html dir="ltr" lang="en-US" >
    <head>
        <title>Ofertas Palíndromos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="${baseUrl}/theme/images/favicon.ico">
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"  crossorigin="anonymous">
        <link rel="stylesheet" href="${baseUrl}/theme/css/style.css"> 
    </head>
    <body>
        <section id="header">
            <div class="top-header">
                <@top_header/> 
            </div>
            <header class="class-header sticky-top">
                <div class="container ">
                    <@page_header/> 
                </div><!-- .container -->
            </header><!-- #header -->
        </section><!-- #section header -->
        <section id="main">
            <div class="container">
                <@main/> <!-- aqui es donde esta el codigo de verdad de a pagina -->
            </div><!-- .container -->
        </section><!-- #main -->
  
        <footer id="footer" >
            <@page_footer/> 
        </footer><!-- #footer -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"  crossorigin="anonymous"></script>
        <@includeJS/> <!-- aqui es donde se incluye algun script adicional a la pagina -->
        <script type="text/javascript">
            $(function() {
                <@js_Doc_Ready/> 
            });
        </script>
    </body>
</html>
</#macro>