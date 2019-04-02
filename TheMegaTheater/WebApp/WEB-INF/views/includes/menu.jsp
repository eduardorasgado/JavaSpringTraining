<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/contacto/" var="urlContacto"></spring:url>
<spring:url value="/about" var="urlAcercaDe"></spring:url>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="${urlRoot}">TheMegaTheater</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExample07">
      <ul class="navbar-nav mr-auto">
      
      	<!-- ruta para todos -->
        <li class="nav-item active">
          <a class="nav-link" href="${urlRoot}">Inicio</a>
        </li>
        
        <!-- para los que no estan logueados -->
        <sec:authorize  access="isAnonymous()">
        	<li class="nav-item">
	          <a class="nav-link" href="${ urlAcercaDe }">Acerca de</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="${ urlRoot }admin/entrar">Login</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="${ urlContacto }">Contacto</a>
	        </li>
        </sec:authorize>
        
        <sec:authorize access="hasAnyAuthority('EDITOR', 'GERENTE')">
        	<li class="nav-item">
	          <a class="nav-link" href="${ urlRoot }peliculas/index?page=0">Peliculas</a>
	        </li>
	    </sec:authorize>
	    
	    <sec:authorize access="hasAnyAuthority('GERENTE')">
        	<li class="nav-item">
	          <a class="nav-link" href="${ urlRoot }banners/index">Banners</a>
	        </li>
        </sec:authorize>
	    
	    <sec:authorize access="hasAnyAuthority('EDITOR', 'GERENTE')">
	        <li class="nav-item">
	          <a class="nav-link" href="${ urlRoot }horarios/index?page=0">Horarios</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="${ urlRoot }noticias/index?page=0">Noticias</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="${ urlRoot }admin/logout">Logout</a>
	        </li>
        </sec:authorize>
        
      </ul>
      <form class="form-inline my-2 my-md-0">
        <input class="form-control" type="text" placeholder="Search" aria-label="Search">
      </form>
    </div>
  </div>
</nav>
