package com.labsit.banco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
    private Long numeroCadastro;
	@Column
	private String tipo;
	@Column
	private String cadastro;
	
	public Pessoa() {
	}
	
	public Pessoa(Long numeroCadastro, String tipo, String cadastro) {
		super();
		this.numeroCadastro = numeroCadastro;
		this.tipo = tipo;
		this.cadastro = cadastro;
	}
	
	public Long getNumeroCadastro() {
		return numeroCadastro;
	}

	public void setNumeroCadastro(Long numeroCadastro) {
		this.numeroCadastro = numeroCadastro;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		if(tipo.toUpperCase().equals("PF")) {
			setCadastro("CPF");
		} else {
			setCadastro("CNPJ");
		}
		this.tipo = tipo;
	}
	public String getCadastro() {
		return cadastro;
	}
	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}
	
}
