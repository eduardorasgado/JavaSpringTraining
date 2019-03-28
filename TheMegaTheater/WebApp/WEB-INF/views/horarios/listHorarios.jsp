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
    <spring:url value="/horarios/edit" var="urlEditHorario"></spring:url>
    <spring:url value="/horarios/delete" var="urlDeleteHorario"></spring:url>
    <spring:url value="/horarios" var="urlHorarios"></spring:url> 
  
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
      	<br/><br/>
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
            <c:forEach items="${ horarios.content }" var="horario">
            	<tr>
	                <td>${ horario.pelicula.titulo }</td>
	                <td><fmt:formatDate value="${ horario.fecha }"/></td>
	                <td>${ horario.hora }</td>
	                <td>${ horario.sala }</td>
	                <td>$${ horario.precio }</td>              
	                <td>
						<a href="${ urlEditHorario }/${ horario.id }" class="btn btn-success btn-sm" role="button" title="Edit" >Editar</a>
						<a href="${ urlDeleteHorario }/${ horario.id }" class="btn btn-danger btn-sm" role="button" title="Delete" >Eliminar</a>
					</td>
            	</tr>
            </c:forEach>
            
        </table>
        <nav aria-label="">
	        <ul class="pager"> 
	        	<c:if test="${ horarios.number > 0 }">
	        		<li><a href="${urlHorarios}/index?page=${horarios.number - 1 }">Anterior</a></li>
	        	</c:if>
	        	
	        	<span>pagina: ${ horarios.number + 1 }</span>
	        	
	        	<c:if test="${ horarios.number < (pageSize - 1) }">
	        		<li><a href="${urlHorarios}/index?page=${horarios.number + 1 }">Siguiente</a></li>
	        	</c:if>
	        	
	        </ul>
        </nav>
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