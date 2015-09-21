/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.logica;

import dto.ArbolFallaDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.CrearArbolFalla;
import logic.InsertarArbolFalla;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SChaves
 */
//@WebServlet(urlPatterns = {"/getArbol"})
public class guardaarbolgrafico extends HttpServlet {

  private ServletContext context;

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("application/json;charset=utf-8");   
    response.setHeader("Access-Control-Allow-Origin","*");
    
    PrintWriter out2 = null;
    context = getServletContext();
    boolean status=false;
    
    InsertarArbolFalla falla = new InsertarArbolFalla();
          
    try (PrintWriter out = response.getWriter()) {
      
      out2=out;
      JSONObject jObj = new JSONObject(request.getParameter("arbol"));
      JSONArray objects = jObj.getJSONArray("cells");
      if (objects.length() > 0){
        status=falla.insertarGrafico(request.getParameter("id"), request.getParameter("nombre"), request.getParameter("arbol"));        
      }  
            
      if (status){
        out.write("{\"status\":1}");
      }else{  
        out.write("{\"status\":-1}");
      }
//      out.flush();
      out.close();
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
