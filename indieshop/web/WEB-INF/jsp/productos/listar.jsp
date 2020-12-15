<%-- 
    Document   : listar
    Created on : Dec 13, 2020, 7:57:12 PM
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
                <jsp:include page="/WEB-INF/jsp/menu_admin.jsp"/>
                <div class="tm-main-content">    
                    <br>
                    <div class="container tm-site-header-container tm-site-header-col">
                        <a  class="btn btn-dark" href="<s:url value="/productos/crear"/>">Nuevo Producto</a>
                        <h3>${nn}</h3>
                        <br><br>
                        <table class="table table-bordered" id="tabla">
                            <thead class="table-dark table-inverse">
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Categoria</th>
                                    <th>Proveedor</th>
                                    <th>Precio</th>
                                     <th>Existencias</th>
                                     <th>Imagen</th>
                                     <th>Operaciones</th>
                                </tr>
                            </thead>
                            <tbody class="table-dark table-inverse">
                                <c:forEach items="${lp}" var="pro">
                                    <tr>
                                        <td>${pro.idPro}</td>
                                        <td>${pro.nomPro}</td>
                                        <td>${pro.categoriaProductos.nomCat}</td>
                                        <td>${pro.proveedores.nomProv}</td>
                                        <td>${pro.precioPro}</td>
                                        <td>${pro.exiPro}</td>
                                       
                                        <td><img class="tm-img" src="${pageContext.request.contextPath}/assets/img/${pro.imgPro}.jpg" alt="Image"></td>
                                        
                                        <td>
                                            <a class="btn btn-primary"
                                               href="<s:url value="/productos/edit/${pro.idPro}"/>">
                                                <span class="glyphicon glyphicon-edit"></span>Editar</a>
                                            <a class="btn btn-danger" 
                                               href="<s:url value="/productos/delete/${pro.idPro}"/>">
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


