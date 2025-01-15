package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity  						// indicar que a classe é uma tabela
@Table (name = "tb_postagens") // indica o nome da tabela no bd (banco de dados)
public class Postagem {
	
	@Id  // Indica que este campo é a chave primária (PRIMARY KEY)
	@GeneratedValue (strategy = GenerationType.IDENTITY) // Indica o Auto Incremento
	private Long id; // é do tipo int, só que consegue armazenar mais números
	
	@NotBlank (message = "O atributo título é obrigatório!") // É muita parecida com a regra de validação NOT NULL (""), só que mais rígido e não permite texto em branco
	@Size ( min = 5, max = 100, message =  "O atributo título deve conter no mínimo 5 e no máximo 100 caracters")
	private String titulo;
	
	@NotBlank (message = "O atributo texto é obrigatório!")
	@Size ( min = 10, max = 1000, message =  "O atributo título deve conter no mínimo 10 e no máximo 1000 caracters")
	private String texto;
	
	@UpdateTimestamp // Permite a data ser preenchida automaticamente pelo MySql baseado na hora do meu computador
	private LocalDateTime data; // 10/10/25 18:25:58
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
}
