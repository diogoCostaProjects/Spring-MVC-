package br.com.treinaweb.springmvc.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	//<servidor:porta/app>/hello/message
	// http://localhost:8080/TreinaWebSpringMVC/hello/message
	
	
	@RequestMapping("/message")
	public String message()	{
		
			return "hello"; /* página retornada que será compreendida pelo Jstl 
			                   que automáticamente irá entender como jsp conforme configuração no servlet
			                   
			                */
	}
	
	@RequestMapping("/mensagemDoServidor")    // pode passar mais de um objeto para a view, já model and view apenas passa um objeto
	public String mensagemDoServidor(Model model){ // Model gerenciado pelo Spring MVC através da injeção de dependência 
		model.addAttribute("mensagem", new Date()); // adiciona o model à página retornada no return  <INTERFACE>
		
		return "mensagemDoServidor"; 
		
	}
	
	@RequestMapping("/mensagemDoServidorV2")    // Deste modo fica(View a ser retornada, objeto, valor do objeto retornado) <CLASSE>
	public ModelAndView mensagemDoServidorV2(){
		
		return new ModelAndView("mensagemDoServidor","mensagem","Este é o V2");
	}
	
	@RequestMapping("/receberMensagem/{mensagem}")  // http://localhost:8080/TreinaWebSpringMVC/hello/receberMensagem/Testando
	public String receberMensagem(Model model, @PathVariable("mensagem") String msg	){
		model.addAttribute("mensagem",msg);
		
		return "mensagemDoServidor"; 	 	
	}	
	@RequestMapping("/receberMensagem2") // http://localhost:8080/TreinaWebSpringMVC/hello/receberMensagem2?mensagem=Ola
										// Request param pode especificar que não é obrigatório passar valor, 
	                                    //e também pode se setar um valor padrão com o defaultValue
	public String receberMensagem2(Model model, @RequestParam(value="mensagem", required = false, defaultValue = "Mensagem padrão") String msg){
		model.addAttribute("mensagem",msg);
		
		return "mensagemDoServidor";
	}
	
	
	
}
	