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
        //JSONObject json = new JSONObject(resultado); 
        return json;
    }
    
    
   /* private Integer percent = 50;
    
    
    
    public Map<String, Object> getProductos(String cadena, Integer pagina, Integer largoPagina){
        
        GetProducts ws = new GetProducts();
        
                
        
        Map<String, Object> resultado = new HashMap<String, Object>();
        cadena = cadena.trim();
        
        ArrayList<Producto> listado = new ArrayList<>();
        Boolean palindromo = false;
        
        try {
            Integer entero = Integer.parseInt(cadena);
            palindromo = esPalindromo(cadena);
            
            Producto producto = getProducto(entero,palindromo);
            if (producto!= null)
                listado.add(producto);
            
            resultado.put("productos", listado);
            return resultado;
        } catch( NumberFormatException ex){
            
        }
        
        if (cadena.length()>3)
            palindromo = esPalindromo(cadena);
        
        resultado = getProductos(cadena, palindromo, pagina, largoPagina);
        //resultado.put("productos", listado);
        return resultado;
    }
    
    private Producto getProducto(Integer identificador, Boolean palindromo){
        
        MongoCollection<Document> collection = (ManagerDB.getDataBase()).getCollection("producto"); 
        
        Document doc = collection.find(eq("id", identificador)).projection(excludeId()).first();
        
        try{
            String brand = (String)doc.get("brand");
            String description = (String)doc.get("description");
            String image = (String)doc.get("image");
            Integer price = (Integer)doc.get("price");
            Integer id = (Integer)doc.get("id");
            return new Producto(id, brand, description, image, price, palindromo, percent);
        } catch (Exception ex){
            return null;
        }
        
       // return null;
    }
    
    private Map<String, Object> getProductos(String cadena, Boolean palindromo, Integer pagina, Integer largoPagina){
        
        Map<String, Object> resultado = new HashMap<String, Object>();
        
        ArrayList<Producto> productos = new ArrayList<>();
        
        MongoCollection<Document> collection = (ManagerDB.getDataBase()).getCollection("producto"); 
        
        Integer saltos = largoPagina * (pagina -1);
        
        Integer cantidad = 0;
        
        FindIterable<Document> it ;
        if (cadena.trim().length()>0){
            it = collection.find(or(regex("brand", cadena), regex("description", cadena))).sort(Sorts.ascending("id")).skip(saltos).limit(largoPagina).projection(excludeId());
            cantidad = (int)collection.count(or(regex("brand", cadena), regex("description", cadena)));
        }
        else {
            it = collection.find().sort(Sorts.ascending("id")).skip(saltos).limit(largoPagina).projection(excludeId());
            cantidad = (int)collection.count();
        }
        
        resultado.put("cantidad", cantidad);
        resultado.put("pagina", pagina);
        resultado.put("paginas", (int)Math.ceil((double)cantidad/largoPagina));
        
        ArrayList<Document> docs = new ArrayList<Document>();

        it.into(docs);

        for (Document doc : docs) {
            String brand = (String)doc.get("brand");
            String description = (String)doc.get("description");
            String image = (String)doc.get("image");
            Integer price = (Integer)doc.get("price");
            Integer id = (Integer)doc.get("id");
            productos.add(new Producto(id, brand, description, image, price, palindromo, percent));
        }
     
        resultado.put("productos", productos);
        return resultado;
    }
    
    private Boolean esPalindromo(String cadena){
        cadena = cadena.replaceAll("\\s+", "").toLowerCase(); //Elimino todos los caracteres en blanco
        StringBuilder inicial = new StringBuilder(cadena.trim().toLowerCase());
        StringBuilder alreves = inicial.reverse();
        return (alreves.toString()).equals(cadena);
    }*/

    
}
