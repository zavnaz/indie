<%-- 
    Document   : editar
    Created on : Dec 13, 2020, 8:04:21 PM
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
        <title>Editar Producto</title>
        <!--
        
        Template 2094 Mason
        
        http://www.tooplate.com/view/2094-mason
        
        -->


    </head>
    <title>Editar Producto</title>

    <body>
       <div class="container-fluid">
            <div class="tm-body">
                <jsp:include page="/WEB-INF/jsp/menu_admin.jsp"/>
                <div class="tm-main-content">                    
                    <div class="container tm-site-header-container tm-site-header-col">
                        <div class=" col-md-5">
                <f:form action="${action}" method="POST" modelAttribute="producto">

                    <div class="form-group">
                        <label for="codigoProv">Codigo</label>
                        <div class="input-group">
                            <f:input path="idPro" cssClass="form-control" readonly="true"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nombreProv">Nombre</label>
                        <div class="input-group">
                             <f:input path="nomPro" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="categoriaProductos">Categoria</label>
                        <div class="input-group">
                            <f:select path="categoriaProductos.idCat" cssClass="form-control">
                                <f:options items="${listaCat}" itemLabel="nomCat"
                                           itemValue="idCat"/>
                            </f:select>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="categoriaProductos">Proveedor</label>
                        <div class="input-group">
                            <f:select path="proveedores.idProv" cssClass="form-control">
                                <f:options items="${listaProv}" itemLabel="nomProv"
                                           itemValue="idProv"/>
                            </f:select>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="desLib">Descripcion</label>
                        <div class="input-group">
                            <f:input path="desLib" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                            <div class="form-group">
                        <label for="precioPro">Precio</label>
                        <div class="input-group">
                            <f:input path="precioPro" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="imgPro">Imagen</label>
                        <div class="input-group">
                             <f:input path="imgPro" cssClass="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphiconasterisk"></span></span>
                        </div>
                    </div>

                    <f:button class="btn btn-info">Guardar</f:button>
                    <a class="btn btn-danger" href="<s:url
                           value="/productos/prod"/>">Cancelar</a>
                </f:form>
            </div>
        </div>
</div>
        
            </body>
</html>


