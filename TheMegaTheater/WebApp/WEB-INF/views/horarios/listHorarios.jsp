<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Horarios</title>
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/horarios/create" var="urlNewHorarioForm"></spring:url>
  
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container" role="main">
      <br/>

      <h3>Listado de Horarios</h3>
      
      <a href="${ urlNewHorarioForm }" class="btn btn-success" role="button" title="Nueva Horario" >
      Nuevo
      </a><br><br>
      
      <c:if test="${ message != null }">
      	<span class="alert alert-success">${ message }</span>
      	<br/>
      </c:if>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th scope="col">Pelicula</th>
                <th scope="col">Fecha</th>
                <th scope="col">Hora</th>
                <th scope="col">Sala</th>
                <th scope="col">Precio</th>
                <th scope="col">Opciones</th>
            </tr>
            <tr>
                <td>titulo</td>
                <td>fecha</td>
                <td>hora</td>
                <td>sala</td>
                <td>precio</td>              
                <td>
					<a href="#" class="btn btn-success btn-sm" role="button" title="Edit" >Editar</a>
					<a href="#" class="btn btn-danger btn-sm" role="button" title="Delete" >Eliminar</a>
				</td>
            </tr>
            
        </table>
      </div>
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 

  </body>
</html>