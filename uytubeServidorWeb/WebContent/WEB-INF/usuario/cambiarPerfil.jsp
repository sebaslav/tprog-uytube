<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%DataUsuario dataU = (DataUsuario) request.getAttribute("usrLog"); %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title>Cambiar perfil</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
	
		<h3 class="mb-4">Cambiar perfil</h3>
		<% if (request.getAttribute("error") != null) {%>
		<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
		<%} %>
		<form action="/app/cambiar-perfil" method="post">
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password" placeholder="Password" name="password" value="<%=dataU.getPassword()%>" required>
		  </div>
		  <div class="form-group">
		    <label for="nombre">Nombre</label>
		    <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre" value="<%=dataU.getNombre()%>" required>
		  </div>
		  <div class="form-group">
		    <label for="apellido">Apellido</label>
		    <input type="text" class="form-control" id="apellido" placeholder="Apellido" name="apellido" value="<%=dataU.getApellido()%>" required>
		  </div>
		  <div class="form-group">
		    <label for="imagen">Imagen</label>
		    <input type="text" class="form-control" id="imagen" placeholder="Imagen" name="imagen" value="<%=dataU.getImagen()%>">
		  </div>
		  <div class="form-group">
		    <label for="fecha">Fecha de nacimiento</label>
		    <input type="date" class="form-control" id="fecha" placeholder="Fecha de nacimiento" name="fecha" value="<%=dataU.getFechaNac()%>" required>
		  </div>
		  <div class="form-group">
		    <label for="canal">Nombre del canal</label>
		    <input type="text" class="form-control" id="canal" placeholder="Nombre del canal" name="canal" value="<%=dataU.getCanal().getNombre()%>" required>
		  </div>
		  <div class="form-group">
		    <label for="descripcion">Descripcion</label>
		    <textarea class="form-control" id="descripcion" placeholder="Descripcion" rows="3" name="descripcion"><%=dataU.getCanal().getDescripcion()%></textarea>
		  </div>
		  <div class="form-group form-check">
		    <input type="checkbox" class="form-check-input" id="privado" name="privado" <%if (dataU.getCanal().getPrivado()) {%>checked<%} %>>
		    <label class="form-check-label" for="privado">Canal privado</label>
		  </div>
		  <div class="form-group">
		    <label for="categoria">Categoria</label>
		    <input type="text" class="form-control" id="categoria" placeholder="Categoria" name="categoria" value="<%=dataU.getCanal().getCategoria()%>">
		  </div>
		  <button type="submit" class="btn btn-success mb-2">Confirmar</button>
		</form>
		<a class="btn btn-sm btn-primary" href="/app/home">Cancelar</a>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>