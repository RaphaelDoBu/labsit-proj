package com.labsit.banco.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsit.banco.dto.DadosClienteDTO;
import com.labsit.banco.model.Cliente;
import com.labsit.banco.model.Endereco;
import com.labsit.banco.model.Pessoa;
import com.labsit.banco.repository.ClienteRepository;
import com.labsit.banco.repository.PessoaRepository;
import com.labsit.banco.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente cadastrarCliente(DadosClienteDTO dadosClienteDTO) {
		Endereco enderecoCliente = new Endereco();
		enderecoCliente.setCidade(dadosClienteDTO.getEnderecoDTO().getCidade());
		enderecoCliente.setEstado(dadosClienteDTO.getEnderecoDTO().getEstado());
		enderecoCliente.setNumero(dadosClienteDTO.getEnderecoDTO().getNumero());
		enderecoCliente.setPais(dadosClienteDTO.getEnderecoDTO().getPais());
		enderecoCliente.setRua(dadosClienteDTO.getEnderecoDTO().getRua());
		
		Pessoa pessoaCliente = new Pessoa();
		pessoaCliente.setNumeroCadastro(dadosClienteDTO.getPessoaDTO().getNumeroCadastro());
		pessoaCliente.setTipo(dadosClienteDTO.getPessoaDTO().getTipo());

		Cliente clienteNovo = new Cliente();
		clienteNovo.setEmail(dadosClienteDTO.getEmail());
		clienteNovo.setIdade(dadosClienteDTO.getIdade());
		clienteNovo.setNome(dadosClienteDTO.getNome());
		clienteNovo.setTelefone(dadosClienteDTO.getTelefone());
		clienteNovo.setEndereco(enderecoCliente);
		clienteNovo.setPessoa(pessoaCliente);
		
		clienteRepository.save(clienteNovo);
		pessoaRepository.save(pessoaCliente);
		return clienteNovo;
	}
	
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente dadosCliente(Long idCliente) {
		return clienteRepository.findById(idCliente).get();
	}
	
	public Optional<Cliente> getCliente(Long idCliente) {
		return clienteRepository.findById(idCliente);
	}
	
	public Cliente atualizarCliente(Long idCliente, DadosClienteDTO dadosClienteDTO) {
		Cliente clienteCadastrado = getCliente(idCliente).get();
	
		Endereco novoEndereco = new Endereco();
		novoEndereco.setCidade(dadosClienteDTO.getEnderecoDTO().getCidade());
		novoEndereco.setEstado(dadosClienteDTO.getEnderecoDTO().getEstado());
		novoEndereco.setNumero(dadosClienteDTO.getEnderecoDTO().getNumero());
		novoEndereco.setPais(dadosClienteDTO.getEnderecoDTO().getPais());
		novoEndereco.setRua(dadosClienteDTO.getEnderecoDTO().getRua());
		
		Pessoa pessoaCliente = clienteCadastrado.getPessoa();
		pessoaCliente.setNumeroCadastro(dadosClienteDTO.getPessoaDTO().getNumeroCadastro());
		pessoaCliente.setTipo(dadosClienteDTO.getPessoaDTO().getTipo());

		clienteCadastrado.setEmail(dadosClienteDTO.getEmail());
		clienteCadastrado.setIdade(dadosClienteDTO.getIdade());
		clienteCadastrado.setNome(dadosClienteDTO.getNome());
		clienteCadastrado.setTelefone(dadosClienteDTO.getTelefone());
		clienteCadastrado.setEndereco(novoEndereco);
		clienteCadastrado.setPessoa(pessoaCliente);

		clienteRepository.save(clienteCadastrado);
		pessoaRepository.save(pessoaCliente);
		return clienteCadastrado;
	}
}
