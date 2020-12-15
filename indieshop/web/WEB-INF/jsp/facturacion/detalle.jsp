<%-- 
    Document   : detalle
    Created on : Dec 15, 2020, 1:22:48 PM
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
        <title>Productos</title>
        <!--
        
        Template 2094 Mason
        
        http://www.tooplate.com/view/2094-mason
        
        -->

    </head>

    <body>
        <div class="container-fluid">
            <div class="tm-body">
                <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
                <div class="tm-main-content">    
                    <br>
                    <div class="container tm-site-header-container tm-site-header-col">
                        <br><br>
                        <h2>total:$ ${tfac.getTotFac()}</h2>
                        <br><br>
                        <table class="table table-bordered" id="tabla">
                            <thead class="table-dark table-inverse">
                                <tr>
                                    <th>Codigo</th>
                                    <th>factura</th>
                                    <th>Producto</th>
                                    <th>cantidad</th>
                                    <th>Total</th>
                                     <th>Ver</th>
                                </tr>
                            </thead>
                            <tbody class="table-dark table-inverse">
                                <c:forEach items="${lf}" var="pro">
                                    <tr>
                                        <td>${pro.idPfac}</td>
                                        <td>${pro.facturacion.idFac}</td>
                                        <td>${pro.productos.nomPro}</td>
                                        <td>${pro.cantidadPfac}</td>
                                        <td>${pro.totPfac}</td>
                                        
                                        
                                        <td>
                                            <a class="btn btn-primary"
                                               href="<s:url value="/prodfactura/prfac/${pro.idPfac}"/>">
                                                <span class="glyphicon glyphicon-edit"></span>Editar</a>
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




