package br.com.treinaweb.springmvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.treinaweb.springmvc.dominios.Musica;
import br.com.treinaweb.springmvc.repositorios.repositorioAlbum;
import br.com.treinaweb.springmvc.repositorios.repositorioMusica;

@Controller
@RequestMapping("/musicas")
public class MusicaController {

	@Autowired
	private repositorioMusica repositorioMus;
	@Autowired
	private repositorioAlbum repositorioAlb;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Musica> musicas = repositorioMus.findAll();
		model.addAttribute("musicas", musicas);

		return "musica.listar.tiles";
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("musica", new Musica());
		model.addAttribute("albuns", repositorioAlb.findAll());

		return "musica.adicionar.tiles";
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("musica") @Valid Musica novaMusica, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("albuns", repositorioAlb.findAll()); // preenche
																	// novamente,
																	// pois será
																	// esvaziado
																	// com o
																	// live
																	// cicle
			return "musica.adicionar.tiles";
		}
		repositorioMus.save(novaMusica);
		return "redirect:/musicas/listar";
	}

	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
	public String alterar(@PathVariable("id") Long id, Model model) {
		Musica musicaASerAlterada = repositorioMus.findOne(id);
		model.addAttribute("musica", musicaASerAlterada);
		model.addAttribute("albuns", repositorioAlb.findAll());
		return "musica.alterar.tiles";
	}

	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("musica") @Valid Musica musica, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("albuns", repositorioAlb.findAll());
			return "musica.alterar.tiles";
		}
		repositorioMus.save(musica);
		return "redirect:/musicas/listar";
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id) {
		Musica musica = repositorioMus.findOne(id);
		musica.setAlbum(null); // precisa remover a ligação da música com o
								// álbum, pois está anotado com orphanRemoval
		repositorioMus.delete(id);

		return "redirect:/musicas/listar";
	}
	
	@RequestMapping(value="/porNome/", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Musica> pesquisarPorNome(@RequestParam(name="nome", defaultValue="") String nomeMusica){
		
		return repositorioMus.findByNome(nomeMusica);
	}

}
