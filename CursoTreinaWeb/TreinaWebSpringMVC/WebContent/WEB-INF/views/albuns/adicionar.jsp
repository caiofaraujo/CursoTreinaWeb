<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="actionAdicionar" value="/albuns/adicionar"></c:url>
<form:form action="${actionAdicionar}" method="post" modelAttribute="album">
	<div class="row panel panel-primary">
      <div class="panel-heading">
        <h3 class="panel-title">Inserir - Novo Album</h3>
      </div>
      <div class="panel-body">
        <div class="row form-group">
			<div class="col-md-6 col-xs-12">
				<label class="control-label">Nome do Album: </label>
				<form:input path="nome" class="form-control" placeholder="Digite o nome do album"/>		
				<form:errors path="nome"></form:errors>
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-6 col-xs-12">
				<label class="control-label" >Ano de Lançamento: </label>
				<form:input path="anoDeLancamento" class="form-control" placeholder="Digite o ano de lançamento"/>
				<form:errors path="anoDeLancamento"></form:errors>
			</div>
		</div>
		<input class="btn btn-primary" type="submit" value="Salvar" />
      </div>
    </div>

</form:form>
