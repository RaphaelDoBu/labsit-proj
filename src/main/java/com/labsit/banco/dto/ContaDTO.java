package com.labsit.banco.dto;

import java.util.List;

public class ContaDTO {
	
	private String numConta;
    private String saldoAtual;
    private AgenciaDTO agenciaDTO;
    private List<TransacaoDTO> transacaoDTOs;
    private DadosClienteDTO clienteDTO;
    
   	public ContaDTO() {
   		super();
   	}
   
	public ContaDTO(String numConta, String saldoAtual, AgenciaDTO agenciaDTO, List<TransacaoDTO> transacaoDTOs,
			DadosClienteDTO clienteDTO) {
		super();
		this.numConta = numConta;
		this.saldoAtual = saldoAtual;
		this.agenciaDTO = agenciaDTO;
		this.transacaoDTOs = transacaoDTOs;
		this.clienteDTO = clienteDTO;
	}

	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	public String getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(String saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	
	public AgenciaDTO getAgenciaDTO() {
		return agenciaDTO;
	}

	public void setAgenciaDTO(AgenciaDTO agenciaDTO) {
		this.agenciaDTO = agenciaDTO;
	}

	public List<TransacaoDTO> getTransacaoDTOs() {
		return transacaoDTOs;
	}
	public void setTransacaoDTOs(List<TransacaoDTO> transacaoDTOs) {
		this.transacaoDTOs = transacaoDTOs;
	}
	public DadosClienteDTO getClienteDTO() {
		return clienteDTO;
	}
	public void setClienteDTO(DadosClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
    
    
}
