<%-- 
    Document   : listar
    Created on : Dec 13, 2020, 10:13:05 AM
    Author     : mario
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
        <title>Proveedores</title>
        <!--
        
        Template 2094 Mason
        
        http://www.tooplate.com/view/2094-mason
        
        -->

    </head>

    <body>
        <div class="container-fluid">
            <div class="tm-body">
                <jsp:include page="/WEB-INF/jsp/menu_admin.jsp"/>
                <div class="tm-main-content">    
                    <br>
                    <div class="container tm-site-header-container tm-site-header-col">
                        <a  class="btn btn-dark" href="<s:url value="/proveedor/crear"/>">Nuevo Proveedor</a>
                        <h3>${nn}</h3>
                        <br><br>
                        <table class="table table-bordered" id="tabla">
                            <thead class="table-dark table-inverse">
                                <tr>
                                    <th>Codigo Proveedor</th>
                                    <th>Nombre Proveedor</th>
                                    <th>Correo Proveedor</th>
                                    <th>Direccion Proveedor</th>
                                    <th>Telefono</th>
                                     <th>Ventas Realizadas</th>
                                     <th>Operaciones</th>
                                </tr>
                            </thead>
                            <tbody class="table-dark table-inverse">
                                <c:forEach items="${lp}" var="pro">
                                    <tr>
                                        <td>${pro.idProv}</td>
                                        <td>${pro.nomProv}</td>
                                        <td>${pro.corProv}</td>
                                        <td>${pro.dirProv}</td>
                                        <td>${pro.telProv}</td>
                                        <td>${pro.numVenProv}</td>
                                        
                                        
                                        <td>
                                            <a class="btn btn-primary"
                                               href="<s:url value="/proveedor/edit/${pro.idProv}"/>">
                                                <span class="glyphicon glyphicon-edit"></span>Editar</a>
                                            <a class="btn btn-danger" 
                                               href="<s:url value="/proveedor/delete/${pro.idProv}"/>">
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


            <!-- Templatemo scripts -->

    </body>
</html>

