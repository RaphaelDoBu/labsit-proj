package com.labsit.banco.service;

import java.util.List;

import com.labsit.banco.model.Conta;
import com.labsit.banco.model.Transacao;

public interface TransacaoService {
	public void salvarTransacao(Conta contaCliente, float valorDeposito, float saldoAnterior, float saldoAtual);
	public List<Transacao> extratoTransacoesContaCliente(Long idConta);
}
