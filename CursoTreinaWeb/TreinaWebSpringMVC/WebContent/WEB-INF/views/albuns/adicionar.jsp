<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="actionAdicionar" value="/albuns/adicionar"></c:url>
<form:form action="${actionAdicionar}" method="post" modelAttribute="album">
    <div class="row">
		<div class="col-md-6 col-xs-12">
			<div class="form-group">
				<label class="control-label">Nome do Album: </label>
				<form:input path="nome" cssClass="form-control" class="form-control" placeholder="Digite o nome do album"/>		
				<form:errors path="nome" cssStyle="color: red;"></form:errors>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-xs-12">
			<div class="form-group">
				<label class="control-label" >Ano de Lançamento: </label>
				<form:input path="anoDeLancamento" cssClass="form-control" placeholder="Digite o ano de lançamento"/>
				<form:errors path="anoDeLancamento" cssStyle="color: red;"></form:errors>
			</div>
		</div>
	</div>
	<input class="btn btn-primary" type="submit" value="Salvar" />
</form:form>
