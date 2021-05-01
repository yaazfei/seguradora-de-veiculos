package br.com.yaazfei.seguradoradeveiculos.services;

import java.util.List;

import br.com.yaazfei.seguradoradeveiculos.documents.Cliente;

public interface ClienteService {

	List<Cliente> listarTodos();
	
	Cliente listarPorId(String id);
	
	Cliente cadastrar(Cliente cliente);
	
	Cliente atualizar(Cliente cliente);
	
	void remover(String id);
	
}
