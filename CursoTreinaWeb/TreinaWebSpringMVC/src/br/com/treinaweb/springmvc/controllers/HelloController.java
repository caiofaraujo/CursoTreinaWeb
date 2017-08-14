 package br.com.treinaweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Nota��o para indicar um Controller no contexto do SpringMVC
@RequestMapping("/hello") // Nota��o para descrever a URL no contexto do SpringMVC para acessar o controller em quest�o
public class HelloController {
	
	//localhost:28080/hello/message
	@RequestMapping("/message")
	public String message() {
		return "hello";
	}

}
