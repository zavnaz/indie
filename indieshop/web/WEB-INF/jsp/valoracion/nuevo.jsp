<%-- 
    Document   : nuevo
    Created on : 12-13-2020, 05:46:46 PM
    Author     : roco_
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
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
    <title>Nuevo Categoria Productos</title>

    <body>
        <div class="container-fluid">
            <div class="tm-body">
                <jsp:include page="/WEB-INF/jsp/menu_admin.jsp"/>
                <div class="tm-main-content">                    
                    <div class="container tm-site-header-container tm-site-header-col">
                        <div class=" col-md-5">
                            <f:form action="crear" method="POST" modelAttribute="valoracion">

                                <div class="form-group">
                                    <label for="idVal">Id Valoracion</label>
                                    <div class="input-group">
                                        <f:input path="idVal" cssClass="form-control"/>
                                        <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                                    </div>
                                </div>
                              
                                        <div class="form-group">
                                    <label for="des">Nombre Empresa</label>
                                    <div class="input-group">
                                        <f:select path="proveedores.idProv" cssClass="form-control">
                                            <f:options items="${listarProveedor}" itemLabel="nomProv"
                                                       itemValue="idProv"/>
                                        </f:select>
                                        <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                                    </div>
                                </div>
                                          <div class="form-group">
                                    <label for="des">Comentario</label>
                                    <div class="input-group">
                                        <f:textarea path="comVal" cssClass="form-control" rows="4"/>
                                        
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="des">Calificacion</label>
                                    <div class="input-group">
                                        <h1> <p class="clasificacion">
                                            
                                                <f:radiobutton path="calVal" id="radio1" value="5"/>  
                                                <label for="radio1">★</label>
                                                   <f:radiobutton path="calVal" id="radio2" value="4"/>  
                                                <label for="radio2">★</label>
                                                   <f:radiobutton path="calVal" id="radio3" value="3"/>  
                                                <label for="radio3">★</label>
                                                   <f:radiobutton path="calVal" id="radio4" value="2"/>  
                                                <label for="radio4">★</label>
                                                   <f:radiobutton path="calVal" id="radio5" value="1"/>  
                                                <label for="radio5">★</label>
                                              
                                           
                                        </p>
                                    </div>
                                </div>
                              
                                <f:button class="btn btn-info">Guardar</f:button>
                                <a class="btn btn-danger" href="<s:url
                                       value="/valoracion/cat"/>">Cancelar</a>
                            </f:form>
                        </div>
                    </div>
                </div>
                <script src="${pageContext.request.contextPath}/assets/mason/js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
                <script src="${pageContext.request.contextPath}/assets/mason/js/imagesloaded.pkgd.min.js"></script> <!-- https://masonry.desandro.com/ -->
                <script src="${pageContext.request.contextPath}/assets/mason/js/masonry.pkgd.min.js"></script> <!-- https://masonry.desandro.com/ -->

                </body>
                </html>
