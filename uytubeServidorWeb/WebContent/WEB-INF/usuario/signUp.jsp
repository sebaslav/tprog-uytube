<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title>Sign Up</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
	
		<h3 class="mb-4">Sign Up</h3>
		<% if (request.getAttribute("error") != null) {%>
		<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
		<%} %>
		<form action="/app/sign-up" method="post" id="signUpForm">
		  <div class="form-group">
		    <label for="nickname">Nickname</label>
		    <input type="text" class="form-control" id="nickname" placeholder="Nickname" name="nickname" required>
		  </div>
		  <div class="form-group">
		    <label for="correo">Correo electronico</label>
		    <input type="email" class="form-control" id="correo" placeholder="Correo" name="correo" required>
		  </div>
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
		  </div>
		  <div class="form-group">
		    <label for="confirmarPassword">Confirmar Password</label>
		    <input type="password" class="form-control" id="confirmarPassword" placeholder="Confirmar Password" name="confirmarPassword" required>
		  </div>
		  <div class="form-group">
		    <label for="nombre">Nombre</label>
		    <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre" required>
		  </div>
		  <div class="form-group">
		    <label for="apellido">Apellido</label>
		    <input type="text" class="form-control" id="apellido" placeholder="Apellido" name="apellido" required>
		  </div>
		  <div class="form-group">
		    <label for="imagen">Imagen</label>
		    <input type="text" class="form-control" id="imagen" placeholder="Imagen" name="imagen">
		  </div>
		  <div class="form-group">
		    <label for="fecha">Fecha de nacimiento</label>
		    <input type="date" class="form-control" id="fecha" placeholder="Fecha de nacimiento" name="fecha" required>
		  </div>
		  <div class="form-group">
		    <label for="canal">Nombre del canal</label>
		    <input type="text" class="form-control" id="canal" placeholder="Nombre del canal" name="canal">
		  </div>
		  <div class="form-group">
		    <label for="descripcion">Descripcion</label>
		    <textarea class="form-control" id="descripcion" placeholder="Descripcion" rows="3" name="descripcion"></textarea>
		  </div>
		  <div class="form-group form-check">
		    <input type="checkbox" class="form-check-input" id="privado" name="privado">
		    <label class="form-check-label" for="privado">Canal privado</label>
		  </div>
		  <div class="form-group">
		    <label for="categoria">Categoria</label>
		    <input type="text" class="form-control" id="categoria" placeholder="Categoria" name="categoria">
		  </div>
		  <button id="botonSubmitSignUp" type="submit" class="btn btn-success mb-2">Registrarse</button>
		</form>
		<a class="btn btn-sm btn-primary" href="/app/home">Cancelar</a>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>