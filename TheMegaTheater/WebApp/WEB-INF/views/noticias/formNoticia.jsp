<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Para usar JSTL en cada vista debemos de importar jstl en el jsp.
 Importamos el core de JSTL-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Para poder aplicar formatos: i18n -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Para poder ocupar los recursos(resources) a traves de los tags de spring -->
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
    <title>Creacion de Noticias</title>    
    
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/noticias/save" var="urlNoticiasForm"></spring:url>
    
    <link href="${ urlPublic }/bootstrap/css/bootstrap.min.css" rel="stylesheet">   
	
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

	<br/>
    <div class="container" role="main">
      <h3 class="blog-title"><span class="badge badge-success">Datos de la Noticia</span></h3>

	  <form:form action="${ urlNoticiasForm }" method="post" modelAttribute="noticia">
	  	<div class="row">
	  	
	  		<form:hidden path="id"/>
	  		
	  		<div class="col-sm-6">
              <div class="form-group">
              	<label for="titulo">Titulo</label>             
              	<form:input type="text" class="form-control" path="titulo" id="titulo" required="required"/>
              </div>
            </div>
            
            <div class="col-sm-3">
              <div class="form-group">
                <label for="status">Status</label>             
                <form:select id="status" path="status" class="form-control">
                  <form:option value="Activa">Activa</form:option>
                  <form:option value="Inactiva">Inactiva</form:option>              
                </form:select>  
              </div>
          </div>
        </div>
          
        <div class="row"> 
          <div class="col-sm-12">
            <div class="form-group">
              <label for="detalle">Detalles</label>             
              <form:textarea class="form-control" path="detalle" id="detalle" rows="10"></form:textarea>
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
    <script src="${ urlPublic }/bootstrap/js/bootstrap.min.js"></script> 
    <script src="${ urlPublic }/tinymce/tinymce.min.js"></script>
    <script>
      tinymce.init({
          selector: '#detalle',
          plugins: "textcolor, table lists code",
          toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
      });
    </script>
  </body>
</html>
