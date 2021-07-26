<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<% DataUsuario dataU = (DataUsuario) request.getAttribute("usrPerfil"); %>
<% DataUsuario dataULog = (DataUsuario) request.getAttribute("usrLog"); %>
<% boolean mismoUsr = false;
   if (dataULog!=null && dataULog.getNickname().equals(dataU.getNickname()))
   		mismoUsr = true;%>
<% String catU = dataU.getCanal().getCategoria(); %>
<% Set<String> videos = dataU.getCanal().getVideos(); %>
<% Set<String> listas = dataU.getCanal().getListas(); %>
<% Set<String> meSiguen = dataU.getLoSiguen(); %>
<% Set<String> losSigo = dataU.getSigueA(); %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title><%=dataU.getNickname() %></title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>

	<%if (!(dataU.getCanal().getPrivado() && !mismoUsr)) {%>

		<div id="headerPerfil" class="mb-3 container">
			<div class="row justify-content-between">
				<div class="col-3">
					<img class="mr-5" id="fotoPerfil" src="/app/media/imagenes/defecto.gif">
					
				</div>
				
				<div class="col-5">
					<div class="pt-2">
						<h2><%=dataU.getNickname()%></h2>
						<h4><%=dataU.getNombre()%> <%=dataU.getApellido()%></h4>
						<%if ((dataULog!=null) && !(dataULog.getNickname().equals(dataU.getNickname()))) { %>
						<button id="botonSeguir" class="btn py-0 px-1 ml-2 <%if (dataULog.getSigueA().contains(dataU.getNickname())) {%>btn-outline-success">Siguiendo<%} else {%>btn-outline-danger">No siguiendo<%}%></button>
						<%} %>
						<div class="alert-danger d-inline-flex ml-2" id="alertaSeguir"></div>
					</div>
				</div>
				
				<div class="pt-3 col-4 overflow-auto">
					<div class="">Fecha de nacimiento: <%=dataU.getFechaNac().toString() %></div>
					<div class="">Canal: <%=dataU.getCanal().getNombre() %></div>
					<div class="">Categoria: <%if (!catU.equals("")) {%><%=catU%><%} else {%>No tiene<%}%></div>
					<div>Canal <%if (dataU.getCanal().getPrivado()) {%>privado<%} else {%>publico<%}%></div>
				</div>
			</div>
		</div>
		
		<div class="overflow-auto">Descripcion:</div>
		<textarea id="descPerfilTextArea" class="bg-light border-0 mb-4" rows="2" cols="50" readonly><%=dataU.getCanal().getDescripcion() %></textarea>
		
		<ul class="nav nav-tabs" id="myTab">
		  <li class="nav-item">
		    <a class="nav-link active" id="videos-tab" data-toggle="tab" href="#videos">Videos</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="listas-tab" data-toggle="tab" href="#listas">Listas</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="seguidores-tab" data-toggle="tab" href="#seguidores">Seguidores</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="seguidos-tab" data-toggle="tab" href="#seguidos">Seguidos</a>
		  </li>
		</ul>
		<div class="tab-content" id="myTabContent">
		  <div class="tab-pane fade show active" id="videos">
		  	<ul class="list-group">
		  		<%for (String vid : videos) {%>
		  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/ver-video?usuario=<%=dataU.getNickname()%>&video=<%= vid %>"><%= vid %></a>
		  		<%}%>
		  	</ul>
		  </div>
		  <div class="tab-pane fade" id="listas">
		  	<ul class="list-group">
		  		<%for (String lis : listas) {%>
		  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/ver-lista?usuario=<%=dataU.getNickname()%>&lista=<%= lis %>"><%= lis %></a>
		  		<%}%>
		  	</ul>
		  </div>
		  <div class="tab-pane fade" id="seguidores">
		  	<ul class="list-group">
		  		<%for (String meS : meSiguen) {%>
		  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/perfil?usuario=<%=meS%>"><%= meS %></a>
		  		<%}%>
		  	</ul>
		  </div>
		  <div class="tab-pane fade" id="seguidos">
		  	<ul class="list-group">
		  		<%for (String sigo : losSigo) {%>
		  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/perfil?usuario=<%=sigo%>"><%= sigo %></a>
		  		<%}%>
		  	</ul>
		  </div>
		</div>
	
	<%} else {%>
		<h3>Perfil privado</h3>
	<%} %>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>