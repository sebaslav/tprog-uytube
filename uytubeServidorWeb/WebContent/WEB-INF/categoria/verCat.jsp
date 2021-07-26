<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<% DataCategoria dataC = (DataCategoria) request.getAttribute("categoria"); %>
<% Set<DataPair> videos = dataC.getVideos(); %>
<% Set<DataPair> listas = dataC.getListas(); %>
<% Set<String> usuarios = dataC.getUsuarios(); %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title><%=request.getParameter("categoria") %></title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>

	<h3 class="mb-4">Categoria: <%=request.getParameter("categoria") %></h3>
	
	<ul class="nav nav-tabs" id="myTab">
	  <li class="nav-item">
	    <a class="nav-link active" id="videos-tab" data-toggle="tab" href="#videos">Videos</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" id="listas-tab" data-toggle="tab" href="#listas">Listas</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" id="usuarios-tab" data-toggle="tab" href="#usuarios">Usuarios</a>
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
	  <div class="tab-pane fade" id="listas">
	  	<ul class="list-group">
	  		<%for (DataPair parL : listas) {%>
	  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/ver-lista?usuario=<%=parL.getNickname()%>&lista=<%=parL.getNombre()%>">
	  			Nombre: <%=parL.getNombre() %>, Autor: <%=parL.getNickname() %>
	  			</a>
	  		<%}%>
	  	</ul>
	  </div>
	  <div class="tab-pane fade" id="usuarios">
	  	<ul class="list-group">
	  		<%for (String uS : usuarios) {%>
	  			<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/perfil?usuario=<%=uS%>"><%= uS %></a>
	  		<%}%>
	  	</ul>
	  </div>
	</div>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>