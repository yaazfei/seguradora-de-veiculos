package br.com.yaazfei.seguradoradeveiculos.responses;

import java.util.List;

public class Resposta<T> {

	private T dados;
	private List<String> erros;
	
	public Resposta (T dados) {
		this.dados = dados;
	}
	
	public T getDados() {
		return dados;
	}

	public void setDados(T dados) {
		this.dados = dados;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public Resposta (List<String> erros) {
		this.erros = erros;
	}
}
