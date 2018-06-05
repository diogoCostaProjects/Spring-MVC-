<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h2 class ="jumbotron" style="text-align: center;">Listagem de Músicas</h2>
<br />
	<div class="row">
		<div class="form-group">
			<label>Música a ser pesquisada</label>
			<input type="text" id="txt-pesquisa" class="form-control"/>
		</div>
		<button class="btn btn-primary" id="btn-pesquisa">Pesquisar</button>	
		</div>
<table class="table table-striped" id="tbl-musicas">
	<thead>
		<th>ID</th>
		<th>Nome da Música</th>
		<th>Data de criação</th>
		<th>Nome do Álbum</th>
		<th>Ações</th>
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
<a href="/TreinaWebSpringMVC/musicas/adicionar" class="btn btn-success">Adicionar nova música</a>

<script type="text/javascript">
	$(document).ready(function(){
		$('#btn-pesquisa').click(function(){
			var nomeMusica = $('#txt-pesquisa').val();
			$.ajax({
				method: 'GET',
				url: '/TreinaWebSpringMVC/musicas/porNome/?nome='+nomeMusica,
				success: function(data){
					$('#tbl-musicas tbody > tr').remove();
					
					$.each(data, function(index, musica){
						$('#tbl-musicas tbody').append(	
								'<tr>' +
									'   <td>' +musica.id+ '</td>'+
									'   <td>' +musica.nome+ '</td>'+
									'   <td>' +musica.dataCriacao+ '</td>'+
									'   <td>' +musica.album.nome+ '</td>'+
									'   <td>'+'<a href="/TreinaWebSpringMVC/musicas/alterar/'+ musica.id +'" class="btn btn-warning">Alterar</a> |'+'</td>'+
									'<td>'+'<a href="/TreinaWebSpringMVC/musicas/excluir/'+ musica.id +'" class="btn btn-danger">Excluir</a>'+'</td>'+
									'</tr>'
								 
							);   	
						});
					},
				error: function(){
					alert("houve um erro na requisição");
				}
			});
		});
	});
</script>






















