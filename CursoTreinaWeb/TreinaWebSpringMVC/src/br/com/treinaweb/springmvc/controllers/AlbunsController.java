package br.com.treinaweb.springmvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		return ("album.adicionar.tiles"); // O Java irá procurar dentro do diretório "albuns" a página "adicionar.jsp"
	}
	
	// O método "POST" foi utilizado pois desejamos inserir algo novo em nosso servidor de aplicação
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album novoAlbum, BindingResult result, Model model) {
		// Verificando se há erros de acordo com as validações
		if (result.hasErrors()) {
			// Caso haja erros o usuário será direcionado novamente para a página "albuns/adicionar"
			return ("album.adicionar.tiles");
		}
		model.addAttribute("album", novoAlbum);
		return ("album.exibir.tiles"); // O Java irá procurar dentro do diretório "albuns" a página "exibir.jsp"
	}
	
}
