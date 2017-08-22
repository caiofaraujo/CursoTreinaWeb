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
	
	// O endere�o "/albuns/adicionar" s� ir� funcionar caso seja feito uma requisi��o do tipo "GET"
	// O m�todo "GET" foi utilizado pois desejamos retornar uma p�gina ao usu�rio
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album()); // Nome do bean utilizado pela p�gina "adicionar.jsp" atrav�s do atributo "modelAttribute"
		return ("album.adicionar.tiles"); // O Java ir� procurar dentro do diret�rio "albuns" a p�gina "adicionar.jsp"
	}
	
	// O m�todo "POST" foi utilizado pois desejamos inserir algo novo em nosso servidor de aplica��o
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album novoAlbum, BindingResult result, Model model) {
		// Verificando se h� erros de acordo com as valida��es
		if (result.hasErrors()) {
			// Caso haja erros o usu�rio ser� direcionado novamente para a p�gina "albuns/adicionar"
			return ("album.adicionar.tiles");
		}
		model.addAttribute("album", novoAlbum);
		return ("album.exibir.tiles"); // O Java ir� procurar dentro do diret�rio "albuns" a p�gina "exibir.jsp"
	}
	
}
