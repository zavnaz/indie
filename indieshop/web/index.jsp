<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome to Indie Shop</title>
<!--

Template 2094 Mason

http://www.tooplate.com/view/2094-mason

-->
    <!-- load stylesheets -->
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:300,400"> <!-- Google web font "Open Sans", https://fonts.google.com/ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome-4.7.0/css/font-awesome.min.css">         <!-- Font Awesome, http://fontawesome.io/ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">                               <!-- Bootstrap styles, https://getbootstrap.com/ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/tooplate-style.css">                            <!-- Templatemo style -->

  
      </head>

      <body>
        <div class="container-fluid">
            <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
            <div class="tm-body">
              
               
                
                <div class="tm-main-content tm-gallery-container">                    
                    <div class="grid">                                                    
                        <div class="grid-item"><img src="${pageContext.request.contextPath}/assets/img/gallery-img-23-01.jpg" alt="Image"></div>
                        <div class="grid-item"><img src="${pageContext.request.contextPath}/assets/img/gallery-img-11-01.jpg" alt="Image"></div>
                        <div class="grid-item"><img src="${pageContext.request.contextPath}/assets/img/gallery-img-12-01.jpg" alt="Image"></div>
                        <div class="grid-item"><img src="${pageContext.request.contextPath}/assets/img/gallery-img-11-02.jpg" alt="Image"></div>                        
                   
                    </div>                    
                </div> <!-- tm-main-content -->
            </div>

            <footer class="tm-footer text-right">
               
            </footer> 

        </div> <!-- container-fluid -->
        
        <!-- load JS files -->
        
        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
        <script src="${pageContext.request.contextPath}/assets/js/imagesloaded.pkgd.min.js"></script> <!-- https://masonry.desandro.com/ -->
        <script src="${pageContext.request.contextPath}/assets/masonry.pkgd.min.js"></script> <!-- https://masonry.desandro.com/ -->
        
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
