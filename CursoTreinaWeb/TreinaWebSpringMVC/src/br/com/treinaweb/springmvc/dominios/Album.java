package br.com.treinaweb.springmvc.dominios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

// NOTATIONS DO JPA
@Entity
@Table (name = "alb_albuns")

public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alb_id")
	private Long id;
	
	// Realizando valida��es com o JSR-303 (javax.validation)
	@NotNull (message = "Informe o campo nome")
	@NotEmpty (message = "Informe o campo nome")
	@Size (min = 4, max = 10, message = "O campo nome deve conter de 4 a 10 caracteres")
	@Column(name = "alb_nome", length = 10, nullable = false) 
	private String nome;
	
	@NotNull (message = "Informe o campo Ano de Lan�amento")
//	@NotEmpty (message = "Informe o campo Ano de Lan�amento")
	@Min(value = 1990, message = "O Ano de Lan�amento deve ser apartir de 1990")
	@Max (value = 2030, message = "O Ano de Lan�amento deve ser at� de 2030")
	@Column(name="alb_ano_lancamento", nullable = false)
	private int anoDeLancamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
