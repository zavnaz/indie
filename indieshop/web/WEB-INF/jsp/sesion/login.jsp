<%-- 
    Document   : login
    Created on : Dec 13, 2020, 4:52:15 PM
    Author     : mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="validador" method="POST">
            Usuario<input type="text" name="usu">
            <br>
            Pass<input type="password" name="pass">
            <input type="submit" value="enviar">
        </form>
    </body>
</html>
