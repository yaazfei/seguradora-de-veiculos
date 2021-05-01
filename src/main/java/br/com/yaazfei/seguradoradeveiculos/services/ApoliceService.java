package br.com.yaazfei.seguradoradeveiculos.services;

import java.util.List;

import br.com.yaazfei.seguradoradeveiculos.documents.Apolice;
import br.com.yaazfei.seguradoradeveiculos.dto.ConsultaApoliceDto;

public interface ApoliceService {
	
	List<Apolice> listarTodos();
	
	Apolice listarPorID(String id);
	
	Apolice cadastrar(Apolice apolice);
	
	Apolice atualizar(Apolice apolice);
	
	void remover(String id);

	ConsultaApoliceDto consultaPorNumero(String id);

}
