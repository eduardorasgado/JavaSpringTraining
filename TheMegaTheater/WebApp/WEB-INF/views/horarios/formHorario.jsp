<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="author" content="">
		<title>Creacion de Horarios</title>

		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		<link href="bootstrap/css/theme.css" rel="stylesheet">
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	</head>

	<body>

		<!-- Fixed navbar -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">My CineSite</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="#">Acerca</a></li>
						<li><a href="#">Login</a></li>            
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>

		<div class="container theme-showcase" role="main">

			<h3 class="blog-title"><span class="label label-success">Datos del Horario</span></h3>  

			<form>
				<div class="row">         
					<div class="col-sm-3">
						<div class="form-group">
							<label for="idPelicula" class="control-label">Pelicula</label>              
							<select id="idPelicula" name="idPelicula" class="form-control">
								<option value="1">Titulo Pelicula 1</option>
								<option value="2">Titulo Pelicula 2</option>
								<option value="3">Titulo Pelicula 3</option>                
							</select>             
						</div> 
					</div>
				</div>
				<div class="row"> 
					<div class="col-sm-3">
						<div class="form-group">
							<label for="fecha">Fecha</label>             
							<input type="text" class="form-control" name="fecha" id="fecha" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="hora">Hora</label>
							<input type="text" class="form-control" name="hora" id="hora" placeholder="Formato: HH:mm Ejemplo 21:30" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="sala" class="control-label">Sala</label>              
							<select id="sala" name="sala" class="form-control">
								<option value="Premium">Sala Premium</option>
								<option value="Sala 1">Sala 1</option>
								<option value="Sala 2">Sala 2</option>
								<option value="Sala 3">Sala 3</option>                
							</select>             
						</div> 
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="precio">Precio</label>
							<input type="text" class="form-control" name="precio" id="precio" required="required"/>
						</div>  
					</div>

				</div>

				<button type="submit" class="btn btn-danger" >Guardar</button>
			</form> 

			<hr class="featurette-divider">

			<!-- FOOTER -->
			<footer>        
				<p class="pull-right"><a href="#">Back to top</a></p>
				<p>&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
			</footer>

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="bootstrap/js/bootstrap.min.js"></script> 
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
      $(function () {
            $("#fecha").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
	</body>
</html>