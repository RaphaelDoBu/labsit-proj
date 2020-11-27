package com.labsit.banco.dto;

import java.util.List;

public class DadosClienteDTO {
	private String nome;
    private String email;
    private String idade;
    private String telefone;
    private EnderecoDTO enderecoDTO;
    private PessoaDTO pessoaDTO;
    private List<ContaDTO> contaDTO;
    
	public DadosClienteDTO() {
		super();

	}

	public DadosClienteDTO(String nome, String email, String idade, String telefone, EnderecoDTO enderecoDTO,
			PessoaDTO pessoaDTO, List<ContaDTO> contaDTO) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.telefone = telefone;
		this.enderecoDTO = enderecoDTO;
		this.pessoaDTO = pessoaDTO;
		this.contaDTO = contaDTO;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}

	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}

	public PessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}

	public void setPessoaDTO(PessoaDTO pessoaDTO) {
		this.pessoaDTO = pessoaDTO;
	}

	public List<ContaDTO> getContaDTO() {
		return contaDTO;
	}

	public void setContaDTO(List<ContaDTO> contaDTO) {
		this.contaDTO = contaDTO;
	}
	
    
}
