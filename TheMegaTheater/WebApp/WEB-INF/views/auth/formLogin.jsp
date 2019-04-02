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

		<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		<link href="${ urlPublic }bootstrap/css/theme.css" rel="stylesheet">

	</head>

	<body>

		<!-- Fixed navbar -->
		<jsp:include page="../includes/menu.jsp"></jsp:include>

		<div class="container" role="main">
			<hr class="featurette-divider">
			<img src="${ urlPublic }/images/login.png" width="136" height="136" class="">
			<form class="" action="j_security_check" method="post">        
				<h3 class="form-signin-heading">The Mega Theater | Administracion</h3>        
				<label for="username" class="sr-only">Usuario</label>
				<input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
				<label for="password" class="sr-only">Contraseña</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
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