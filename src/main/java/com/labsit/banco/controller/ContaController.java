package com.labsit.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labsit.banco.model.Conta;
import com.labsit.banco.service.ContaService;

import io.swagger.annotations.ApiOperation;

@Controller
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@ApiOperation(value = "Retorna o saldo do cliente por meio do número da conta")
	@GetMapping(value="/saldo/conta/{idConta}")
	public ResponseEntity<Float> saldoContaCliente(@PathVariable("idConta") Long idConta) {		
		float saldoAtual = contaService.consultarSaldo(idConta);
		return ResponseEntity.status(HttpStatus.OK).body(saldoAtual);
	}

	@ApiOperation(value = "Cliente realiza saque na conta, enviando como parâmetro número da conta e o valor do saque")
	@PostMapping(value="/saque/conta/{idConta}")
	public ResponseEntity<Conta> sacarDinheiroContaCliente(@PathVariable("idConta") Long idConta, @RequestParam("valorSaque") float valorSaque) {		
		Conta contaCliente = contaService.sacarDinheiro(idConta, valorSaque);
		return ResponseEntity.status(HttpStatus.CREATED).body(contaCliente);
	}
	
	@ApiOperation(value = "Cliente realiza deposito na conta, enviando como parâmetro número da conta e o valor do saque")
	@PostMapping(value="/deposito/conta/{idConta}")
	public ResponseEntity<Conta> depositarDinheiroContaCliente(@PathVariable("idConta") Long idConta, @RequestParam("valorDeposito") float valorDeposito) {	
		Conta contaCliente = contaService.depositarDinheiro(idConta, valorDeposito);
		return ResponseEntity.status(HttpStatus.CREATED).body(contaCliente);
	}
}
