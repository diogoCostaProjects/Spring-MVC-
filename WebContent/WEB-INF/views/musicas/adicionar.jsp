<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="actionAdicionar" value="/musicas/adicionar"></c:url>


<h2 class ="jumbotron" style="text-align: center;">Inser��o de nova m�sica</h2>
<form:form action="${actionAdicionar}" method="post" modelAttribute="musica">
	
		<div class="row">
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
			
		<div class ="row">
			<div class="col-md-2">
				<div class="form-group">
					<label>Data de cria��o:</label>
					<form:input path="dataCriacao" cssClass="form-control" />
					<br />
					<form:errors path="dataCriacao" cssStyle="color: red;"></form:errors>
					<br>
					<br>
				</div>
			</div>
		</div>
		
		<div class ="row">
			<div class="col-md-2">
				<div class="form-group">
				<label>�lbum:</label>
					<form:select path="album.id" cssClass="form-control">
						<form:options items="${albuns}" itemLabel="nome" itemValue="id"/>
					</form:select>
				
				</div>
			</div>
		</div>
	<br>
	<input type="submit" value="Salvar" class="btn btn-success"  />

</form:form>


