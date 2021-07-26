<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<nav class="navbar navbar-expand navbar-light bg-light fixed-top justify-content-between">
	  <a class="navbar-brand" href="/app/home">UyTube</a>
	  <form class="form-inline my-lg-0" action="/app/buscar" method="get">
		  <select name="opcion" class="form-control mr-2">
		 	<option value="usuarios">Usuarios</option>
		  	<option value="videos">Videos</option>
		  	<option value="listas">Listas</option>
	 	  </select>
	      <input class="form-control mr-sm-2" name="q" type="search" placeholder="Buscar" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
	    </form>
	      <div class="navbar-nav dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          <% DataUsuario data = (DataUsuario) request.getAttribute("usrLog"); %>
	          <% if (data != null) { %>
	          <span><c:out value = "${usrLog.getNickname()}"/></span>
	          <img id="fotoThumbnail" src="/app/media/imagenes/defecto.gif">
	          <% } else { %>
	          <img id="fotoThumbnail" src="/app/media/imagenes/defecto.gif">
	          <% } %>
	        </a>
	        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
	          <% if (data != null) { %>
	          <a class="dropdown-item" href="/app/perfil?usuario=<%= data.getNickname() %>">Perfil</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="/app/logout">Logout</a>
	          <% } else { %>
	          <a class="dropdown-item" href="/app/login">Login</a>
	          <a class="dropdown-item" href="/app/sign-up">Sign Up</a>
	          <% } %>
	        </div>
	      </div>
	</nav>

<div class="min-vh-100 container" id="body-contenedor">
	<div class="row">
		<div class="col-md-3">
			<div class="list-group mb-2">
				<div class="list-group-item bg-light">USUARIO</div>
				<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/cambiar-perfil">Modificar Usuario</a>
				<div class="list-group-item bg-light">VIDEOS</div>
				<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/crear-video">Crear Video</a>
				<div class="list-group-item bg-light">LISTAS</div>
				<div class="dropdown">
					<a class=" border-0 bg-light dropdown-toggle list-group-item-action list-group-item" data-toggle="dropdown" href="#">Crear Lista</a>
					<div class="dropdown-menu dropdown-menu-right" id="crearListaMenu" aria-labelledby="dropdownMenuButton">
						<div class="container">
							<div class=" alert-danger" id="alertaCrearLista"></div>
							<form class="" id="crearListaForm" action="/app/crear-lista" method="post">
								<div class="form-group">
									<label for="nombreLista">Nombre:</label>
									<input type="text" class="form-control" id="nombreLista" placeholder="Nombre" name="nombreLista" required></input>
								</div>
								<div class="form-group form-check">
							    	<input type="checkbox" class="form-check-input" id="privadoLista" name="privadoLista">
							    	<label class="form-check-label" for="privadoLista">Lista privada</label>
							  	</div>
							  	<button type="submit" class="btn btn-success">Confirmar</button>
							</form>
						</div>
					</div>
				</div>	
		
				<div class="list-group-item bg-light">CATEGORIAS</div>
				<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/listar-categorias">Listar Categorias</a>
			</div>
      	</div>
    	<div class="col-md-9">
    		<div class="jumbotron pt-2 bg-light">
      	
