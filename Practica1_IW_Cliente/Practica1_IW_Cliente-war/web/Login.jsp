<%-- 
    Document   : Login
    Created on : 22-nov-2014, 18:20:34
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesi&oacute;n</title>
    </head>
    <body>
        <%
        Object user = session.getAttribute("user");
        %>
        
        
        <% if(user == null){ %>
        <h3>Iniciar sesi&oacute;n</h3>
        
        <form action="LoginUsuarioServlet" method="post">
                Usuario: <input type="text" maxlength="20" size="20" name="usuario"> 
                <br/>
                Contrase&ntilde;a: <input type="password" maxlength="20" size="20" name="contrasena"> 
                <br/>
                <input type="submit" value="Login"> 
        </form>
        <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>

        <%}else{ %>
        <h3>Cerrar sesi&oacute;n</h3>
        
        <form action="LoginUsuarioServlet?logout=true" method="post">                
                <input type="submit" value="Logout"> 
        </form>
        <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>        
        <%} %>
        <br/>
    </body>
</html>
