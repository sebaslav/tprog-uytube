<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%DataVideo dataV = (DataVideo) request.getAttribute("video"); %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title>Cambiar video</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
	
		<h3 class="mb-4">Cambiar video</h3>
		<% if (request.getAttribute("error") != null) {%>
		<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
		<%} %>
		<form action="/app/cambiar-video" method="post">
		  <div class="form-group">
		    <label for="nombreViejo">Nombre del video</label>
		    <input type="text" class="form-control" id="nombreViejo" placeholder="Nombre del video" name="nombreViejo" readonly value="<%=dataV.getNombre()%>">
		  </div>
		  <div class="form-group">
		    <label for="nombreNuevo">Nuevo nombre del video</label>
		    <input type="text" class="form-control" id="nombreNuevo" placeholder="Nuevo nombre del video" name="nombreNuevo" required>
		  </div>
		  <div class="form-group">
		    <label for="descripcion">Descripcion</label>
		    <textarea class="form-control" id="descripcion" placeholder="Descripcion" rows="3" name="descripcion"><%=dataV.getDescripcion()%></textarea>
		  </div>
		  <div class="form-group">
		    <label for="duracion">Duracion</label>
		    <input type="text" class="form-control" id="duracion" placeholder="Duracion" name="duracion" value="<%=dataV.getDuracion()%>" required>
		  </div>
		  <div class="form-group">
		    <label for="url">Url</label>
		    <input type="url" class="form-control" id="url" placeholder="Url" name="url" value="<%=dataV.getUrl()%>" required>
		  </div>
		  <div class="form-group">
		    <label for="fecha">Fecha de publicacion</label>
		    <input type="date" class="form-control" id="fecha" placeholder="Fecha de publicacion" name="fecha" readonly value="<%=dataV.getFechaPub().toString()%>" required>
		  </div>
		  <div class="form-group form-check">
		    <input type="checkbox" class="form-check-input" id="privado" name="privado" <%if (dataV.getPrivado()) {%>checked<%} %>>
		    <label class="form-check-label" for="privado">Video privado</label>
		  </div>
		  <div class="form-group">
		    <label for="categoria">Categoria</label>
		    <input type="text" class="form-control" id="categoria" placeholder="Categoria" name="categoria" value="<%=dataV.getCategoria()%>">
		  </div>
		  <button type="submit" class="btn btn-success mb-2">Confirmar</button>
		</form>
		<a class="btn btn-sm btn-primary" href="/app/home">Cancelar</a>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>