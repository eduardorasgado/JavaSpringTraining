<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">    
      <meta name="author" content="">
      <title>Formulario de Contacto</title>
      
      <spring:url value="/resources" var="urlPublic"></spring:url>
      <spring:url value="/" var="urlRoot"></spring:url>
      <spring:url value="/contacto/save" var="saveContacto"></spring:url>
      
      <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
      
   </head>

   <body>

      <!-- Fixed navbar -->
      <jsp:include page="includes/menu.jsp"></jsp:include>

      <div class="container" role="main">
      <br/>

         <h3 class="blog-title text-center"><span class="badge badge-success">Contacto</span></h3><br>
         
          <c:if test="${ message != null }">
          	<span class="alert alert-success">${ message }</span>
          	<br/><br/>
          </c:if>

         <form:form class="form-horizontal" action="${ saveContacto }" method="post" modelAttribute="instanciaContacto">
            <div class="form-group">
               <label for="nombre" class="col-sm-2 control-label">Nombre</label>
               <div class="col-sm-10">
                  <form:input type="text" class="form-control" id="nombre" path="nombre" placeholder="Nombre" required="required"/>
               </div>
            </div>
            <div class="form-group">
               <label for="email" class="col-sm-2 control-label">Email</label>
               <div class="col-sm-10">
                  <form:input type="email" class="form-control" path="email" id="email" placeholder="Email" required="required"/>
               </div>
            </div>

            <div class="form-group">
               <label for="genero" class="col-sm-2 control-label">Géneros Favoritos</label>
               <div class="col-sm-10">
                  <form:select id="genero" path="generos" multiple="multiple" class="form-control" items="${ generosPelicula }" />
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Tu experiencia en el sitio</label>
               <div class="col-sm-10">
                  <div class="form-check-inline">
                  	<label class="form-check-label">
                  	<form:radiobutton class="form-check-input" path="rating" value="1" />Muy Mala</label>
                  </div>
                  <div class="form-check-inline">
                  	<label class="form-check-label">
                  	<form:radiobutton class="form-check-input" path="rating" value="2" />Mala</label>
                  </div>
                  <div class="form-check-inline">
                  	<label class="form-check-label">
                  	<form:radiobutton class="form-check-input" path="rating" value="3" />Regular</label>
                  </div>
                  <div class="form-check-inline">
                  	<label class="form-check-label">
                  	<form:radiobutton class="form-check-input" path="rating" value="4" />Buena</label>
                  </div>
                  <div class="form-check-inline">
                  	<label class="form-check-label">
                  	<form:radiobutton class="form-check-input" path="rating" value="5" />Muy Buena</label>
                  </div>
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Te gustaría recibir notificaciones de:</label>
               <div class="col-sm-10">
               
               	  <!-- element: va a tomar cada input y label del checkboxes y lo va a meter en un div con class=etc etc -->
               	  <form:checkboxes items="${ tiposNotificaciones }" 
               	  element="div class='form-check-inline'" path="notificaciones"/>
               	  
               	  <!-- Se puede usar checkbox si se desea personalizar con clases de bootstrap 4 -->
               	  <!-- div class="form-check-inline">
               	  	<label class="form-check-label">
               	  	<form:checkbox class="form-check-input" path="notificaciones" value="Estrenos" />Estrenos</label>
               	  </div>
               	  <div class="form-check-inline">
               	  	<label class="form-check-label">
               	  	<form:checkbox class="form-check-input" path="notificaciones" value="Promociones" />Promociones</label>
               	  </div>
               	  <div class="form-check-inline">
               	  	<label class="form-check-label">
               	  	<form:checkbox class="form-check-input" path="notificaciones" value="Noticias" />Noticias</label>
               	  </div>
                  <div class="form-check-inline">
                  	<label class="form-check-label">
                  	<form:checkbox class="form-check-input" path="notificaciones" value="Preventas" />Preventas</label>
                  </div> -->
                  
               </div>
            </div>

            <div class="form-group">
               <label class="col-sm-2 control-label">Comentarios:</label>
               <div class="col-sm-10">
                  <form:textarea class="form-control" path="comentarios" id="comentarios" rows="5"></form:textarea>
               </div>
            </div>

            <div class="form-group">
               <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-success">Enviar</button>
               </div>
            </div>

         </form:form>

         <hr class="featurette-divider">

         <!-- FOOTER -->
         <jsp:include page="includes/footer.jsp"></jsp:include>

      </div> <!-- /container -->

      <!-- Bootstrap core JavaScript
      ================================================== -->
      <!-- Placed at the end of the document so the pages load faster -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
      <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 		
   </body>
</html>