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
		
			return "hello"; /* p�gina retornada que ser� compreendida pelo Jstl 
			                   que autom�ticamente ir� entender como jsp conforme configura��o no servlet
			                   
			                */
	}
	
	@RequestMapping("/mensagemDoServidor")    // pode passar mais de um objeto para a view, j� model and view apenas passa um objeto
	public String mensagemDoServidor(Model model){ // Model gerenciado pelo Spring MVC atrav�s da inje��o de depend�ncia 
		model.addAttribute("mensagem", new Date()); // adiciona o model � p�gina retornada no return  <INTERFACE>
		
		return "mensagemDoServidor"; 
		
	}
	
	@RequestMapping("/mensagemDoServidorV2")    // Deste modo fica(View a ser retornada, objeto, valor do objeto retornado) <CLASSE>
	public ModelAndView mensagemDoServidorV2(){
		
		return new ModelAndView("mensagemDoServidor","mensagem","Este � o V2");
	}
	
	@RequestMapping("/receberMensagem/{mensagem}")  // http://localhost:8080/TreinaWebSpringMVC/hello/receberMensagem/Testando
	public String receberMensagem(Model model, @PathVariable("mensagem") String msg	){
		model.addAttribute("mensagem",msg);
		
		return "mensagemDoServidor"; 	 	
	}	
	@RequestMapping("/receberMensagem2") // http://localhost:8080/TreinaWebSpringMVC/hello/receberMensagem2?mensagem=Ola
										// Request param pode especificar que n�o � obrigat�rio passar valor, 
	                                    //e tamb�m pode se setar um valor padr�o com o defaultValue
	public String receberMensagem2(Model model, @RequestParam(value="mensagem", required = false, defaultValue = "Mensagem padr�o") String msg){
		model.addAttribute("mensagem",msg);
		
		return "mensagemDoServidor";
	}
	
	
	
}
	