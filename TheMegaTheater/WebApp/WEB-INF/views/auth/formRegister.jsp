<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="author" content="">
		<title>Creacion de Usuarios</title>
		
		<spring:url value="/resources" var="urlPublic"></spring:url>
		<spring:url value="/usuarios/create" var="urlSaveUsuario"></spring:url>
		
		<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>

	<body>

		<!-- Fixed navbar -->
		<jsp:include page="../includes/menu.jsp"></jsp:include>
		
		<div class="container" role="main">
		<br/>

			<h3 class="blog-title"><span class="badge badge-success">Datos del Usuario</span></h3>
			
			<c:if test="${ error != null }">
				<br>
				<span class="alert alert-danger">${ error }</span>
				<br>
				<br>
			</c:if>
			
			<spring:hasBindErrors name="usuario">
			  	<!-- aqui va el contenido de lo que debe mostrarse, se puede iterar en el error -->
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
		    </spring:hasBindErrors>

			<form:form action="${ urlSaveUsuario }" method="post" modelAttribute="usuario">
			
				<sec:csrfInput/>
				
				<form:hidden path="id"/>
				<form:hidden path="perfil.id"/>  
			
				<div class="row">         
					<div class="col-sm-3">
						<div class="form-group">
							<label for="perfil" class="">Perfil</label>
							<form:select id="perfil" path="perfil.perfil" class="form-control" items="${ perfiles }"/>
						</div> 
					</div>
				</div>	
				
				<div class="row"> 	
					<div class="col-sm-3">
						<div class="form-group">
							<label for="username">Username</label>           
							<form:input type="text" class="form-control" path="username" id="username" required="required"/>
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="nombre">Nombre</label>             
							<form:input type="text" class="form-control" path="nombre" id="nombre" required="required"/>
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="apellidos">Apellidos</label>             
							<form:input type="text" class="form-control" path="apellidos" id="apellidos" required="required"/>
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="password">Contraseña</label>             
							<form:input type="password" class="form-control" path="password" id="password" required="required"/>
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="passwordProve">Repetir contraseña</label>             
							<input type="password" class="form-control" name="passwordProve" id="passwordProve" required="required"/>
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="email">Email</label>
							<form:input type="text" class="form-control" path="email" id="email" placeholder="Correo electrónico" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="telefono">Teléfono</label>
							<form:input type="text" class="form-control" path="telefono" id="telefono" required="required"/>
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
		<script src="bootstrap/js/bootstrap.min.js"></script>    
	</body>
</html>