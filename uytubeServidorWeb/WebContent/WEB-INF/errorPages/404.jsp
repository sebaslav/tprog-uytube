<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"></jsp:include>
	<title>No encontrado</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
	
	<h1 class="">Error 404</h1>
	
	<% if (request.getAttribute("error") != null) {%>
		<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
	<%} %>
	
	<jsp:include page="/WEB-INF/templates/footer.jsp"></jsp:include>

</body>
</html>