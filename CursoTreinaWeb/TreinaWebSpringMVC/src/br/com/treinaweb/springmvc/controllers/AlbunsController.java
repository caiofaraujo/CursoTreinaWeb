package br.com.treinaweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.treinaweb.springmvc.dominios.Album;

@Controller
@RequestMapping("/albuns")
public class AlbunsController {
	
	// O endereço "/albuns/adicionar" só irá funcionar caso seja feito uma requisição do tipo "GET"
	// O método "GET" foi utilizado pois desejamos retornar uma página ao usuário
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album()); // Nome do bean utilizado pela página "adicionar.jsp" através do atributo "modelAttribute"
		return ("albuns/adicionar"); // O Java irá procurar dentro do diretório "albuns" a página "adicionar.jsp"
	}
	
	// O método "POST" foi utilizado pois desejamos inserir algo novo em nosso servidor de aplicação
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") Album novoAlbum, Model model) {
		model.addAttribute("album", novoAlbum);
		return ("albuns/exibir"); // O Java irá procurar dentro do diretório "albuns" a página "exibir.jsp"
	}
	
}
