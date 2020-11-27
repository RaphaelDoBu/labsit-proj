package com.labsit.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.labsit.banco.model.Transacao;
import com.labsit.banco.service.TransacaoService;

import io.swagger.annotations.ApiOperation;

@Controller
public class TransacaoController {
	@Autowired
	private TransacaoService transacaoService;
	
	@ApiOperation(value = "Retorna extrato de transações realizadas pelo cliente por conta")
	@GetMapping(value="/extratoTransacoes/conta/{idConta}")
	public ResponseEntity<List<Transacao>> extratoTransacoesContaCliente(@PathVariable("idConta") Long idConta) {		
		List<Transacao> transacoes = transacaoService.extratoTransacoesContaCliente(idConta);
		return ResponseEntity.status(HttpStatus.OK).body(transacoes);
	}
}
