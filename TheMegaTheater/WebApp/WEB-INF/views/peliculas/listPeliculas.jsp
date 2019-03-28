<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Peliculas</title>
    
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/peliculas" var="urlPeliculas"></spring:url>
    <spring:url value="/peliculas/create" var="urlCreatePelicula"></spring:url>
    <spring:url value="/peliculas/edit" var="urlEditarPelicula"></spring:url>
    <spring:url value="/peliculas/delete" var="urlDeletePelicula"></spring:url>
    
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">  
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container" role="main">
    	<br>
      <h3>Listado de Peliculas</h3>
      
      <a href="${ urlCreatePelicula }" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
      
      <c:if test="${ message != null }">
      	<span class="alert alert-success">${ message }</span>
      	<br/><br/>
      </c:if>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Fecha Estreno</th>
                <th>Detalle</th>
                <th>Status</th>
                <th>Opciones</th>
            </tr>
            <c:forEach items="${ peliculas.content }" var="pelicula">
            	<tr>
	                <td>${ pelicula.titulo }</td>
	                <td>${ pelicula.genero }</td>
	                <td>${ pelicula.clasificacion }</td>
	                <td>${ pelicula.duracion }</td>
	                <td><fmt:formatDate value="${ pelicula.fechaEstreno }"/></td>
	                <td><span style="font-size: 12px">${ pelicula.detalle }</span></td>
	                <td><span class="badge
		                <c:choose>
		                	<c:when test="${ pelicula.status eq 'Activa'}">
		                		badge-success
		                	</c:when>
		                	<c:otherwise>
		                		badge-danger
		                	</c:otherwise>
		                </c:choose>
	                ">${ pelicula.status }</span></td>
	                <td>
	                    <a href="${ urlEditarPelicula }/${ pelicula.id }" class="btn btn-success btn-sm" role="button" title="Edit" >Editar</a>
	                    <a href="${ urlDeletePelicula }/${ pelicula.id }" 
	                    class="btn btn-danger btn-sm" role="button" title="Eliminar" 
	                    onclick = "if (! confirm('Está segur@?')) { return false; }">Eliminar</a>
	                </td>
	            </tr>
            </c:forEach>           
        </table>
        <nav aria-label="">
	        <ul class="pager"> 
	        	<c:if test="${ peliculas.number > 0 }">
	        		<li><a href="${urlPeliculas}/index?page=${peliculas.number - 1 }">Anterior</a></li>
	        	</c:if>
	        	<c:if test="${ peliculas.number < (pageSize - 1) }">
	        		<li><a href="${urlPeliculas}/index?page=${peliculas.number + 1 }">Siguiente</a></li>
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