package org.serratec.backend.projeto02.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Conta {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("titulo")
	private String titulo;
	@JsonProperty("descricao")
	private String descricao;

	public Conta(Integer id, String titulo, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
