package com.labsit.banco.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labsit.banco.model.Agencia;
import com.labsit.banco.model.Cliente;
import com.labsit.banco.model.Conta;
import com.labsit.banco.repository.AgenciaRepository;
import com.labsit.banco.repository.ClienteRepository;
import com.labsit.banco.repository.ContaRepository;
import com.labsit.banco.service.ContaService;
import com.labsit.banco.service.TransacaoService;

@Service
public class ContaServiceImpl implements ContaService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private AgenciaRepository agenciaRepository;
	@Autowired
	private TransacaoService transacaoService;

	/**
	 * Gera número randomico de conta com exatamente 8 dígitos
	 * @return Objeto inicial Conta com atributo numConta setado com conta.
	 */
	public Conta gerarNumeroConta() {
		Conta conta = new Conta();

		int numero = (int)(10000000 + Math.random() * (100000000 - 10000000 + 1));
		conta.setNumConta(numero);
		return conta;
	}
	
	public void cadastrarContaCliente(Long idAgencia, Long idCliente) {
		Conta conta = gerarNumeroConta();
		Cliente cliente = clienteRepository.findById(idCliente).get();
		Agencia agencia = agenciaRepository.findById(idAgencia).get();
		cliente.getConta().add(conta);
		agencia.getConta().add(conta);
		
		conta.setCliente(cliente);
		conta.setAgencia(agencia);
		contaRepository.save(conta);
		clienteRepository.save(cliente);
		agenciaRepository.save(agencia);
	}
	
	public Optional<Conta> getConta(Long idConta) {
		return contaRepository.findById(idConta);
	}

	@Transactional
	public Conta sacarDinheiro(Long idConta, float valorSaque) {
		Conta contaCliente = getConta(idConta).get();
		float saldoAnterior = contaCliente.getSaldoAtual();
		if(saldoAnterior > 0 && saldoAnterior >= valorSaque) {
			float saldoAtual = saldoAnterior - valorSaque;
			transacaoService.salvarTransacao(contaCliente, valorSaque, saldoAnterior, saldoAtual);
		}
		return contaCliente;
	}
	
	@Transactional
	public Conta depositarDinheiro(Long idConta, float valorDeposito) {
		Conta contaCliente = getConta(idConta).get();
		if(valorDeposito > 0) {
			float saldoAnterior = contaCliente.getSaldoAtual();
			float saldoAtual = saldoAnterior + valorDeposito;
			
			transacaoService.salvarTransacao(contaCliente, valorDeposito, saldoAnterior, saldoAtual);
		}
		return contaCliente;
	}

	public float consultarSaldo(Long idConta) {
		Conta contaCliente = getConta(idConta).get();
		return contaCliente.getSaldoAtual();
	}
}
