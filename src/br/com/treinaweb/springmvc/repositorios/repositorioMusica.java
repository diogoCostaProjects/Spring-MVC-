package br.com.treinaweb.springmvc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.springmvc.dominios.Musica;

public interface repositorioMusica extends JpaRepository<Musica, Long>  {

}
