<%-- 
    Document   : editar
    Created on : 12-12-2020, 10:01:09 PM
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
        <title>Editar Cliente</title>

    <body>
        <div class="container-fluid">
            <div class="tm-body">
                <jsp:include page="/WEB-INF/jsp/menu_admin.jsp"/>
               <div class="tm-main-content">                    
                    <div class="container tm-site-header-container tm-site-header-col">
                        <div class=" col-md-3">
                        <f:form action="${action}" method="POST"
                            modelAttribute="usuarios">
                     
                        <div class="form-group">
                            <label for="codigoClie">Codigo</label>
                            <div class="input-group">
                                <f:input path="idUs" cssClass="form-control" readonly="true"/>
                                <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="codigoUsu">Nombre Usuario</label>
                              <div class="input-group">
                              <f:input path="nomUs" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="codigoClie">Apellido Usuario</label>
                            <div class="input-group">
                                <f:input path="apeUs" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                            </div>
                        </div>
                                <div class="form-group">
                            <label for="telefono">Nickname</label>
                            <div class="input-group">
                                <f:input path="nicUs" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                            </div>
                        </div>
                                <div class="form-group">
                            <label for="codigoClie">Password</label>
                            <div class="input-group">
                                <f:input path="passUs" cssClass="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                            </div>
                        </div>
                                 <div class="form-group">
                            <label for="codigoClie">Tipos de Usuario </label>
                            <div class="input-group">
                              <f:select path="tiposUsuarios.idTu" cssClass="form-control">
                                <f:options items="${listarTiposUsuarios}" itemLabel="rolTu"
                                           itemValue="idTu"/>
                            </f:select>
                                <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                            </div>
                        </div>
                                  
                        <f:button class="btn btn-info">Guardar</f:button>
                        <a class="btn btn-danger" href="<s:url
                               value="/usuarios/cat"/>">Cancelar</a>
                    </f:form>
                </div>
            </div>
        
        <script src="${pageContext.request.contextPath}/assets/mason/js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
        <script src="${pageContext.request.contextPath}/assets/mason/js/imagesloaded.pkgd.min.js"></script> <!-- https://masonry.desandro.com/ -->
        <script src="${pageContext.request.contextPath}/assets/mason/js/masonry.pkgd.min.js"></script> <!-- https://masonry.desandro.com/ -->
    </body>
</html>

