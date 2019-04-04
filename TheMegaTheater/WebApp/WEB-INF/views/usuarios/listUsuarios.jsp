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
    
    <spring:url value="/usuarios" var="urlUsuarios"></spring:url>
    <spring:url value="/usuarios/create" var="urlCreateUsuario"></spring:url>
    <spring:url value="/peliculas/edit" var="urlEditarPelicula"></spring:url>
    <spring:url value="/peliculas/delete" var="urlDeletePelicula"></spring:url>
    
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">  
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container" role="main">
    	<br>
      <h3>Listado de Usuarios</h3>
      
      <a href="${ urlCreateUsuario }" class="btn btn-success" role="button" title="Nuevo Usuario" >Nuevo usuario</a><br><br>
      
      <c:if test="${ message != null }">
      	<span class="alert alert-success">${ message }</span>
      	<br/><br/>
      </c:if>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
            	<th>ID</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Username</th>
                <th>email</th>
                <th>Telefono</th>
                <th>Status</th>
                <th>Rol</th>
                <th>Opciones</th>
            </tr>
            <c:forEach items="${ usuarios }" var="pelicula">
            	<tr>
            		<td>${ usuario.id }</td>
	                <td>${ usuario.nombre }</td>
	                <td>${ usuario.apellidos }</td>
	                <td>${ usuario.username }</td>
	                <td>${ usuario.email }</td>
	                <td>${ usuario.telefono }</td>
	                <td>
		                <c:choose>
		                	<c:when test="${ usuario.status eq 1}">
		                		<span class="badge badge-success">Activa</span>
		                	</c:when>
		                	<c:otherwise>
		                		<span class="badge badge-danger">Inactiva</span>
		                	</c:otherwise>
		                </c:choose>
	                </td>
	                <td>AQUI VA EL ROL</td>
	                <td>
	                    <a href="${ urlEditarPelicula }/${ usuario.id }" class="btn btn-success btn-sm" role="button" title="Edit" >Editar</a>
	                    <a href="${ urlDeletePelicula }/${ usuario.id }" 
	                    class="btn btn-danger btn-sm" role="button" title="Eliminar" 
	                    onclick = "if (! confirm('Está segur@?')) { return false; }">Eliminar</a>
	                </td>
	            </tr>
            </c:forEach>           
        </table>
        <!-- paginador aqui -->
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