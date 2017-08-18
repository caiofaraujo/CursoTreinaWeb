package br.com.treinaweb.springmvc.controllers;

import java.util.Date;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // Nota��o para indicar um Controller no contexto do SpringMVC
@RequestMapping("/hello") // Nota��o para descrever a URL no contexto do SpringMVC para acessar o controller em quest�o
public class HelloController {
	
	//localhost:28080/hello/message
	@RequestMapping("/message")
	public String message() {
		return "hello";
	}
	
	@RequestMapping("/mensagemDoServidor")
	public String mensagemDoServidor(Model model) {
		model.addAttribute("mensagem", "Ol�, TreinaWeb" + new Date().toString()); // MENSAGEM SER� REPASSADA A VIEW "mensagemDoServidor.jsp" ATRAV�S DESTE M�TODO
		return "mensagemDoServidor";
	}
	
	@RequestMapping("/mensagemDoServidor2")
	public ModelAndView mensagemDoServidorV2() {
		ModelAndView resultado = new ModelAndView("mensagemDoServidor", "mensagem", "Ol� TreinaWeb" + new Date().toString());
		return resultado;
	}
	
	/**
	 * M�todo respons�vel por coletar alguma mensagem do usu�rio/view para nosso controller
	 * @author cfaraujo
	 * @param model (Objeto Model do SpringMVC)
	 * @param mensagem (mensagem a ser recebida pelo usu�rio do browser)
	 * */
	@RequestMapping("/receberMensagem/{mensagem}")
	public String receberMensagem(Model model, @PathVariable("mensagem") String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor";
	}
	
}
