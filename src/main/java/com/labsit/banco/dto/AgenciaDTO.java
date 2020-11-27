package com.labsit.banco.dto;

import java.util.List;

public class AgenciaDTO {
	private String numero;
	private List<ContaDTO> contaDTO;
	private PessoaDTO pessoaDTO;
	
	public AgenciaDTO() {
		super();
	}
	
	public AgenciaDTO(String numero, List<ContaDTO> contaDTO, PessoaDTO pessoaDTO) {
		super();
		this.numero = numero;
		this.contaDTO = contaDTO;
		this.pessoaDTO = pessoaDTO;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<ContaDTO> getContaDTO() {
		return contaDTO;
	}
	public void setContaDTO(List<ContaDTO> contaDTO) {
		this.contaDTO = contaDTO;
	}
	public PessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}
	public void setPessoaDTO(PessoaDTO pessoaDTO) {
		this.pessoaDTO = pessoaDTO;
	}
	
	
}
