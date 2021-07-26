<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%DataVideo dataV = (DataVideo) request.getAttribute("video"); %>
<%DataUsuario dataULog = (DataUsuario) request.getAttribute("usrLog"); %>
<% boolean mismoUsr = false;
   if (dataULog!=null && dataULog.getNickname().equals(dataV.getAutor()))
   		mismoUsr = true;%>
<% String catV = dataV.getCategoria(); %>
<% Set<String> gustan = dataV.getGustan(); %>
<% Set<String> noGustan = dataV.getNoGustan(); %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title><%=request.getParameter("video") %></title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
	
	<%if (!(dataV.getPrivado() && !mismoUsr)) {%>
	
		<div class="container mb-4">
			<div class="row">
				<div class="col-md-8">
					<div class="embed-responsive embed-responsive-16by9">
	  					<iframe class="embed-responsive-item" src="<%=dataV.getUrl() %>" allowfullscreen></iframe>
					</div>
				</div>
				<div class="col-md-4 pt-3">
					<div class="container overflow-auto mb-2">
						<div>Nombre: <%=dataV.getNombre() %></div>
						<div class="">Fecha de publicacion: <%=dataV.getFechaPub().toString() %></div>
						<div class="">Autor: <a id="autor" href="/app/perfil?usuario=<%=dataV.getAutor()%>"><%=dataV.getAutor() %></a></div>
						<div class="">Duracion: <%=dataV.getDuracion() %></div>
						<div class="">Url: <%=dataV.getUrl() %></div>
						<div class="">Categoria: <%if (!catV.equals("")) {%><%=catV%><%} else {%>No tiene<%}%></div>
						<div>Video <%if (dataV.getPrivado()) {%>privado<%} else {%>publico<%}%></div>
						<div class="">Descripcion: <p><%=dataV.getDescripcion() %></p></div>
						
					</div>
					<%if (dataULog!=null) {%>
						<%if (dataULog.getNickname().equals(dataV.getAutor())) {%>
							<div class="mb-2">
							<a class="btn btn-sm btn-primary" href="/app/cambiar-video?video=<%=dataV.getNombre()%>">Cambiar video</a>
							</div>
						<%} %>
						<div class="my-2 d-inline-flex alert-danger" id="alertaGustar"></div>
						<div>
							<button id="botonGusta" class="btn btn-sm btn-outline-success botonValorar <%if (gustan.contains(dataULog.getNickname())) {%>active<%}%>">Me gusta</button>
							<button id="botonNoGusta" class="btn btn-sm btn-outline-danger botonValorar <%if (noGustan.contains(dataULog.getNickname())) {%>active<%}%>">No me gusta</button>
						</div>
						<%if (dataULog.getCanal().getListas()!=null) {%>
							<div class="dropdown">
								<button class="dropdown-toggle btn btn-sm btn-success mt-2" data-toggle="dropdown">Agregar a Lista</button>
								<div id="addVideoMenu" class="dropdown-menu">
									<%for (String lis : dataULog.getCanal().getListas()) { %>
										<button class="btn dropdown-item botonAddVideo botonAddRemoveVideo"><%=lis %></button>
									<%} %>
								</div>
							</div>
							<div class="dropdown">
								<button class="dropdown-toggle btn btn-sm btn-danger mt-2" data-toggle="dropdown">Quitar de Lista</button>
								<div id="removeVideoMenu" class="dropdown-menu">
									<%for (String lis : dataULog.getCanal().getListas()) { %>
										<button class="btn dropdown-item botonRemoveVideo botonAddRemoveVideo"><%=lis %></button>
									<%} %>
								</div>
							</div>
							<div class="mt-2 d-inline-flex alert-danger" id="alertaAddRemove"></div>
						<%} %>
					<%} %>
				</div>
			</div>
		</div>
		
		<ul class="nav nav-tabs" id="myTab">
		  <li class="nav-item">
		    <a class="nav-link active" id="comentarios-tab" data-toggle="tab" href="#comentarios">Comentarios</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="gustan-tab" data-toggle="tab" href="#gustan">Gustan (<%=gustan.size() %>)</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="noGustan-tab" data-toggle="tab" href="#noGustan">No gustan (<%=noGustan.size() %>)</a>
		  </li>
		</ul>
		
		<div class="tab-content" id="myTabContent">
		  <div class="tab-pane fade show active" id="comentarios">
		  
		  	<div class="mt-2 d-inline-flex alert-danger" id="alertaComentar"></div>
		  	
		  	<form id="comentarForm" action="/app/comentar" method="post">
		  		<div class="form-group">
		  			<label for="comentarioTextArea"> Tu comentario:</label>
		  			<textarea id="comentarioTextArea" class="form-control" name="texto" placeholder="Escribe aqui tu comentario..." rows="3" cols="" required></textarea>
		  		</div>
		  		<input type="hidden" name="usrVideo" value="<%=dataV.getAutor()%>">
		  		<input type="hidden" name="nomVideo" value="<%=dataV.getNombre()%>">
		  		<input id="inputFechaHora" type="hidden" name="fechaHora" value="">
		  		<input id="inputRuta" type="hidden" name="ruta" value="">
		  		<button id="botonComentar" type="submit" class="btn btn-success mb-2">Comentar!</button>
		  	</form>
		  	
		  	<c:forEach var="dataCom" items="${video.getComentarios().getComentarios()}">
		  		<div class="card">
				  <div class="card-body">
				    <h5 class="card-title"><c:out value="${dataCom.getUsuario()}"/></h5>
				    <h6 class="card-subtitle mb-2 text-muted"><c:out value="${dataCom.getFecha()}"/></h6>
				    <p class="card-text"><c:out value="${dataCom.getTexto()}"/></p>
				    <button id="<c:out value="${dataCom.getRuta()}"/>" class="btn btn-sm btn-primary botonReply">Reply</button>
				  </div>
				</div>
				
				<c:set var="dataC" value="${dataCom}" scope="request"/>
				
				<div class="ml-5">
					<jsp:include page="/WEB-INF/comentario/comentario.jsp"/>
				</div>
				
			</c:forEach>
		  	
		  </div>
		  <div class="tab-pane fade" id="gustan">
		  	<ul class="list-group">
		  		<%for (String gus : gustan) {%>
		  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/perfil?usuario=<%=gus%>"><%= gus %></a>
		  		<%}%>
		  	</ul>
		  </div>
		  <div class="tab-pane fade" id="noGustan">
		  	<ul class="list-group">
		  		<%for (String noGus : noGustan) {%>
		  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/perfil?usuario=<%=noGus%>"><%= noGus %></a>
		  		<%}%>
		  	</ul>
		  </div>
		</div>
	
	<%} else {%>
		<h3>Video privado</h3>
	<%} %>
		
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>