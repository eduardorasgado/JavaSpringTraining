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
				<li>${ pelicula }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>