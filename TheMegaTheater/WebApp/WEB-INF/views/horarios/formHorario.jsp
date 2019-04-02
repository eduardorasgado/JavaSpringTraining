<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- para el csrf token de los formularios -->
<%@taglib uri="http://www.springframework.org/security/tags" prefix="secure"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="author" content="">
		<title>Creacion de Horarios</title>
		<spring:url value="/resources" var="urlPublic"></spring:url>
		<spring:url value="/horarios/save" var="urlHorarioSave"></spring:url>

		<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	</head>

	<body>

		<!-- Fixed navbar -->
		<jsp:include page="../includes/menu.jsp"></jsp:include>

		<div class="container" role="main">
			<br/>

			<h3 class="blog-title"><span class="badge badge-success">Datos del Horario</span></h3>
			
			<spring:hasBindErrors name="horario">
				<div class="alert alert-danger" role="alert">
			  		<p>Se han encontrado los siguientes errores:</p>
			  		<ul>
			  			<c:forEach items="${ errors.allErrors }" var="error">
			  				<li>
			  					<spring:message message="${ error }"></spring:message>
			  				</li>
			  			</c:forEach>
			  		</ul>
			  	</div>
			  	<br/><br/>
			</spring:hasBindErrors>  

			<form:form method="post" action="${ urlHorarioSave }" modelAttribute="instanciaHorario">
				
				<!-- spring security csrf token para poder mandar formularios de manera segura -->
	        	<secure:csrfInput/>
				
				<form:hidden path="id"/>
				<div class="row">         
					<div class="col-sm-3">
						<div class="form-group">
						<!-- Observamos que para que se guarde bien la referencia a la pellicula
						le debemos decir en el path donde va a guardar el itemValue en la nueva instancia
						de pelicula que se va a crear -->
							<label for="idPelicula" class="control-label">Pelicula</label>              							
							<form:select class="form-control" path="pelicula.id" items="${ peliculas }" 
							itemValue="id" itemLabel="titulo"></form:select>      
						</div> 
					</div>
				</div>
				<div class="row"> 
					<div class="col-sm-3">
						<div class="form-group">
							<label for="fecha">Fecha</label>             
							<form:input type="text" class="form-control" path="fecha" id="fecha" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="hora">Hora</label>
							<form:input type="text" class="form-control" path="hora" id="hora" placeholder="Formato: HH:mm Ejemplo 21:30" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="sala" class="control-label">Sala</label>              
							<form:select id="sala" path="sala" class="form-control" items="${ horarioSalas }">
							</form:select>             
						</div> 
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="precio">Precio</label>
							<form:input type="number" class="form-control" path="precio" id="precio" required="required"/>
						</div>  
					</div>

				</div>

				<button type="submit" class="btn btn-danger" >Guardar</button>
			</form:form> 

			<hr class="featurette-divider">

			<!-- FOOTER -->
			<jsp:include page="../includes/footer.jsp"></jsp:include>

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
      $(function () {
            $("#fecha").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
	</body>
</html>