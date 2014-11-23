<%-- 
    Document   : verPelicula
    Created on : 23-nov-2014, 17:36:29
    Author     : Juanlu
--%>

<%@page import="war.services.Pelicula"%>
<%@page import="war.services.ServicioPelicula_Service"%>
<%@page import="javax.xml.ws.WebServiceRef"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%
            Pelicula pelicula;
            if (request.getSession().getAttribute("user") != null) {
                pelicula = (Pelicula)request.getAttribute("pelicula");
            } else {
                pelicula = new Pelicula();
                pelicula.setNombre("Forbidden access");
                pelicula.setAno("403");
                pelicula.setDescripcion("You don't have access to this resource");
            }
            
            
        %>

        <title><%= pelicula.getNombre() %></title>
            
    </head>
    <body>
        <h2><%= pelicula.getNombre()%> (<%=pelicula.getAno()%>)</h2>
        <p><%= pelicula.getDescripcion() %></p> 
    </body>
</html>
