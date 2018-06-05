<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h2 class ="jumbotron" style="text-align: center;">Listagem de M�sicas</h2>
<br />
<table class="table table-striped">
	<thead>
		<th>ID</th>
		<th>Nome da M�sica</th>
		<th>Data de cria��o</th>
		<th>Nome do �lbum</th>
		<th>A��es</th>
	</thead>
	<tbody>
		<c:if test="${!empty musicas}">
			<c:forEach items="${musicas}" var="musica">		
				<tr>
					<td>${musica.id}</td>
					<td>${musica.nome}</td>
					<td><fmt:formatDate value="${musica.dataCriacao}" pattern="dd/MM/yyyy" timeZone="UTC"/></td>
					<td>${musica.album.nome}</td>
					<td><a href="/TreinaWebSpringMVC/musicas/alterar/${musica.id}" class="btn btn-warning">Alterar</a>
						| <a href="/TreinaWebSpringMVC/musicas/excluir/${musica.id}" class="btn btn-danger">Excluir</a>
				   </td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<br>
<div></div>
<a href="/TreinaWebSpringMVC/musicas/adicionar" class="btn btn-success">Adicionar nova m�sica</a>






















