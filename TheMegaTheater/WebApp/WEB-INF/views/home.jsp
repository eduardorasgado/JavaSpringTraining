<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Para usar JSTL en cada vista debemos de importar jstl en el jsp.
 Importamos el core de JSTL-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<style>
	body {
		padding-top: 20px;
		width: 90vw;
		margin:auto;
	}
	li {
		/*Rmover el punto de las listas no ordenadas*/
		list-style-type: none;
	}
</style>
</head>
<body>
	<div class="jumbotron">
		<div id="header">
			<h1>The Great Theater</h1>
		</div>
		<div>
			<h2>Cartelera</h2>
			<p>Peliculas que tenemos en cartelera:</p>
		
			<ul>
				<!--  desplegando la lista del backend haciendo uso de JSTL -->
				<c:forEach items="${ peliculas }" var="pelicula">
					<li><i class="fas fa-film"></i> ${ pelicula.titulo }</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div>
		<div class="card">
			<div class="card-header">
				<h2>Detalles de la cartelera actual</h2>
			</div>
			<div class="card-body">
				<table class="table table-striped table-hover">
			<thead class="table-dark">
				 <tr>
				 	<th scope="col">Id</th>
				 	<th scope="col">Titulo</th>
				 	<th scope="col">Duración</th>
				 	<th scope="col">Clasificación</th>
				 	<th scope="col">Género</th>
				 	<th scope="col">Imagen</th>
				 	<th scope="col">Fecha de estreno</th>
				 	<th scope="col">Status</th>
				 </tr>
			</thead>
			<tbody>
				<c:forEach items="${ peliculas }" var="pelicula">
					<tr>
						<td>${ pelicula.id }</td>
						<td>${ pelicula.titulo }</td>
						<td>${ pelicula.duracion } min</td>
						<td>${ pelicula.clasificacion }</td>
						<td>${ pelicula.genero }</td>
						<td>${ pelicula.imagen }</td>
						<td>${ pelicula.fechaEstreno }</td>
						<td>${ pelicula.status }</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
			</div>
		</div>
		
		
	</div>
	<script defer src="https://use.fontawesome.com/releases/v5.7.1/js/all.js" integrity="sha384-eVEQC9zshBn0rFj4+TU78eNA19HMNigMviK/PU/FFjLXqa/GKPgX58rvt5Z8PLs7" crossorigin="anonymous"></script>
</body>
</html>