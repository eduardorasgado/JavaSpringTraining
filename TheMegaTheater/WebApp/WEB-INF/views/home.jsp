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
<style>
	body {
		width: 90vw;
		margin:auto;
	}
</style>
</head>
<body>
	
	<div id="header">
		<h1>The Great Theater</h1>
	</div>
	<div>
		<h2>Cartelera</h2>
		<p>Peliculas que tenemos en cartelera:</p>
		
		<ul>
			<!--  desplegando la lista del backend haciendo uso de JSTL -->
			<c:forEach items="${ peliculas }" var="pelicula">
				<li>${ pelicula.titulo }</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<h2>Detalles de la cartelera actual</h2>
		<table border="1"style ="border-collapse: collapse; width: 100%">
			<thead>
				 <tr>
				 	<th>Id</th>
				 	<th>Titulo</th>
				 	<th>Duración</th>
				 	<th>Clasificación</th>
				 	<th>Género</th>
				 	<th>Fecha de estreno</th>
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
						<td>${ pelicula.fechaEstreno }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>