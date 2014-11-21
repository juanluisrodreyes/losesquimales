<%-- 
    Document   : RegistroUsuarios
    Created on : 21-nov-2014, 12:14:46
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de usuarios</title>
    </head>
    <body>
        <h3>Registro de usuarios</h3>
        
        <form action="RegistroUsuarioServlet" method="post">
                Usuario: <input type="text" maxlength="20" size="20" name="usuario"> 
                <br/>
                Contrase&ntilde;a: <input type="password" maxlength="20" size="20" name="contrasena"> 
                <br/>
                <input type="submit" value="Registrar"> 
        </form>
        <b><a style="color:red"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a></b>
        <br/>
    </body>
</html>
