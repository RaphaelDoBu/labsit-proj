package com.labsit.banco.service;

import java.util.Optional;

import com.labsit.banco.model.Conta;

public interface ContaService {
	public Conta gerarNumeroConta();
	public void cadastrarContaCliente(Long idAgencia, Long idCliente);
	public Optional<Conta> getConta(Long idConta);
	public Conta sacarDinheiro(Long idConta, float valorSaque);
	public Conta depositarDinheiro(Long idConta, float valorDeposito);
	public float consultarSaldo(Long idConta);
}
