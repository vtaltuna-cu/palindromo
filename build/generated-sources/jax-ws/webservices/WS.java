
package webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WS", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WS {


    /**
     * 
     * @param search
     * @param pageSize
     * @param page
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProducts", targetNamespace = "http://webservices/", className = "webservices.GetProducts")
    @ResponseWrapper(localName = "getProductsResponse", targetNamespace = "http://webservices/", className = "webservices.GetProductsResponse")
    @Action(input = "http://webservices/WS/getProductsRequest", output = "http://webservices/WS/getProductsResponse")
    public String getProducts(
        @WebParam(name = "search", targetNamespace = "")
        String search,
        @WebParam(name = "page", targetNamespace = "")
        int page,
        @WebParam(name = "pageSize", targetNamespace = "")
        int pageSize);

}
