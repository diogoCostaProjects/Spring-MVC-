package br.com.treinaweb.springmvc.repositorios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.treinaweb.springmvc.dominios.Album;


public interface repositorioAlbum extends JpaRepository<Album, Long>{ // Generics usados para especificar a entidade e a chave
		@Query("SELECT a FROM Album a WHERE a.nome LIKE %:nome%")	 		 													// Os m�todos do CRUD s�o implementados pelo Spring em tempo de execu��o 
		List <Album> findByNome(@Param("nome") String nome); // O Spring identifica que o metodo � uma pesquisa por nome e implementa uma consulta que retorna o album pelo nome pesquisado
}
	  	