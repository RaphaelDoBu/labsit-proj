package com.labsit.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.labsit.banco.dto.DadosClienteDTO;
import com.labsit.banco.model.Cliente;
import com.labsit.banco.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(value = "Retorna lista de todos os clientes salvos")
	@GetMapping(value="/clientes")
	public ResponseEntity<List<Cliente>> clientes() {
		List<Cliente> clientes = clienteService.listaClientes();
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
	
	@ApiOperation(value = "Retorna dados de um cliente específico")
	@GetMapping(value="/cliente/{idCliente}")
	public ResponseEntity<Cliente> cliente(@PathVariable("idCliente") Long idCliente) {
		Cliente cliente = clienteService.dadosCliente(idCliente);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	
	@ApiOperation(value = "Atualiza cliente que pertence a uma agência")
	@PutMapping(value="/cliente/{idCliente}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable("idCliente") Long idCliente, @ModelAttribute("dadosCliente") DadosClienteDTO dadosClienteDTO) {
		Cliente clienteAlterado = clienteService.atualizarCliente(idCliente, dadosClienteDTO);
		return ResponseEntity.status(HttpStatus.OK).body(clienteAlterado);
	}
}


