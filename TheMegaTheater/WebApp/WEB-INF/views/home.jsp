<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Para usar JSTL en cada vista debemos de importar jstl en el jsp.
 Importamos el core de JSTL-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Para poder aplicar formatos: i18n -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Para poder ocupar los recursos(resources) a traves de los tags de spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="secure" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>TheMegaTheater | Bienvenido</title>
    
	
	<!-- Incluyendo la carpeta resources de archivos estaticos
	a traves de un tag de spring -->
	<spring:url value="/resources" var="urlPublic"></spring:url>
	<spring:url value="/" var="urlRoot"></spring:url>
	
	<link rel="stylesheet" href="${ urlPublic }/bootstrap/css/bootstrap.min.css">

  </head>

  <body>
  <!-- navbar -->
  <jsp:include page="includes/menu.jsp"></jsp:include>

	<br/>
    <div class="container" role="main">

	
      <!-- Carousel
    ================================================== -->
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        
        <ol class="carousel-indicators">
        	<c:forEach items="${ sliderCounter }" var="counter">
        		<li data-target="#myCarousel" data-slide-to="${ counter }" 
        			<c:if test="${ counter == 0 }">
        				class="active"
        			</c:if>
        		>
        		</li>
        	</c:forEach>	
        </ol>
        
        <!-- Image Size 1140 x 250 -->
        <div class="carousel-inner" role="listbox">
          <c:forEach items="${ listaBanners }" var="banner">
          	<c:choose>
          		<c:when test="${ banner.id eq bannerinit }">
          			<div class="carousel-item active">
          				<img src="${ urlPublic }/images/${ banner.nombreArchivo }" 
           	  			alt="${ banner.nombreArchivo }" title="${ banner.titulo }" >
           	  		</div>
          		</c:when>
          		<c:otherwise>
          			<div class="carousel-item">
          				<img src="${ urlPublic }/images/${ banner.nombreArchivo }" 
           	  			alt="${ banner.nombreArchivo }" title="${ banner.titulo }" >
           	  		</div>
          		</c:otherwise>
          	</c:choose>
          </c:forEach>
        </div>
        <a class="left carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div><!-- /.carousel -->

      <div class="row pb-2 mt-4 mb-2 border-bottom">          
        <div class="col-md-12">         
          <h2 class="text text-center"><span class="badge badge-success">
          DISPONIBLES 
          <c:choose>
          	<c:when test="${ today == fechaBusqueda }">HOY</c:when>
          	<c:otherwise>${ fechaBusqueda }</c:otherwise>
          </c:choose>
          </span></h2>
          
        </div>
      </div>

      <!-- Marketing messaging -->
      <div class="container">
      <c:if test="${ error != null }">
          	<span class="alert alert-success">${ error }</span>
          	<br/><br/>
          </c:if>

        <div class="row">
		  
          <c:forEach items="${ peliculasToday }" var="peliculaHoy">
          	<div class="col-xs-12 col-sm-6 col-md-3">
		            <img class="rounded" src="${ urlPublic }/images/${ peliculaHoy.imagen }" alt="Generic placeholder image" width="150" height="200">
		            <h5>${ peliculaHoy.titulo }</h5>
		            <h5>
		              <span class="badge badge-secondary">${ peliculaHoy.clasificacion }</span>
		              <span class="badge badge-secondary">${ peliculaHoy.duracion } min</span>
		              <span class="badge badge-secondary">${ peliculaHoy.genero }</span>
		            </h5>         
		            <p><a class="btn btn-sm btn-primary" href="detail/${ peliculaHoy.id }/${ fechaBusqueda }" role="button">Consulta Horarios &raquo;</a></p>
	          </div>
          </c:forEach>

        </div>
        
        <div class="row pb-2 mt-4 mb-2 border-bottom">          
	        <div class="col-md-12">         
	          <h2 class="text text-center"><span class="badge badge-success">EN CARTELERA</span></h2>
	          
	          <form class="form-inline" action="${ urlRoot }search" method="post">
	          	
	          	<!-- spring security csrf token para poder mandar formularios de manera segura -->
	          	<secure:csrfInput/>
	          	
	            <div class="form-group mx-sm-3 mb-2">
	              <label class="" for="fecha">Fecha: </label>
	              <select id="fecha" name="fecha" class="form-control">
	                <c:forEach items="${ listaFechas }" var="fecha">
	                	<option value="${ fecha }"
	                	<c:choose>
	                		<c:when test="${ fecha == fechaBusqueda }">
	                			selected
	                		</c:when>
	                	</c:choose>
	                	>${ fecha }</option>
	                </c:forEach>                
	              </select>
	            </div>            
	            <button type="submit" class="btn btn-primary mb-2">Filtrar</button>
	          </form>
	        </div>
        </div>
        
        <div class="container">
        	<div class="row">
        		<c:forEach items="${ peliculas }" var="pelicula">
		          	<c:if test="${ pelicula.status == 'Activa' }">
		          		<div class="col-xs-12 col-sm-6 col-md-3">
				            <img class="rounded" src="${ urlPublic }/images/${ pelicula.imagen }" alt="Generic placeholder image" width="150" height="200">
				            <h5>${ pelicula.titulo }</h5>
				            <h5>
				              <span class="badge badge-secondary">${ pelicula.clasificacion }</span>
				              <span class="badge badge-secondary">${ pelicula.duracion } min</span>
				              <span class="badge badge-secondary">${ pelicula.genero }</span>
				            </h5>         
				            <p><a class="btn btn-sm btn-primary" href="detail/${ pelicula.id }/${ fechaBusqueda }" role="button">Consulta Horarios &raquo;</a></p>
			          </div>
		          	</c:if>
	          </c:forEach>
        	</div>
        </div>

        <div class="pb-2 mt-4 mb-2 border-bottom">
          <h2 class="text text-center"><span class="badge badge-success">Noticias y novedades</span></h2>
        </div>

        <div class="row">

          <div class="col-sm-12 blog-main">

            <c:forEach  items="${ noticias }" var="noticia">
            	<div class="blog-post">              
	              <h3 class="blog-post-title">${ noticia.titulo }</h3>
	
	              <p class="blog-post-meta"><span class="badge badge-danger">
	              	Publicado: <fmt:formatDate value="${ noticia.fechaPublicacion }"/>
	              	</span>
	              </p>             
	              ${ noticia.detalle }
	
	              <hr class="featurette-divider">
	            </div>
            </c:forEach>

          </div>
        </div>

      </div>

     <jsp:include page="includes/footer.jsp"></jsp:include>
     
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 
  </body>
</html>
