package br.com.yaazfei.seguradoradeveiculos.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConsultaApoliceDto {

	private boolean apoliceVencida;
	private Long diasRestantes;
	private Long diasVencidos;
	private String placaVeiculo;
	private BigDecimal valorApolice;

	

	public Long getDiasRestantes() {
		return diasRestantes;
	}

	public void setDiasRestantes(Long diasRestantes) {
		this.diasRestantes = diasRestantes;
	}

	public Long getDiasVencidos() {
		return diasVencidos;
	}

	public void setDiasVencidos(Long diasVencidos) {
		this.diasVencidos = diasVencidos;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public BigDecimal getValorApolice() {
		return valorApolice;
	}

	public void setValorApolice(BigDecimal valorApolice) {
		this.valorApolice = valorApolice;
	}

	public boolean isApoliceVencida() {
		return apoliceVencida;
	}

	public void setApoliceVencida(boolean apoliceVencida) {
		this.apoliceVencida = apoliceVencida;
	}
}
