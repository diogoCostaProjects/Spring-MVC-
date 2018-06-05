package br.com.treinaweb.springmvc.dominios;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "alb_albuns")
public class Album {

	// Anotações do Hibernate Validator
	
	@NotNull(message = "O nome não pode estar vazio")
	@NotEmpty(message = "O nome é obrigatório")
	@Column(name = "alb_nome", length = 50, nullable = false)
	private String nome;

	@NotNull(message = "O nome é obrigatório")
			//@Min(value = 1990, message = "O álbum deve ser no mínimo de 1990")
	@Max(value = 2018, message = "O álbum deve ser no máximo de 2018")
	
	@Column(name = "alb_ano_lancamento", nullable = false)
	private int anoLancamento;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "alb_id")
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "album") // Repor orphanRemoval
	private Set<Musica> musicas;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

}
