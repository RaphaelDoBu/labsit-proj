package com.labsit.banco.dto;

public class PessoaDTO {
	private String tipo;
	private String cadastro;
	private long numeroCadastro;

	public PessoaDTO() {
		super();
	}
	
	public PessoaDTO(String tipo, String cadastro, long numeroCadastro) {
		super();
		this.tipo = tipo;
		this.cadastro = cadastro;
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

	public long getNumeroCadastro() {
		return numeroCadastro;
	}

	public void setNumeroCadastro(long numeroCadastro) {
		this.numeroCadastro = numeroCadastro;
	}
	
	
}
