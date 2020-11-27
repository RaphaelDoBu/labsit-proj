package com.labsit.banco.service;

import java.util.List;

import com.labsit.banco.dto.AgenciaDTO;
import com.labsit.banco.model.Agencia;
import com.labsit.banco.model.Cliente;
import com.labsit.banco.model.Conta;

public interface AgenciaService {
	public Agencia cadastrarAgencia(AgenciaDTO agenciaDTO);
	public Agencia agencia(Long idAgencia);
	public List<Conta> listaContasAgencia(Long idAgencia);
	public List<Cliente> listaClientesAgencia(Long idAgencia);

}
