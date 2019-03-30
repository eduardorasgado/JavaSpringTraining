<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">    
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
	    <title>Listado de Noticias</title>
	    
	    <spring:url value="/noticias" var="urlNoticias"></spring:url>
	    <spring:url value="/resources" var="urlPublic" ></spring:url>
	    <spring:url value="/noticias/create" var="urlCreateNoticia"></spring:url>
	    <spring:url value="/noticias/edit" var="urlEditarNoticia"></spring:url>
	    <spring:url value="/noticias/delete" var="urlEliminarNoticia"></spring:url>
	    
	    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
	</head>
	
	<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container" role="main">
		<br/>
		<h3>Listado de Noticias</h3>
		
		<a href="${ urlCreateNoticia }" 
		class="btn btn-success" role="button" title="Nueva Noticia">Nueva</a>
		
		<c:if test="${ message != null }">
			<span class="alert alert-success">${ message }</span>
		</c:if>
		
		<c:if test="${ error != null }">
			<span class="alert alert-danger">${ error }</span>
		</c:if>
		
		<br/> <br/>
		
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr>
					<th>Titulo</th>
					<th>Fecha</th>
					<th>Detalle</th>
					<th>Status</th>
					<th>Opciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ noticias.content }" var="noticia">
					<tr>
						<td>${ noticia.titulo }</td>
						<td><fmt:formatDate value="${ noticia.fechaPublicacion }"/></td>
						<td style="font-size:12px">${ noticia.detalle }</td>
						<td>
						<c:choose>
							<c:when test="${ noticia.status == 'Activa' }">
								<span class="badge badge-success">
									${ noticia.status }
								</span>
							</c:when>
							<c:otherwise>
								<span class="badge badge-danger">
									${ noticia.status }
								</span>
							</c:otherwise>
						</c:choose>
						</td>
						<td>
							<a href="${ urlEditarNoticia }/${ noticia.id }" class="btn btn-success btn-sm" role="button">Editar</a>
							<a href="${ urlEliminarNoticia }/${ noticia.id }" class="btn btn-danger btn-sm" role="button"
								onclick="if (! confirm('Está segur@?')) { return false; }">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="">
	        <ul class="pager"> 
	        	<c:if test="${ noticias.number > 0 }">
	        		<li><a href="${urlNoticias}/index?page=${noticias.number - 1 }">Anterior</a></li>
	        	</c:if>
	        	
	        	<span>pagina: ${ noticias.number + 1 }</span>
	        	
	        	<c:if test="${ noticias.number < (pageSize - 1) }">
	        		<li><a href="${urlNoticias}/index?page=${noticias.number + 1 }">Siguiente</a></li>
	        	</c:if>
	        	
	        </ul>
        </nav>
		</div>
		
		<jsp:include page="../includes/footer.jsp"></jsp:include>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script>    
	</body>
</html>