<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="dataC" items="${dataC.getComentarios()}">
    
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title"><c:out value="${dataC.getUsuario()}"/></h5>
	    <h6 class="card-subtitle mb-2 text-muted"><c:out value="${dataC.getFecha()}"/></h6>
	    <p class="card-text"><c:out value="${dataC.getTexto()}"/></p>
	    <button id="<c:out value="${dataC.getRuta()}"/>" class="btn btn-sm btn-primary botonReply">Reply</button>
	  </div>
	</div>    
    
    <c:set var="dataC" value="${dataC}" scope="request"/>
    
    <div class="ml-5">
    	<jsp:include page="/WEB-INF/comentario/comentario.jsp"/>
    </div>
    
</c:forEach>
