/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iiteplus
 */
@WebServlet(urlPatterns = {"/getArbol"})
public class getArbol extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String arbol="{\"cells\":[{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[],\"position\":{\"x\":713,\"y\":49},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"f8b8ac2e-2290-427b-b7b0-6322adcb201c\",\"z\":4,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2}}},{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[\"out\"],\"position\":{\"x\":381,\"y\":323},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"aa67c2db-98c5-4bd2-86ac-2fd3d334d29c\",\"z\":5,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"out\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"arbol.CompuertaAND\",\"size\":{\"width\":48,\"height\":48},\"inPorts\":[\"\"],\"outPorts\":[\"\"],\"position\":{\"x\":774,\"y\":231},\"angle\":0,\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"z\":7,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in27\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out28\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"link\",\"source\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out28\"},\"target\":{\"id\":\"f8b8ac2e-2290-427b-b7b0-6322adcb201c\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in\"},\"id\":\"cdc07023-089f-44e9-bda4-02fdb9642858\",\"embeds\":\"\",\"z\":8,\"attrs\":{}},{\"type\":\"link\",\"source\":{\"id\":\"aa67c2db-98c5-4bd2-86ac-2fd3d334d29c\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out\"},\"target\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in27\"},\"id\":\"76963d38-1ab7-4acb-953e-27f50f618132\",\"embeds\":\"\",\"z\":9,\"attrs\":{}},{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[\"out\"],\"position\":{\"x\":893,\"y\":335},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"6a00c933-5979-406e-8c08-b623c3497c94\",\"z\":11,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"out\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"link\",\"source\":{\"id\":\"6a00c933-5979-406e-8c08-b623c3497c94\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out\"},\"target\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in27\"},\"id\":\"3544c930-bfd5-48a7-a58f-f5d3da99bde5\",\"embeds\":\"\",\"z\":12,\"attrs\":{}}]}";
            out.print(arbol);
        }
    }

    // <editor-fold defaultstate=\"collapsed\" desc=\"HttpServlet methods. Click on the + sign on the left to edit the code.\">
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
