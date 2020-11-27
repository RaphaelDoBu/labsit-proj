package com.labsit.banco.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsit.banco.dto.AgenciaDTO;
import com.labsit.banco.dto.PessoaDTO;
import com.labsit.banco.model.Agencia;
import com.labsit.banco.model.Cliente;
import com.labsit.banco.model.Conta;
import com.labsit.banco.model.Pessoa;
import com.labsit.banco.repository.AgenciaRepository;
import com.labsit.banco.service.AgenciaService;

@Service
public class AgenciaServiceImpl implements AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public Agencia cadastrarAgencia(AgenciaDTO agenciaDTO) {
		Agencia agencia = new Agencia();
		
		Pessoa pessoa = new Pessoa();
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO = agenciaDTO.getPessoaDTO();
		pessoa.setTipo(pessoaDTO.getTipo());
		
		agencia.setPessoa(pessoa);
		agencia.setNumero(agenciaDTO.getNumero());

		agenciaRepository.save(agencia);
		return agencia;
	}
	
	public Agencia agencia(Long idAgencia) {
		Agencia agencia = agenciaRepository.findById(idAgencia).get();
		return agencia;
	}

	public List<Conta> listaContasAgencia(Long idAgencia) {
		Agencia agencia = agencia(idAgencia);
		return agencia.getConta();
	}

	public List<Cliente> listaClientesAgencia(Long idAgencia) {
		List<Conta> contas = listaContasAgencia(idAgencia);
		List<Cliente> clientes = new ArrayList<>();
		for(Conta conta: contas) {
			clientes.add(conta.getCliente());
		}
		return clientes;
	}
	
}
