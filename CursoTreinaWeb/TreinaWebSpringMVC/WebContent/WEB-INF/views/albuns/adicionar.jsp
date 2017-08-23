<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="actionAdicionar" value="/albuns/adicionar"></c:url>
<form:form action="${actionAdicionar}" method="post" modelAttribute="album">
	<div class="row">
		<div class="col-md-6 col-xs-12">
			<label>Nome do Album: </label>
			<form:input path="nome"/>		
			<form:errors path="nome"></form:errors>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-xs-12">
			<label>Ano de Lançamento: </label>
			<form:input path="anoDeLancamento"/>
			<form:errors path="anoDeLancamento"></form:errors>
		</div>
	</div>
	<input type="submit" value="Salvar" />
</form:form>
