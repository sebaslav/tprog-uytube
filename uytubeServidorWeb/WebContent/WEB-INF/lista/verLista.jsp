<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<% DataUsuario dataUsrLog = (DataUsuario) request.getAttribute("usrLog"); %>
<% DataLista dataL = (DataLista) request.getAttribute("lista"); %>
<% boolean mismoUsr = false;
   if (dataUsrLog!=null && dataUsrLog.getNickname().equals(dataL.getAutor()))
   		mismoUsr = true;%>
<% Set<DataPair> videos = dataL.getVideos(); %>
<% Set<String> categorias = dataL.getCategorias(); %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title><%=dataL.getNombre() %></title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>

	<h3 class="mb-3">Lista <%=dataL.getNombre()%> del usuario <%=dataL.getAutor()%></h3>
	
	<div class="alert-danger d-inline-flex" id="alertaCambiarLista"></div>
	
	<div class="mb-1">Lista <button <%if (!mismoUsr){%>disabled<%}%> id="botonCambiarLista" class="btn py-0 px-1 ml-2 <%if (dataL.getPrivado()) {%>btn-outline-danger">privada<%} else {%>btn-outline-success">publica<%}%></button></div>
	<div>Tipo: <%=dataL.getTipo() %></div>
	
	<%if (!(dataL.getPrivado() && !mismoUsr)) {%>
	
		<ul class="nav nav-tabs mt-4" id="myTab">
		  <li class="nav-item">
		    <a class="nav-link active" id="videos-tab" data-toggle="tab" href="#videos">Videos</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="categorias-tab" data-toggle="tab" href="#categorias">Categorias</a>
		  </li>
		</ul>
		<div class="tab-content" id="myTabContent">
		  <div class="tab-pane fade show active" id="videos">
		  	<ul class="list-group">
		  		<%for (DataPair parV : videos) {%>
		  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/ver-video?usuario=<%=parV.getNickname()%>&video=<%=parV.getNombre()%>">
		  			Nombre: <%=parV.getNombre() %>, Autor: <%=parV.getNickname() %>
		  			</a>
		  		<%}%>
		  	</ul>
		  </div>
		  <div class="tab-pane fade" id="categorias">
		  	<ul class="list-group">
		  		<%for (String cat : categorias) {%>
		  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/ver-categoria?categoria=<%=cat%>"><%= cat %></a>
		  		<%}%>
		  	</ul>
		  </div>
		</div>
		
	<%}%>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>