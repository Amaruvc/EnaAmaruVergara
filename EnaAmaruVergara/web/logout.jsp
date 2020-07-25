<%-- 
    Document   : logout
    Created on : 22/07/2020, 02:52:36 PM
    Author     : amaru
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>

<%
    session.setAttribute("usuario", null);
    response.sendRedirect("index.jsp");
%>
