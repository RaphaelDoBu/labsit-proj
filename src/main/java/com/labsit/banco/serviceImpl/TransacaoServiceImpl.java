package com.labsit.banco.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labsit.banco.model.Conta;
import com.labsit.banco.model.Transacao;
import com.labsit.banco.repository.ContaRepository;
import com.labsit.banco.repository.TransacaoRepository;
import com.labsit.banco.service.ContaService;
import com.labsit.banco.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService{
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private ContaService contaService;

	@Transactional
	public void salvarTransacao(Conta contaCliente, float valorDeposito, float saldoAnterior, float saldoAtual) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		contaCliente.setSaldoAtual(saldoAtual);

		Transacao transacao = new Transacao();
		transacao.setConta(contaCliente);
		transacao.setData(dateFormat.format(date));
		transacao.setValorRetirada(valorDeposito);
		transacao.setSaldoAnterior(saldoAnterior);
		transacao.setSaldoAtual(saldoAtual);
		
		contaCliente.getTransacao().add(transacao);
		contaRepository.save(contaCliente);
		transacaoRepository.save(transacao);
	}
	
	public List<Transacao> extratoTransacoesContaCliente(Long idConta){
		Conta contaCliente = contaService.getConta(idConta).get();
		return contaCliente.getTransacao();
	}
	
}
