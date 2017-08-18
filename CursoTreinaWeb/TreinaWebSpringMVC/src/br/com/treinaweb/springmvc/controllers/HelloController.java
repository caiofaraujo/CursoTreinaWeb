package br.com.treinaweb.springmvc.controllers;

import java.util.Date;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // Notação para indicar um Controller no contexto do SpringMVC
@RequestMapping("/hello") // Notação para descrever a URL no contexto do SpringMVC para acessar o controller em questão
public class HelloController {
	
	//localhost:28080/hello/message
	@RequestMapping("/message")
	public String message() {
		return "hello";
	}
	
	@RequestMapping("/mensagemDoServidor")
	public String mensagemDoServidor(Model model) {
		model.addAttribute("mensagem", "Olá, TreinaWeb" + new Date().toString()); // MENSAGEM SERÁ REPASSADA A VIEW "mensagemDoServidor.jsp" ATRAVÉS DESTE MÉTODO
		return "mensagemDoServidor";
	}
	
	@RequestMapping("/mensagemDoServidor2")
	public ModelAndView mensagemDoServidorV2() {
		ModelAndView resultado = new ModelAndView("mensagemDoServidor", "mensagem", "Olá TreinaWeb" + new Date().toString());
		return resultado;
	}
	
}
