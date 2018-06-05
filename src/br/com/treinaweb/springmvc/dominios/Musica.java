package br.com.treinaweb.springmvc.dominios;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "mus_musicas")
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mus_id")
	private Long id;

	@NotNull(message = "O nome não pode estar vazio")
	@NotEmpty(message = "O nome é obrigatório")
	@Size(min = 4, max = 10, message = "O nome da música deve conter entre 4 e 10 caracteres")
		
	@Column(name = "mus_nome", nullable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "alb_id") // Não utiliza @Column, pois como é uma Foreign Key, vai importar a coluna do objeto forte.
	private Album album;

	@NotNull(message = "A data de criação não pode estar vazia")
	@Column(name = "mus_data_criacao", nullable = false)
	@Temporal(TemporalType.DATE) // anotação necessária quando lidamos com data em jpa 
	@DateTimeFormat(pattern = "dd/mm/yyyy" ) // padroniza a data 
	private Date dataCriacao;

	
	
	// getters & setters

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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
