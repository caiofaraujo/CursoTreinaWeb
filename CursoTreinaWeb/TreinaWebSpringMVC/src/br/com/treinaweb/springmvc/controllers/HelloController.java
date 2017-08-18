package br.com.treinaweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("mensagem", "Olá, TreinaWeb!"); // MENSAGEM SERÁ REPASSADA A VIEW "mensagemDoServidor.jsp" ATRAVÉS DESTE MÉTODO
		return "mensagemDoServidor";
	}
}
