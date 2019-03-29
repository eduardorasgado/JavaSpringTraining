<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	    
	    <spring:url value="/resources" var="urlPublic" ></spring:url>
	    <spring:url value="/noticias/create" var="urlCreateNoticia"></spring:url>
	    
	    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
	</head>
	
	<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container" role="main">
		<br/>
		<h3>Listado de Noticias</h3>
		
		<a href="${ urlCreateNoticia }" 
		class="btn btn-success" role="button" title="Nueva Noticia">Nueva</a>
		<br/> <br/>
		
		<c:forEach items="${ noticias.content }" var="noticia">
			<p>${ noticia.titulo }</p>		
		</c:forEach>
		
		<jsp:include page="../includes/footer.jsp"></jsp:include>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script>    
	</body>
</html>