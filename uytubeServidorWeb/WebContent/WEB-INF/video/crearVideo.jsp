<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title>Crear video</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
	
		<h3 class="mb-4">Crear video</h3>
		<% if (request.getAttribute("error") != null) {%>
		<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
		<%} %>
		<form action="/app/crear-video" method="post">
		  <div class="form-group">
		    <label for="nombre">Nombre del video</label>
		    <input type="text" class="form-control" id="nombre" placeholder="Nombre del video" name="nombre" required>
		  </div>
		  <div class="form-group">
		    <label for="descripcion">Descripcion</label>
		    <textarea class="form-control" id="descripcion" placeholder="Descripcion" rows="3" name="descripcion"></textarea>
		  </div>
		  <div class="form-group">
		    <label for="duracion">Duracion</label>
		    <input type="text" class="form-control" id="duracion" placeholder="Duracion" name="duracion" required>
		  </div>
		  <div class="form-group">
		    <label for="url">Url</label>
		    <input type="url" class="form-control" id="url" placeholder="Url" name="url" required>
		  </div>
		  <div class="form-group">
		    <label for="categoria">Categoria</label>
		    <input type="text" class="form-control" id="categoria" placeholder="Categoria" name="categoria">
		  </div>
		  <button type="submit" class="btn btn-success mb-2">Crear video</button>
		</form>
		<a class="btn btn-sm btn-primary" href="/app/home">Cancelar</a>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>