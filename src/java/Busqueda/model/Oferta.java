/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda.model;

//import com.mongodb.util.JSON;
import com.google.gson.Gson;
import java.util.Map;

/**
 *
 * @author vivian
 */
public class Oferta {

    public Oferta() {
    }
    
    public static Map<String, Object> getProducts(java.lang.String search, int page, int pageSize) {
        webservices.WS_Service service = new webservices.WS_Service();
        webservices.WS port = service.getWSPort();
        String resultado = port.getProducts(search, page, pageSize);
        Gson g = new Gson();  
        Map<String, Object> json = g.fromJson(resultado, Map.class);
        return json;
    }
    
}
