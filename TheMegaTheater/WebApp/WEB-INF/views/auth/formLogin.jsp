<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Entrar al sistema</title>

		<spring:url value="/resources" var="urlPublic"></spring:url>
		<spring:url value="/" var="urlRoot"></spring:url>

		<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		<link href="${ urlPublic }bootstrap/css/theme.css" rel="stylesheet">

	</head>

	<body>

		<!-- Fixed navbar -->
		<jsp:include page="../includes/menu.jsp"></jsp:include>

		<div class="container" role="main">
			<hr class="featurette-divider">
			<img src="${ urlPublic }/images/login.png" width="136" height="136" class="">
			
			<!-- la accion post del inicio de sesion corresponde a la ruta /login dada la aplicacion y spring security -->
			<form action="${ urlRoot }login" method="post">
			
				<!-- otra forma de trabajar el token de spring security -->
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			        
				<h3 class="">The Mega Theater | Administracion</h3>        
				<div class="form-group">
					<label for="username" class="sr-only">Usuario</label>
					<div class="col-sm-6">						
						<input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="sr-only">Contraseña</label>
					<div class="col-sm-6">				
						<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-md-3">
						<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
					</div>
				</div>
			</form>

		</div> <!-- /container -->
		
		<jsp:include page="../includes/footer.jsp"></jsp:include>
		
		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="${ urlPublic }/bootstrap/js/bootstrap.min.js" ></script>
	</body>
</html>