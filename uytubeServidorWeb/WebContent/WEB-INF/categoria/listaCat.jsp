<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="datatypes.*"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<% Set<String> categorias = (Set<String>) request.getAttribute("categorias"); %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title>Categorias</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>

	<h3 class="mb-4">Lista de categorias</h3>
	
	<ul class="list-group">
		<%for (String cat : categorias) {%>
	  		<a class="list-group-item list-group-item-action border-0 bg-light" href="/app/ver-categoria?categoria=<%=cat%>"><%= cat %></a>
	  	<%}%>
	</ul>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>
	
</body>
</html>