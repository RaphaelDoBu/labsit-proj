package com.labsit.banco.service;

import java.util.List;
import java.util.Optional;

import com.labsit.banco.dto.DadosClienteDTO;
import com.labsit.banco.model.Cliente;

public interface ClienteService {
	public Cliente cadastrarCliente(DadosClienteDTO dadosClienteDTO);
	public List<Cliente> listaClientes();
	public Cliente dadosCliente(Long idCliente);
	public Optional<Cliente> getCliente(Long idCliente);
	public Cliente atualizarCliente(Long idCliente, DadosClienteDTO dadosClienteDTO);
}
