<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>The Mega Theater | Bienvenido</title>
    
    <spring:url value="/resources" var="urlPublic" />
        
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
    
    </head>
<body>
    <jsp:include page="../includes/menu.jsp"></jsp:include>
    
    <div class="container" role="main">
        <div class="card">
            <div class="card-header text-white bg-danger">
                <h3 class="card-title">Error 403.</h3>
            </div>
            <div class="card-body">
                <img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
                <h4>FORBIDEN: Acceso Denegado</h4>                
                <br>
                <button class="btn btn-success" onclick="goBack()">REGRESAR</button>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>        
    </div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
        
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
    
</body>
</html>