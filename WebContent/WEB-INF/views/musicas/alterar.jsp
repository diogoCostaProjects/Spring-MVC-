<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="actionAlterar" value="/musicas/alterar"></c:url>
<h2 class="jumbotron"
	style="text-align: center; box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5);">Edição
	da música "${musica.nome}"</h2>


<form:form action="${actionAlterar}" method="post"
	modelAttribute="musica">

	<div class="row">

		<div class="col-md-4">
			<div class="form-group">
				<label>Id:</label>
				<form:input path="id" cssClass="form-control" readonly="true" />
				<br />
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label>Nome:</label>
				<form:input path="nome" cssClass="form-control" />
				<br />
				<form:errors path="nome" cssStyle="color: red;"></form:errors>
			</div>
		</div>
	</div>
	<br>

	<div class="row">
		<div class="col-md-2">
			<div class="form-group">
				<label>Data de criação:</label>
				<form:input path="dataCriacao" cssClass="form-control" />
				<form:errors path="dataCriacao" cssStyle="color: red;"></form:errors>
			</div>
		</div>
		<div class="col-md-2">
			<div class="form-group">
				<label>Álbum:</label>
				<form:select path="album.id" cssClass="form-control">
					<form:options items="${albuns}" itemLabel="nome" itemValue="id" />
				</form:select>

			</div>
		</div>

	</div>
	<div class="col-md-2">
		<input type="submit" value="Salvar" class="btn btn-success" />
	</div>

</form:form>


