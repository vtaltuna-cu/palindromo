/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

import Busqueda.model.Oferta;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vivian
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/Search"})
public class SearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
         
            Configuration cfg = new Configuration();
            
            //Esto es lo qeu se utiliza cuando no esta en la raiz para que el template reconozca el ftl base
            TemplateLoader[] templatesPaths = new TemplateLoader[1];
            templatesPaths[0] = new ClassTemplateLoader(InicioServlet.class, "view");//aqui va el nombre de servlet actual
            cfg.setTemplateLoader(new MultiTemplateLoader(templatesPaths));
            
            cfg.setIncompatibleImprovements(new Version(2, 3, 26));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setLocale(Locale.US);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            String searchText = request.getParameter("str");
            
            if (searchText == null) 
                searchText=" ";
            
            Integer pageNumber = request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):1;
            
            Integer pageSize = request.getParameter("size")!=null?Integer.parseInt(request.getParameter("size")):12;
            
            //Para enviar datos a la vista
            Map<String, Object> data = new HashMap<String, Object>();
            String baseUrl = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
            data.put("baseUrl", baseUrl);
            
            Template template = null;
            
            data.put("search", searchText!=null?searchText:"");
            
            Map<String, Object> listado = (new Oferta()).getProducts(searchText,pageNumber, pageSize);
            
            if (listado.get("productos").toString().length() > 2){
                data.put("list", listado.get("productos"));
                data.put("pagina", listado.get("pagina"));
                data.put("paginas", listado.get("paginas"));
                data.put("cantidad", listado.get("cantidad"));
                template = cfg.getTemplate("search.ftl");
            } else 
                template = cfg.getTemplate("nofound.ftl");
            
            template.process(data, out);
            out.close();
        }
        catch (TemplateException e) {

        } 
        catch (Exception ex){
            String pepe = ex.getMessage().toString();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
