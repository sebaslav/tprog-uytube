<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title>Login</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
	
		<h3 class="mb-4">Login</h3>
		<% if (request.getAttribute("error") != null) {%>
		<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
		<%} %>
		<form action="/app/login" method="post">
		  <div class="form-group">
		    <label for="nickname">Nickname</label>
		    <input type="text" class="form-control" id="nickname" placeholder="Nickname" name="usuario" required>
		  </div>
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
		  </div>
		  <button type="submit" class="btn btn-success mb-2">Iniciar sesion</button>
		</form>
		<a class="btn btn-sm btn-primary" href="/app/sign-up">Crear un usuario</a>
		<a class="btn btn-sm btn-primary" href="/app/home">Cancelar</a>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>