package br.com.treinaweb.springmvc.controllers;

import java.util.Date;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // Notação para indicar um Controller no contexto do SpringMVC
@RequestMapping("/hello") // Notação para descrever a URL no contexto do SpringMVC para acessar o controller em questão
public class HelloController {
	
	//localhost:28080/hello/message
	@RequestMapping("/message")
	public String message() {
		return "hello"; // VIEW A SER RETORNADA
	}
	
	@RequestMapping("/mensagemDoServidor")
	public String mensagemDoServidor(Model model) {
		model.addAttribute("mensagem", "Olá TreinaWeb " + new Date().toString()); // MENSAGEM SERÁ REPASSADA A VIEW "mensagemDoServidor.jsp" ATRAVÉS DESTE MÉTODO
		return "mensagemDoServidor"; // VIEW A SER RETORNADA
	}
	
	@RequestMapping("/mensagemDoServidor2")
	public ModelAndView mensagemDoServidorV2() {
		ModelAndView resultado = new ModelAndView("mensagemDoServidor", "mensagem", "Olá TreinaWeb" + new Date().toString());
		return resultado;
	}
	
	/**
	 * Método responsável por coletar alguma mensagem do usuário/view para nosso controller através do @PathVariable
	 * @author cfaraujo
	 * @param model (Objeto Model do SpringMVC)
	 * @param mensagem (mensagem a ser recebida pelo usuário do browser)
	 * @return view .jsp a ser retornada
	 * */
	@RequestMapping("/receberMensagem/{mensagem}")
	public String receberMensagem (Model model, @PathVariable("mensagem") String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor"; // VIEW A SER RETORNADA
	}
	
	/**
	 * Método responsável por coletar alguma mensagem do usuário/view para nosso controller através do @RequestParam
	 * @author cfaraujo
	 * @param model (Objeto Model do SpringMVC)
	 * @param mensagem (mensagem a ser recebida pelo usuário do browser)
	 * @return view .jsp a ser retornada
	 * */
	@RequestMapping("/receberMensagem2")
	public String receberMensagem2 (Model model, @RequestParam(value = "mensagem", required = false, defaultValue = "Mensagem padrão") String msg) {
		// O REQUEST PARAM É MAIS COMUMENTE UTILIZADO PARA CRIAÇÃO DE QUERY STRINGS E NÃO ALTERA ROTA, TAMBÉM POSSIBILITA DEFINIR UM VALOR PADRÃO E SETAR COMO OBRIGATÓRIO OU NÃO
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor"; // VIEW A SER RETORNADA
	}
	
}
