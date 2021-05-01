package br.com.yaazfei.seguradoradeveiculos.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import br.com.yaazfei.seguradoradeveiculos.documents.Cliente;
import br.com.yaazfei.seguradoradeveiculos.exception.ClienteDuplicadoException;
import br.com.yaazfei.seguradoradeveiculos.repositories.ClienteRepository;
import br.com.yaazfei.seguradoradeveiculos.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	//Instancia do repositorio
	
	@Override
	public List<Cliente> listarTodos() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente listarPorId(String id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
	//	return this.clienteRepository.findById(id);
		return cliente;
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		try {
			return this.clienteRepository.save(cliente);
		} catch(DuplicateKeyException ex) {
			throw new ClienteDuplicadoException("CPF já cadastrado.");
		}
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public void remover(String id) {
		this.clienteRepository.deleteById(id);

	}

}
