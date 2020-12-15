<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Indie Shop</title>
<!--

Template 2094 Mason

http://www.tooplate.com/view/2094-mason

-->

    <!-- load stylesheets -->
   
      </head>

      <body>
          
        <div class="container-fluid">
            
            <div class="tm-body">
          <jsp:include page="/WEB-INF/jsp/menu.jsp"/>    
               
                
                <div class="tm-main-content tm-gallery-container">                    
                    <div class="grid">    
                        <c:forEach items="${listaP}" var="pro">
                            <div class="grid-item">
                                <a href="<s:url value="/productos/verpro/${pro.idPro}"/>">
                                <img class="tm-img" src="${pageContext.request.contextPath}/assets/img/${pro.imgPro}.jpg" alt="Image">
                                </a>
                            </div>
                        </c:forEach>
                        
                    </div>                    
                </div> <!-- tm-main-content -->
            </div>

            <footer class="tm-footer text-right">
               
            </footer> 

        </div> <!-- container-fluid -->
        
        <!-- load JS files -->
        

        
        <!-- Templatemo scripts -->
        <script>  
    
        $(document).ready(function(){

            // init Masonry
            // https://codepen.io/craigwheeler/pen/MYjBga
            var $grid = $('.grid').masonry({
                
                // set itemSelector so .grid-sizer is not used in layout
                // itemSelector: '.grid-item',
                // use element for option
                // columnWidth: '.grid-sizer',
                // percentPosition: true

                itemSelector: '.grid-item',
                isFitWidth: true,
                columnWidth: 1
            });
            // layout Masonry after each image loads
            $grid.imagesLoaded().progress( function() {
              $grid.masonry('layout');
            });            

            // Update the current year in copyright
            $('.tm-current-year').text(new Date().getFullYear());        
        });

        </script>
    </body>
    </html>
