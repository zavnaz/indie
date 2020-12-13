<%-- 
    Document   : listar
    Created on : 12-12-2020, 10:00:55 PM
    Author     : roco_
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Clientes Catalogo</title>
        <!--
        
        Template 2094 Mason
        
        http://www.tooplate.com/view/2094-mason
        
        -->
        <!-- load stylesheets -->
        <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:300,400"> <!-- Google web font "Open Sans", https://fonts.google.com/ -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/mason/font-awesome-4.7.0/css/font-awesome.min.css">         <!-- Font Awesome, http://fontawesome.io/ -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/mason/css/bootstrap.min.css">                               <!-- Bootstrap styles, https://getbootstrap.com/ -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/mason/css/tooplate-style.css">                            <!-- Templatemo style -->

    </head>

    <body>
        <div class="container-fluid">
            <div class="tm-body">
                <jsp:include page="/WEB-INF/jsp/menu_admin.jsp"/>
                <div class="tm-main-content">    
                    <br>
                    <div class="container tm-site-header-container tm-site-header-col">
                        <a  class="btn btn-dark" href="<s:url value="/usuarios/crear"/>">Nuevo Usuario</a>
                        <br><br>
                        <table class="table table-bordered" id="tabla">
                            <thead class="table-dark table-inverse">
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre Usuario</th>
                                    <th>Apellido Usuario</th>
                                    <th>Nickname</th>
                                    <th>Password</th>
                                    <th>Operaciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listarUsuarios}" var="usuarios">
                                    <tr>
                                        <td>${usuarios.idUs}</td>
                                        <td>${usuarios.nomUs}</td>
                                        <td>${usuarios.apeUs}</td>
                                        <td>${usuarios.nicUs}</td>
                                        <td>${usuarios.passUs}</td>
                                        <td>
                                            <a class="btn btn-primary"
                                               href="<s:url value="/usuarios/edit/${usuarios.idUs}"/>">
                                                <span class="glyphicon glyphicon-edit"></span>Editar</a>
                                            <a class="btn btn-danger" 
                                               href="<s:url value="/usuarios/delete/${usuarios.idUs}"/>">
                                                <span class="glyphicon glyphicon-trash"></span>Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table> <!-- tm-main-content -->
                    </div>
                </div>

            </div> <!-- container-fluid -->
            <!-- load JS files -->

            <script src="${pageContext.request.contextPath}/assets/mason/js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
            <script src="${pageContext.request.contextPath}/assets/mason/js/imagesloaded.pkgd.min.js"></script> <!-- https://masonry.desandro.com/ -->
            <script src="${pageContext.request.contextPath}/assets/mason/js/masonry.pkgd.min.js"></script> <!-- https://masonry.desandro.com/ -->

            <!-- Templatemo scripts -->

    </body>
</html>
