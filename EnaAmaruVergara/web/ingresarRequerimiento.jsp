<%-- 
    Document   : ingresarRequerimiento
    Created on : 22/07/2020, 02:38:48 PM
    Author     : amaru
--%>

<%@page import="dao.EncargadoDAO"%>
<%@page import="modelos.Encargado"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="modelos.Departamento"%>
<%@page import="dao.GerenciaDAO"%>
<%@page import="modelos.Gerencia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Ingresar Requerimiento</title>
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
            <h2 class="title is-2">Ingresar Requerimiento</h2>
            <br />
            <h4 class="title is-4">Solicitud realizada por</h4>
            <form action="ControladorRequerimiento" method="post">
                <div class="field">
                    <label class="label">Gerencia</label>
                    <div class="control">
                        <div class="select is-info is-fullwidth">
                            <select name="idGerencia">
                                <option value="0">Seleccione</option>
                                    <% ArrayList<Gerencia> gerencias = new GerenciaDAO().obtenerGerencias(); 
                                    for(Gerencia g:gerencias){%>
                                <option value="<%= g.getIdGerencia() %>"><%= g %></option>
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
                                <option value="0">Seleccione</option>
                                    <% ArrayList<Departamento> departamentos = new DepartamentoDAO().obtenerDepartamentos(); 
                                    for(Departamento d:departamentos){%>
                                <option value="<%= d.getIdDepartamento() %>"><%= d %></option>
                                    <% } %>
                            </select>
                        </div>
                    </div>
                </div>
                <br />
                <br />
                <h4 class="title is-4">Solicitud designada a</h4>
                <div class="field">
                    <label class="label">Asignar a</label>
                    <div class="control">
                        <div class="select is-info is-fullwidth">
                            <select name="id_depto_asignado">
                                <option value="0">Seleccione</option>
                                    <% ArrayList<Departamento> departamentosServicio = new DepartamentoDAO().obtenerDepartamentos(); 
                                    for(Departamento d:departamentosServicio){
                                        if(d.isPrestaServicio()){  %>
                                <option value="<%= d.getIdDepartamento() %>"><%= d %></option>
                                        <% } %>
                                    <% } %>
                            </select>
                        </div>
                    </div>
                </div>
                
                <div class="field">
                    <label class="label">Encargado</label>
                    <div class="control">
                        <div class="select is-info is-fullwidth">
                            <select name="idEncargado">
                                <option value="0">Seleccione</option>
                                    <% ArrayList<Encargado> encargados = new EncargadoDAO().obtenerEncargados(); 
                                    for(Encargado e:encargados){%>
                                <option value="<%= e.getIdEncargado() %>"><%= e %></option>
                                    <% } %>
                            </select>
                        </div>
                    </div>
                </div>
                
                <div class="field">
                    <div class="control">
                        <textarea class="textarea is-info"  name="descripcion" placeholder="Descripcion" rows="4"></textarea>
                    </div>
                </div>
                    <% if(request.getParameter("msj")!= null){%>
                <div class="notification is-warning is-light">
                  <%= request.getParameter("msj") %>
                </div>
                    <%}%>   
                <div class="field is-grouped is-pulled-right">
                    <div class="control">
                        <button class="button is-link">Enviar</button>
                        <input type="hidden" name="accion" value="1" />
                    </div>
                    <a href="intranet.jsp" class="button is-link is-light">Volver</a>
                </div>
            </form>
        </div>
    </body>
</html>
