<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- Para usar JSTL en cada vista debemos de importar jstl en el jsp.
 Importamos el core de JSTL-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Para poder aplicar formatos: i18n -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Para poder ocupar los recursos(resources) a traves de los tags de spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Detalles de la pelicula</title>
		
		<spring:url value="/resources" var="urlPublic"></spring:url>
		<spring:url value="/" var="urlRoot"></spring:url>
		
		<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">
	</head>

	<body>
	
		<jsp:include page="includes/menu.jsp"></jsp:include>		

		<div class="container" role="main">
			<br/>
			<!-- Marketing messaging -->
			<div class="container">

				<div class="row pb-2 mt-4 mb-2 border-bottom">
					<h2>${ pelicula.titulo }</h2>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<p class="text-center">
							<img class="rounded" src="${ urlPublic }/images/${ pelicula.imagen }" alt="Generic placeholder image" width="155" height="220">            
						</p>
					</div>
					<div class="col-sm-9">
						<div class="card card-secondary">
							<div class="card-header">
								<h3 class="card-title">DETALLES</h3>
							</div>
							<div class="card-body">                           
								<p>
									Título Original : ${pelicula.titulo} <br>
									Actores : ${ pelicula.detalle.actores } <br>
									Director: ${ pelicula.detalle.director }<br>                  
									Clasificación: ${ pelicula.clasificacion } <br>
									Duración: ${ pelicula.duracion } minutos <br>
									Género: ${ pelicula.genero } <br>                  
									Fecha Estreno: <fmt:formatDate value="${ pelicula.fechaEstreno }"/>                  
								</p> 

							</div>
						</div>                          
					</div>
				</div>

				<div class="card card-secondary">
					<div class="card-header">
						<h3 class="card-title"><span class="badge badge-success">
							${ fechaBusqueda }
						</span></h3>
					</div>
					<div class="card-body">
						<table class="table table-striped">
							<thead>
								<tr>                  
									<th>Hora</th>
									<th>Sala</th>                                  
									<th>Precio</th>                                  
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ horarios }" var="horario">
									<tr>                 
										<td>${ horario.hora }</td>
										<td>${ horario.sala }</td>  
										<td>$${ horario.precio }</td>  
									</tr>    
								</c:forEach>								       
							</tbody>           
						</table>
					</div>
				</div>


				<div class="row">
					<div class="col-sm-7">
						<div class="card card-secondary">
							<div class="card-header">
								<h3 class="card-title">Trailer</h3>
							</div>
							<div class="card-body">
								<iframe width="100%" height="315" 
												src="${pelicula.detalle.trailer}" >                          
								</iframe>
							</div>
						</div>           
					</div> 
					<div class="col-sm-5">
						<div class="card card-secondary">
							<div class="card-header">
								<h3 class="card-title">SINOPSIS</h3>
							</div>
							<div class="card-body">
								<p>${ pelicula.detalle.sinopsis }</p>
							</div>
						</div>                          
					</div>
				</div>

			</div><!-- /.container -->

			<hr class="featurette-divider">

			<!-- FOOTER -->
			<jsp:include page="includes/footer.jsp"></jsp:include>

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="bootstrap/js/bootstrap.min.js"></script> 
	</body>
</html>
