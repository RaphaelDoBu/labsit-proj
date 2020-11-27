package com.labsit.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.labsit.banco.dto.AgenciaDTO;
import com.labsit.banco.dto.DadosClienteDTO;
import com.labsit.banco.model.Agencia;
import com.labsit.banco.model.Cliente;
import com.labsit.banco.model.Conta;
import com.labsit.banco.service.AgenciaService;
import com.labsit.banco.service.ClienteService;
import com.labsit.banco.service.ContaService;

import io.swagger.annotations.ApiOperation;

@Controller
public class AgenciaController {
	
	@Autowired
	private AgenciaService agenciaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ContaService contaService;
	
	@ApiOperation(value = "Cadastra uma agência passando como parâmetro os dados da agência")
	@PostMapping(value="/")
	public ResponseEntity<Agencia> cadastrarAgencia(@ModelAttribute("agenciaDTO") AgenciaDTO agenciaDTO) {
		Agencia agencia = agenciaService.cadastrarAgencia(agenciaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(agencia);
	}
	
	@ApiOperation(value = "Cadastra cliente e posteriormente criar um conta e vincular a mesma ao cliente e agência")
	@PostMapping(value="/agencia/{idAgencia}/cliente")
	public ResponseEntity<Cliente> cadastrarCliente(@PathVariable("idAgencia") Long idAgencia, @ModelAttribute("dadosCliente") DadosClienteDTO dadosClienteDTO) {
		Cliente clienteCadastrado = clienteService.cadastrarCliente(dadosClienteDTO);
		contaService.cadastrarContaCliente(idAgencia, clienteCadastrado.getId());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastrado);
	}
	
	@ApiOperation(value = "Retorna lista de todas as contas que pertencem a agência")
	@GetMapping(value="/agencia/{idAgencia}/contas")
	public ResponseEntity<List<Conta>> listaContasAgencia(@PathVariable("idAgencia") Long idAgencia) {
		List<Conta> contas = agenciaService.listaContasAgencia(idAgencia);
		return ResponseEntity.status(HttpStatus.OK).body(contas);
	}
	
	@ApiOperation(value = "Retorna lista de todas os clientes que tem conta na agência")
	@GetMapping(value="/agencia/{idAgencia}/conta/clientes")
	public ResponseEntity<List<Cliente>> listaClientesAgencia(@PathVariable("idAgencia") Long idAgencia) {
		List<Cliente> clientes = agenciaService.listaClientesAgencia(idAgencia);
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
}
