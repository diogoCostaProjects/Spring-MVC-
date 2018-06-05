<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="actionAdicionar" value="/albuns/adicionar"></c:url>
<h2>Inser��o de novo �lbum</h2>
<form:form action="${actionAdicionar}" method="post" modelAttribute="album">
	<!-- Form ser� submetida via post para action albuns/adicionar -->

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label>Nome:</label>
					<form:input path="nome" cssClass="form-control" />
					<br />
					<form:errors path="nome" cssStyle="color: red;"></form:errors>
					<br>
					<br>
				</div>
			</div>


			<div class="col-md-6">
				<div class="form-group">
					<label>Ano de Lancamento:</label>
					<form:input path="anoLancamento" cssClass="form-control" />
					<br />
					<form:errors path="anoLancamento" cssStyle="color: red;"></form:errors>
					<br>
					<br>
				</div>
			</div>
		</div>
	</div>
	<input type="submit" value="Salvar" class="btn btn-warning" />

</form:form>


