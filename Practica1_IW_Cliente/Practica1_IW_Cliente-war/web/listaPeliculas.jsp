<%-- 
    Document   : listaPeliculas
    Created on : 21-nov-2014, 13:36:02
    Author     : Sihame
--%>

<%@page import="war.services.Pelicula"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peliculas</title>
        <%
            List<Pelicula> lista = (List<Pelicula>)request.getAttribute("lista");
        %>
    </head>
    <body>
        <h2>Listado de Pel&iacute;culas...</h2>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>A&ntilde;o de estreno</th>
                <th>Descripci&oacute;n</th>
            </tr>
            <%
            if(lista!=null){
                for(Pelicula p : lista){
            
            %>
            <tr>
                <td><%= p.getNombre() %></td>
                <td><%= p.getAno() %></td>
                <td><%= p.getDescripcion() %></td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>
