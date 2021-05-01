package br.com.yaazfei.seguradoradeveiculos.documents;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
//import org.springframework.format.annotation.DateTimeFormat;

public class Apolice {

	@Id
	private String numApolice;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	private String placaVeiculo;
	private BigDecimal valorApolice;
	private String cpf;
	
	public Apolice(){
		
	}

	public String getNumApolice() {
		return numApolice;
	}

	public void setNumApolice(String numApolice) {
		this.numApolice = numApolice;
	}
	
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "inicioVigencia não pode ser vazio.")	
	public LocalDate getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(LocalDate inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}
	
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "fimVigencia não pode ser vazio.")
	public LocalDate getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(LocalDate fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	@NotBlank(message = "placaVeiculo não pode ser vazio.")
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	@NotNull(message = "valorApolice não pode ser vazio.")
	public BigDecimal getValorApolice() {
		return valorApolice;
	}

	public void setValorApolice(BigDecimal valorApolice) {
		this.valorApolice = valorApolice;
	}
	
	@CPF(message = "CPF inválido.")
	@NotBlank(message = "CPF não pode ser vazio.")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
