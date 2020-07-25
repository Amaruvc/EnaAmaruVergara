/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DepartamentoDAO;
import dao.EncargadoDAO;
import dao.RequerimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Requerimiento;

/**
 *
 * @author amaru
 */
@WebServlet(name = "ControladorRequerimiento", urlPatterns = {"/ControladorRequerimiento"})
public class ControladorRequerimiento extends HttpServlet {

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
        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "1":
                    ingresarRequerimiento(request, response);
                    break;
                case "2":
                    cerrarRequerimiento(request, response);
                    break;
            }
        } else {
            response.sendRedirect("intranet.jsp?msjProducto=acceso no permitido");
        }
    }

    private void ingresarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            String descripcion = request.getParameter("descripcion");
            boolean estado = false;
            int id_depto_origen = Integer.parseInt(request.getParameter("id_depto_origen"));
            int id_depto_asignado = Integer.parseInt(request.getParameter("id_depto_asignado"));
            int idEncargado = Integer.parseInt(request.getParameter("idEncargado"));
            if (descripcion.equals("") || id_depto_asignado <= 0 || id_depto_origen <= 0 || idEncargado <= 0) {
                response.sendRedirect("ingresarRequerimiento.jsp?msj=valores erroneos");
            } else {
                RequerimientoDAO rd = new RequerimientoDAO();
                DepartamentoDAO dd = new DepartamentoDAO();
                EncargadoDAO ed = new EncargadoDAO();
                Requerimiento r = new Requerimiento(descripcion, estado, dd.obtenerDepartamento(id_depto_origen), dd.obtenerDepartamento(id_depto_asignado), ed.obtenerEncargado(idEncargado));
                
                int respuesta = rd.registrar(r);
                if (respuesta == 1) {
                    response.sendRedirect("ingresarRequerimiento.jsp?msj=Requerimiento ingresado correctamente");
                } else {
                    response.sendRedirect("ingresarRequerimiento.jsp?msj=El requerimiento no se pudo ingresar");
                }
            }
            
            
        }catch (Exception e) {
            response.sendRedirect("ingresarRequerimiento.jsp?msj=" + e.getMessage());
        }
    }
    
    private void cerrarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            RequerimientoDAO rd = new RequerimientoDAO();
            
            int idRequerimiento = Integer.parseInt(request.getParameter("idRequerimiento"));
            if(idRequerimiento <= 0){
                response.sendRedirect("cerrarRequerimiento.jsp?msj=El requerimiento ingresado no existe");
            } else {
                Requerimiento r = rd.obtenerRequerimiento(idRequerimiento);
                r.setEstado(true);
                
                int res = rd.modificarRequerimiento(r);
                if (res == 1) {
                    response.sendRedirect("cerrarRequerimiento.jsp?msj=Requerimiento cerrado correctamente");
                } else {
                    response.sendRedirect("cerrarRequerimiento.jsp?msj=El requerimiento no se pudo cerrar");
                }
            }
        }catch (Exception e) {
            response.sendRedirect("cerrarRequerimiento.jsp?msj=" + e.getMessage());
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
