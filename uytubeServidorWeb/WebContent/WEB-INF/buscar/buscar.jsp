<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<% Set res = (Set) request.getAttribute("res"); %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title>Buscar</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
	
	<h3 class="mb-4">Resultados (<%=res.size()%>)</h3>
	
	<div class="form-group">
	    <label for="selectOrden">Ordenar:</label>
		<select class="form-control" id="selectOrden">
			<option value="default">--</option>
			<option value="alfa">Alfabeticamente</option>
			<option value="fecha">Por Fecha</option>
		</select>
	</div>
	
	<ul class="list-group">
		<%if (request.getParameter("opcion").equals("usuarios")) { %>
			<%Set<String> usrs = (Set<String>) request.getAttribute("res");
			for (String us : usrs) {%>
		  		<a class="resItem list-group-item list-group-item-action border-0 bg-light" href="/app/perfil?usuario=<%=us%>"><%= us%></a>
		  	<%}%>
		<%}%>
		
		<%if (request.getParameter("opcion").equals("videos")) { %>
			<%Set<DataPair> vids = (Set<DataPair>) request.getAttribute("res");
			for (DataPair vid : vids) {%>
	  			<a class="resItem list-group-item list-group-item-action border-0 bg-light" href="/app/ver-video?usuario=<%=vid.getNickname()%>&video=<%=vid.getNombre()%>">
	  			Nombre: <%=vid.getNombre() %>, Autor: <%=vid.getNickname() %>
  				</a>
  			<%}%>
		<%}%>
		
		<%if (request.getParameter("opcion").equals("listas")) { %>
			<%Set<DataPair> listas = (Set<DataPair>) request.getAttribute("res");
			for (DataPair parL : listas) {%>
	  			<a class="resItem list-group-item list-group-item-action border-0 bg-light" href="/app/ver-lista?usuario=<%=parL.getNickname()%>&lista=<%=parL.getNombre()%>">
	  			Nombre: <%=parL.getNombre() %>, Autor: <%=parL.getNickname() %>
	  			</a>
  			<%}%>
		<%}%>
	</ul>

	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>