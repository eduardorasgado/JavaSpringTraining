<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- para el csrf token de los formularios -->
<%@taglib uri="http://www.springframework.org/security/tags" prefix="secure"%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Creacion de imagenes del Banner</title>
      
      <spring:url value="/resources" var="urlPublic"></spring:url>
      <spring:url value="/banners/save" var="saveBanner"></spring:url>

      <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   </head>

   <body>

      <!-- Fixed navbar -->
      <jsp:include page="../includes/menu.jsp"></jsp:include>

	  <br/>
      <div class="container" role="main">

         <h3 class="blog-title"><span class="label label-success">Datos de la imagen</span></h3>
         
         <!-- name es el nombre del objeto en el request al que se analizaran
         sus mensajes -->
         <spring:hasBindErrors name="banner">
         	<div class="alert alert-danger" role="alert">
         		<p>Los siguientes errores se han encontrado:</p>
         		<ul>
         			<c:forEach items="${ errors.allErrors }" var="error">
         				<li>
         					<spring:message message="${ error }"></spring:message>
         				</li>
         			</c:forEach>
         		</ul>
         	</div>
         </spring:hasBindErrors>
         
         <form:form action="${ saveBanner }" method="post" enctype="multipart/form-data"
         			modelAttribute="banner">
         			
          <!-- spring security csrf token para poder mandar formularios de manera segura -->
	      <secure:csrfInput/>
         
          <c:if test="${ banner.nombreArchivo != null }">
          	<div class="row">
	           <div class="col-sm-3">
	             <div class="form-group">
	             <!-- campo imagen en caso de que querramos actualizar -->
	             <img alt="[IMAGEN DEL BANNER]" class="rounded" src="${ urlPublic }/images/${ banner.nombreArchivo }"
	             width="800" height="200" title="Banner Actual">
	             </div>
	           </div>
	          </div>
          </c:if>
         
         <div class="row">
         	<div class="col-sm-3">
	         	<div class="form-group">
	         		<label for="titulo">Titulo</label>
	         		
	         		<form:hidden path="id"/>
	         		
	         		<form:input type="text" class="form-control" path="titulo" id="titulo" required="required"/>
	         	</div>
         	</div>
         	
         	<div class="col-sm-3">
	         		<div class="form-group">
	         			<label for="archivoImagen">Imagen</label>
	         			<!-- esto va a ayudat a mandar un nombreArchivo vacio en lo que
	         			se obtiene el nombre en el server -->
	         			<form:hidden path="nombreArchivo"/>
	         			<c:choose>
	         				<c:when test="${ banner.nombreArchivo != null }">
	         					<input class="form-control-file" type="file" id="archivoImagen" name="archivoImagen" />
	         				</c:when>
	         				<c:otherwise>
	         					<input class="form-control-file" type="file" id="archivoImagen" name="archivoImagen" 
	         					required="required"/>
	         				</c:otherwise>
	         			</c:choose>
	         			<p class="help-block">Tamaño recomendado: 1140 x 250</p>	
	         		</div>
	         	</div>
         	
         	
         	
         	<div class="col-sm-3">
         		<div class="form-group">
         			<label for="status">Status</label>
         			<form:select class="form-control" id="status" path="status">
         				<form:option value="Activo">Activo</form:option>
         				<form:option value="Inactivo">Inactivo</form:option>
         			</form:select>
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