<%-- 
    Document   : intranet
    Created on : 22/07/2020, 02:21:18 PM
    Author     : amaru
--%>

<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Intranet</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
        <!-- <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet"> -->
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
            <div class="field">
                <div class="my-4">
                    <button class="button is-medium is-fullwidth"><a href="ingresarRequerimiento.jsp">Ingresar Requerimiento</a></button>
                </div>
                <div class="my-4">
                    <button class="button is-medium is-fullwidth"><a href="consultarRequerimiento.jsp">Consultar Requerimiento</a></button>
                </div>
                <div class="my-4">
                    <button class="button is-medium is-fullwidth"><a href="cerrarRequerimiento.jsp">Cerrar Requerimiento</a></button>
                </div>
            </div>
        </div>
        
        <% if(request.getParameter("msj")!= null){%>
            <div class="notification is-warning is-light">
              <%= request.getParameter("msj") %>
            </div>
        <%}%> 

    </body>
</html>
