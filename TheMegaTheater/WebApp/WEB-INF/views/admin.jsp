<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Bienvenido administrador</title>    

	<spring:url value="/resources" var="urlPublic"></spring:url>
	
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">   
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="includes/menu.jsp"></jsp:include>

    <div class="container" role="main">
    <br/>

      <div class="jumbotron">        
        <h3>Administración del Sistema</h3>
        <p>Bienvenido(a) <sec:authentication property="principal.username"/> </p>
        <c:forEach items="${ roles }" var="rol">
        	<span class="badge badge-success">${ rol }</span>
        </c:forEach>
      </div>

      <!-- FOOTER -->
      <jsp:include page="includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 
    <script>
      function goBack() {
         window.history.back();
      }
    </script>
  </body>
</html>
