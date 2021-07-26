<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Server error</title>
</head>
<body>
	<h1>Hubo un error!</h1>
	<pre><%= exception.getClass().getName() %>: <%= exception.getMessage() %>
		<% for(StackTraceElement ste: exception.getStackTrace()){ %><%= ste.toString() %>
		<% } %>
	</pre>
</body>
</html>