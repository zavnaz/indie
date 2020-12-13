<%-- 
    Document   : nuevo
    Created on : Dec 13, 2020, 10:13:14 AM
    Author     : mario
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
        <title>Nuevo Proveedor</title>
        <!--
        
        Template 2094 Mason
        
        http://www.tooplate.com/view/2094-mason
        
        -->


    </head>
    <title>Nuevo Proveedor</title>

    <body>
       <div class="container-fluid">
            <div class="tm-body">
                <jsp:include page="/WEB-INF/jsp/menu_admin.jsp"/>
                <div class="tm-main-content">                    
                    <div class="container tm-site-header-container tm-site-header-col">
                        <div class=" col-md-5">
                <f:form action="crear" method="POST" modelAttribute="proveedor">

                    <div class="form-group">
                        <label for="codigoProv">Codigo Proveedor</label>
                        <div class="input-group">
                            <f:input path="idProv" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nombreProv">Nombre</label>
                        <div class="input-group">
                             <f:input path="nomProv" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <div class="input-group">
                            <f:input path="corProv" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                            <div class="form-group">
                        <label for="direccion">Direccionr</label>
                        <div class="input-group">
                            <f:input path="dirProv" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <div class="input-group">
                             <f:input path="telProv" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>

                    <f:button class="btn btn-info">Guardar</f:button>
                    <a class="btn btn-danger" href="<s:url
                           value="/proveedor/prov"/>">Cancelar</a>
                </f:form>
            </div>
        </div>
</div>
        
            </body>
</html>

