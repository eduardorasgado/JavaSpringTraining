<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Creacion de Peliculas</title>
    
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/peliculas/save" var="urlPeliculaForm"></spring:url>

    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  </head>

  <body>
    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container" role="main">

	<br/>
      <div class="row pb-2 mt-4 mb-2 border-bottom">
	<h3 class="blog-title"><span class="label label-success">Datos de la Pelicula</span></h3>
      </div>

	  <!-- Podemos mostrar los errores del binding en el frotend con la ayuda de el tag
	  hasBindErrors -->
	  <spring:hasBindErrors name="pelicula">
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
	  
      <form action="${ urlPeliculaForm }" method="post" enctype="multipart/form-data">
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="titulo">Título</label>
              <input type="text" class="form-control" name="titulo" id="titulo" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="duracion">Duracion</label>
              <input type="number" class="form-control" name="duracion" id="duracion" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="clasificacion" class="control-label">Clasificacion</label>              
              <select id="clasificacion" name="clasificacion" class="form-control">
                <option value="A">Clasificacion A</option>
                <option value="B">Clasificacion B</option>
                <option value="C">Clasificacion C</option>                  
              </select>             
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="genero" class="control-label">Genero</label>              
              <select id="genero" name="genero" class="form-control">
                <option value="Accion">Accion</option>
                <option value="Aventura">Aventura </option>
                <option value="Clasicas">Clasicas</option>                  
                <option value="Comedia Romantica">Comedia Romantica</option>                  
                <option value="Drama">Drama</option>                  
                <option value="Terror">Terror</option>                  
                <option value="Infantil">Infantil</option>                  
                <option value="Accion y Aventura">Accion y Aventura</option>                  
                <option value="Romantica">Romantica</option>                  
              </select>             
            </div> 
          </div>         
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="status" class="control-label">Status</label>              
              <select id="status" name="status" class="form-control">
                <option value="Activa">Activa</option>
                <option value="Inactiva">Inactiva</option>               
              </select>             
            </div> 
          </div>     
          <div class="col-sm-3">
            <div class="form-group">
              <label for="fechaEstreno">Fecha Estreno</label>             
              <input type="text" class="form-control" name="fechaEstreno" id="fechaEstreno" required="required" />
            </div>  
          </div>

          <div class="col-sm-3">
            <div class="form-group">
              <label for="imagenArchivo">Imagen</label>
              <input class="form-control-file" type="file" id="imagenArchivo" name="imagenArchivo" />
              <p class="help-block">Imagen de la pelicula</p>
            </div> 
          </div>
        </div>

        <!--  
        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="director">Director</label>
              <input type="text" class="form-control" name="director" id="director" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="actores">Actores</label>
              <input type="text" class="form-control" name="actores" id="actores" required="required" />
            </div>  
          </div>

          <div class="col-sm-6">
            <div class="form-group">
              <label for="trailer">URL del Trailer (Youtube)</label>
              <input type="text" class="form-control" name="trailer" id="trailer" placeholder="URL completa del video de YOUTUBE" required="required" />
            </div>  
          </div> 
        </div> 

        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
              <textarea class="form-control" rows="5" name="sinopsis" id="sinopsis"></textarea>
            </div> 
          </div> 
        </div>
        -->
        
        <button type="submit" class="btn btn-danger" >Guardar</button>
      </form> 

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
          $("#fechaEstreno").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
  </body>
</html>