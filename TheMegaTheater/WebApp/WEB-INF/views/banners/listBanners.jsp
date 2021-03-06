<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    
    <title>Listado de imagenes del banner</title>
    
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/banners/create" var="urlFormNewBanner"></spring:url>
    <spring:url value="/banners/edit" var="urlEditBanner"></spring:url>
    <spring:url value="/banners/delete" var="urlDeleteBanner"></spring:url>
    <spring:url value="/banners" var="urlBanners"></spring:url>
    
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

	<br>
    <div class="container" role="main">

      <h3>Listado de imagenes del Banner</h3>
      
      <a href="${urlFormNewBanner}" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>

	  <c:if test="${ message != null }">
	  	<span class="alert alert-success">
	  		${message}
	  	</span><br/><br/>
	  </c:if>
	  
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>                           
                <th>Fecha Publicacion</th>              
                <th>Nombre Archivo</th>
                <th>Estatus</th>
                <th>Opciones</th>              
            </tr>
            <c:forEach items="${ listaBanners.content }" var="banner">
            	<tr>
	                <td>${ banner.id }</td>
	                <td>${ banner.titulo }</td>
	                 <td><fmt:formatDate value="${ banner.fechaPub }"/> </td>    
	                <td>${ banner.nombreArchivo }</td>                         
	                <td><span class="label label-success">${ banner.status }</span></td>
	                <td>
	                    <a href="${ urlEditBanner }/${ banner.id }" class="btn btn-success btn-sm" role="button" title="Edit" >Editar</a>
	                    <a href="${ urlDeleteBanner }/${ banner.id }" class="btn btn-danger btn-sm" 
	                    onclick = "if (! confirm('Está segur@?')) { return false; }" role="button" title="Eliminar" >Eliminar</a>
	                </td>
	            </tr>	
            </c:forEach>
                     
        </table>
        <nav aria-label="">
	        <ul class="pager"> 
	        	<c:if test="${ listaBanners.number > 0 }">
	        		<li><a href="${urlBanners}/index?page=${listaBanners.number - 1 }">Anterior</a></li>
	        	</c:if>
	        	
	        	<span>pagina: ${ listaBanners.number + 1 }</span>
	        	
	        	<c:if test="${ listaBanners.number < (pageSize - 1) }">
	        		<li><a href="${urlBanners}/index?page=${listaBanners.number + 1 }">Siguiente</a></li>
	        	</c:if>
	        	
	        </ul>
        </nav>
      </div>  
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>