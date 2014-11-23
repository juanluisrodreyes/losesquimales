<%-- 
    Document   : verPelicula
    Created on : 23-nov-2014, 17:36:29
    Author     : Juanlu
--%>

<%@page import="war.services.ServicioPelicula_Service"%>
<%@page import="javax.xml.ws.WebServiceRef"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%
            war.services.Pelicula pelicula = (war.services.Pelicula)request.getAttribute("pelicula");
            
        %>

        <title><% pelicula.getNombre(); %></title>
            
    </head>
    <body>
        <h1><%pelicula.getNombre();%> (<%pelicula.getAno();%>)</h1>
        <p><% pelicula.getDescripcion(); %></p> 
    </body>
</html>
