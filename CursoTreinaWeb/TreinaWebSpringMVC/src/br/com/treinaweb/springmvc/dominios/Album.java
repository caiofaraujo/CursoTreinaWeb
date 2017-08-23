package br.com.treinaweb.springmvc.dominios;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Album {
	
	// Realizando validações com o JSR-303 (javax.validation)
	@NotNull (message = "Informe o campo nome")
	@NotEmpty (message = "Informe o campo nome")
	@Size (min = 4, max = 10, message = "O campo nome deve conter de 4 a 10 caracteres")
	private String nome;
	
	@NotNull (message = "Informe o campo Ano de Lançamento")
//	@NotEmpty (message = "Informe o campo Ano de Lançamento")
	@Min(value = 1990, message = "O Ano de Lançamento deve ser apartir de 1990")
	@Max (value = 2030, message = "O Ano de Lançamento deve ser até de 2030")
	private int anoDeLancamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

}
