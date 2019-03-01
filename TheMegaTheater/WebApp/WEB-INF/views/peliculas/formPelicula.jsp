<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
      
      <!-- form tag library de spring: cambiamos name por path -->
      <form:form action="${ urlPeliculaForm }" method="post" enctype="multipart/form-data" modelAttribute="pelicula">
      	<div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="titulo">Título</label>
              <form:input type="text" class="form-control" path="titulo" id="titulo" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="duracion">Duracion</label>
              <form:input type="number" class="form-control" path="duracion" id="duracion" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="clasificacion" class="control-label">Clasificacion</label>              
              <form:select id="clasificacion" path="clasificacion" class="form-control">
                <form:option value="A">Clasificacion A</form:option>
                <form:option value="B">Clasificacion B</form:option>
                <form:option value="C">Clasificacion C</form:option>                  
              </form:select>             
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="genero" class="control-label">Genero</label>              
              <form:select id="genero" path="genero" class="form-control">
                <form:option value="Accion">Accion</form:option>
                <form:option value="Aventura">Aventura </form:option>
                <form:option value="Clasicas">Clasicas</form:option>                  
                <form:option value="Comedia Romantica">Comedia Romantica</form:option>                  
                <form:option value="Drama">Drama</form:option>                  
                <form:option value="Terror">Terror</form:option>                  
                <form:option value="Infantil">Infantil</form:option>                  
                <form:option value="Accion y Aventura">Accion y Aventura</form:option>                  
                <form:option value="Romantica">Romantica</form:option>                  
              </form:select>             
            </div> 
          </div>         
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="status" class="control-label">Status</label>              
              <form:select id="status" path="status" class="form-control">
                <form:option value="Activa">Activa</form:option>
                <form:option value="Inactiva">Inactiva</form:option>               
              </form:select>             
            </div> 
          </div>     
          <div class="col-sm-3">
            <div class="form-group">
              <label for="fechaEstreno">Fecha Estreno</label>             
              <form:input type="text" class="form-control" path="fechaEstreno" id="fechaEstreno" required="required" />
            </div>  
          </div>

		  <!-- No se le agrega porque no se quiere agregar directamente al modelo
		  debido a que se maneja desde el controller como multipart -->
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
          $("#fechaEstreno").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
  </body>
</html>