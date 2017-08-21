package br.com.treinaweb.springmvc.controllers;

import java.util.Date;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // Nota��o para indicar um Controller no contexto do SpringMVC
@RequestMapping("/hello") // Nota��o para descrever a URL no contexto do SpringMVC para acessar o controller em quest�o
public class HelloController {
	
	//localhost:28080/hello/message
	@RequestMapping("/message")
	public String message() {
		return "hello"; // VIEW A SER RETORNADA
	}
	
	@RequestMapping("/mensagemDoServidor")
	public String mensagemDoServidor(Model model) {
		model.addAttribute("mensagem", "Ol� TreinaWeb " + new Date().toString()); // MENSAGEM SER� REPASSADA A VIEW "mensagemDoServidor.jsp" ATRAV�S DESTE M�TODO
		return "mensagemDoServidor"; // VIEW A SER RETORNADA
	}
	
	@RequestMapping("/mensagemDoServidor2")
	public ModelAndView mensagemDoServidorV2() {
		ModelAndView resultado = new ModelAndView("mensagemDoServidor", "mensagem", "Ol� TreinaWeb" + new Date().toString());
		return resultado;
	}
	
	/**
	 * M�todo respons�vel por coletar alguma mensagem do usu�rio/view para nosso controller atrav�s do @PathVariable
	 * @author cfaraujo
	 * @param model (Objeto Model do SpringMVC)
	 * @param mensagem (mensagem a ser recebida pelo usu�rio do browser)
	 * @return view .jsp a ser retornada
	 * */
	@RequestMapping("/receberMensagem/{mensagem}")
	public String receberMensagem (Model model, @PathVariable("mensagem") String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor"; // VIEW A SER RETORNADA
	}
	
	/**
	 * M�todo respons�vel por coletar alguma mensagem do usu�rio/view para nosso controller atrav�s do @RequestParam
	 * @author cfaraujo
	 * @param model (Objeto Model do SpringMVC)
	 * @param mensagem (mensagem a ser recebida pelo usu�rio do browser)
	 * @return view .jsp a ser retornada
	 * */
	@RequestMapping("/receberMensagem2")
	public String receberMensagem2 (Model model, @RequestParam(value = "mensagem", required = false, defaultValue = "Mensagem padr�o") String msg) {
		// O REQUEST PARAM � MAIS COMUMENTE UTILIZADO PARA CRIA��O DE QUERY STRINGS E N�O ALTERA ROTA, TAMB�M POSSIBILITA DEFINIR UM VALOR PADR�O E SETAR COMO OBRIGAT�RIO OU N�O
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor"; // VIEW A SER RETORNADA
	}
	
}
