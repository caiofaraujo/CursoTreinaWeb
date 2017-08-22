<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TreinaWeb - Adiocionar Album</title>
</head>
<body>
	<h1>Incluir Album</h1>
	<c:url var="actionAdicionar" value="/albuns/adicionar"></c:url>
	<form:form action="${actionAdicionar}" method="post" modelAttribute="album">
		<label>Nome do Album: </label>
		<form:input path="nome"/></br>
		<label>Ano de Lançamento: </label>
		<form:input path="anoDeLancamento"/></br>
		<input type="submit" value="Salvar" />
	</form:form>
</body>
</html>