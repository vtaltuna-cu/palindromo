<#macro main>
    
</#macro>
        
<#macro js_Doc_Ready>
    
</#macro>
    
<#macro includeJS>
    
</#macro>
    
<#macro page>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
    <body>
    <@main/> 
    <@includeJS/> <!-- aqui es donde se incluye algun script adicional a la pagina -->
    <script type="text/javascript">
    $(function() {
        <@js_Doc_Ready/> 
      });
    </script>
    </body>
</html>
</#macro>