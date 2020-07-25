<%-- 
    Document   : cerrarRequerimiento
    Created on : 22/07/2020, 02:39:03 PM
    Author     : amaru
--%>

<%@page import="dao.EncargadoDAO"%>
<%@page import="modelos.Encargado"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="modelos.Departamento"%>
<%@page import="dao.GerenciaDAO"%>
<%@page import="modelos.Gerencia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Requerimiento"%>
<%@page import="dao.RequerimientoDAO"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cerrar Requerimiento</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
        <link href="https://fonts.googleapis.com/css?family=Questrial&display=swap" rel="stylesheet" />
        <!-- Bulma Version 0.8.2-->
        <link rel="stylesheet" href="bulma-0.9.0/css/bulma.min.css" />
    </head>
    <body>
        
            <% 
                Usuario u = (Usuario)session.getAttribute("usuario");
                if(u == null){
                    response.sendRedirect("index.jsp");
                }
                RequerimientoDAO rd = new RequerimientoDAO();
                ArrayList<Requerimiento> requerimientos = rd.obtenerRequerimientos();
                String idGerencia = request.getParameter("idGerencia");
                String id_depto_origen = request.getParameter("id_depto_origen");
                String idEncargado = request.getParameter("idEncargado");
            %>
        <nav class="navbar is-info" role="navigation" aria-label="main navigation">
            <div id="navbarBasicExample" class="navbar-menu">
              <div class="navbar-end">
                <a href="logout.jsp" class="navbar-item ">
                    Cerrar Sesión
                </a>
              </div>
            </div>
        </nav>
        <div class="container mt-6">
            <h2 class="title is-2">Cerrar Requerimiento</h2>
            <br />
            <form action="cerrarRequerimiento.jsp" method="get">
                <div class="field">
                    <label class="label">Gerencia</label>
                    <div class="control">
                        <div class="select is-info is-fullwidth">
                            <select name="idGerencia">
                                <option value="0">Todos</option>
                                    <% ArrayList<Gerencia> gerencias = new GerenciaDAO().obtenerGerencias(); 
                                    for(Gerencia g:gerencias){%>
                                    <option value="<%= g.getIdGerencia() %>" <% if(idGerencia != null && g.getIdGerencia() == Integer.parseInt(idGerencia)){ %>selected="true"<%}%>>
                                    <%= g %>
                                </option>
                                    <% } %>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Departamento</label>
                    <div class="control">
                        <div class="select is-info is-fullwidth">
                            <select name="id_depto_origen">
                                <option value="0">Todos</option>
                                    <% ArrayList<Departamento> departamentos = new DepartamentoDAO().obtenerDepartamentos(); 
                                    for(Departamento d:departamentos){%>
                                    <option value="<%= d.getIdDepartamento() %>" <% if(id_depto_origen != null && d.getIdDepartamento()== Integer.parseInt(id_depto_origen)){ %>selected="true"<%}%>>
                                        <%= d %>
                                    </option>
                                    <% } %>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Asignado a</label>
                    <div class="control">
                        <div class="select is-info is-fullwidth">
                            <select name="idEncargado">
                                <option value="0">Todos</option>
                                    <% ArrayList<Encargado> encargados = new EncargadoDAO().obtenerEncargados(); 
                                    for(Encargado e:encargados){  %>
                                <option value="<%= e.getIdEncargado() %>" <% if(idEncargado != null && e.getIdEncargado() == Integer.parseInt(idEncargado)){ %> selected="true" <%}%>>
                                    <%= e %>
                                </option> 
                                   <% } %>
                            </select>
                        </div>
                    </div>
                </div>               

                <div class="field is-grouped is-pulled-right">
                    <div class="control">
                        <button class="button is-link">Buscar</button>
                    </div>
                    <a href="intranet.jsp" class="button is-link is-light">Volver</a>
                </div>
            </form>
            <br />
            <br />
            <table class="table is-fullwidth">
                <thead>
                  <tr>
                    <th>Gerencia</th>
                    <th>Departamento</th>
                    <th>Departamento asignado</th>
                    <th>Asignado a</th>
                    <th>Requerimiento</th>
                    <th></th>
                  </tr>
                </thead>

                <tbody>
                <%
                
                for(Requerimiento r: requerimientos) {
                    if(idGerencia == null || idGerencia.equals("0") || r.getDeptoOrigen().getGerencia().getIdGerencia() == Integer.parseInt(idGerencia)){
                        if(id_depto_origen == null  || id_depto_origen.equals("0") || r.getDeptoOrigen().getIdDepartamento() == Integer.parseInt(id_depto_origen)){
                            if(idEncargado == null  || idEncargado.equals("0") || r.getEncargado().getIdEncargado() == Integer.parseInt(idEncargado)){
                                if(r.isEstado() == false){
                %>
                  <tr>
                    <td><%= r.getDeptoOrigen().getGerencia().getNombre() %></td>
                    <td><%= r.getDeptoOrigen().getNombre() %></td>
                    <td><%= r.getDeptoAsignado().getNombre() %></td>
                    <td><%= r.getEncargado().toString() %></td>
                    <td><%= r.getDescripcion()  %></td>
                    <form action="ControladorRequerimiento" method="post">
                        <td>

                            <button class="button is-danger  is-rounded is-outlined is-small">Cerrar</button>
                            <input type="hidden" name="accion" value="2" />
                            <input type="hidden" name="idRequerimiento" value="<%= r.getIdRequerimiento() %>" />
                        </td>
                    </form>
                  </tr>
                <%
                                }
                            }
                        }
                    }  
                } %>  
                </tbody>
            </table>
        </div>
        <% if(request.getParameter("msj")!= null){%>
            <div class="notification is-warning is-light">
              <%= request.getParameter("msj") %>
            </div>
        <%}%> 
    </body>
</html>
