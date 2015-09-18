/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.Json;
import javax.json.JsonArray;
import javax.servlet.ServletContext;
import org.json.JSONArray;
import org.json.JSONObject;

//import org.json.simple.JSONObject;

/**
 *
 * @author iiteplus
 */
@WebServlet(urlPatterns = {"/guardaArbol"})
public class guardaArbol extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    int countlink;
    int countarbolEvento;
    int countarbolCompuertaAND;
    
           
   
private ServletContext context;

private static Logger logger = Logger.getLogger("classname");
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        context=getServletContext();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           JSONObject jObj    = new JSONObject(request.getParameter("arbol"));       
           context.log(("el objeto recibido es:"+jObj.toString()));           
           Iterator it = jObj.keys(); //gets all the keys
           JSONArray objects=jObj.getJSONArray("cells");
           context.log("Tantos elementos"+objects.length());
           Iterator ita=objects.iterator();
            
           while(ita.hasNext()){
           JSONObject objeto=(JSONObject)ita.next();
           context.log("iterando");
           context.log(objeto.toString());
           context.log("obteniendo el tipo de Objeto:"+objeto.getString("type")+" id: "+objeto.getString("id"));
           switch(objeto.getString("type")){
               case "link":
                   countlink++;
                   JSONObject source=objeto.getJSONObject("source");
                   JSONObject target=objeto.getJSONObject("target");
                   context.log("\n"+"Surce id: "+source.getString("id")+" port:"+source.getString("port")+"\n Target id:"+target.getString("id")+" port:"+target.getString("port"));
                   break;
                   
               case "arbol.Evento":
                   countarbolEvento++;
                   break;
                   
                   
               case "arbol.CompuertaAND":
                   countarbolCompuertaAND++;
                   break;                              
            }           
           }
        context.log("se recibieron:\n"+" link:"+countlink+" \n arbol.Evento:"+countarbolEvento+"\n arbol.CompuertaAND:"+countarbolCompuertaAND+"\n");         
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
