package br.com.yaazfei.seguradoradeveiculos.services.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yaazfei.seguradoradeveiculos.documents.Apolice;
import br.com.yaazfei.seguradoradeveiculos.dto.ConsultaApoliceDto;
import br.com.yaazfei.seguradoradeveiculos.exception.DataApoliceException;
import br.com.yaazfei.seguradoradeveiculos.repositories.ApoliceRepository;
import br.com.yaazfei.seguradoradeveiculos.services.ApoliceService;

@Service
public class ApoliceServiceImpl implements ApoliceService {

	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@Override
	public List<Apolice> listarTodos(){
		return this.apoliceRepository.findAll();
	}

	@Override
	public Apolice listarPorID(String id) {
		Apolice apolice = apoliceRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Apolice não encontrada."));
		return apolice;
	}

	@Override
	public Apolice cadastrar(Apolice apolice) {
		validaApolice(apolice);
		return this.apoliceRepository.save(apolice);
	}

	@Override
	public Apolice atualizar(Apolice apolice) {
		validaApolice(apolice);
		return this.apoliceRepository.save(apolice);
	}

	@Override
	public void remover(String id) {
		this.apoliceRepository.deleteById(id);

	}
	
	@Override
	public ConsultaApoliceDto consultaPorNumero(String id) {
		Apolice apolice = this.listarPorID(id);
		ConsultaApoliceDto consultaApoliceDto = new ConsultaApoliceDto();
		if(apolice.getFimVigencia().isAfter(LocalDate.now())) {
			consultaApoliceDto.setApoliceVencida(true);
			Long diasVencidos = Duration.between(apolice.getFimVigencia(), LocalDate.now()).toDays();
			consultaApoliceDto.setDiasVencidos(diasVencidos);
		} else {
			Long diasRestantes = Duration.between( LocalDate.now(),apolice.getFimVigencia()).toDays();
			consultaApoliceDto.setDiasRestantes(diasRestantes);
		}
		
		consultaApoliceDto.setPlacaVeiculo(apolice.getPlacaVeiculo());
		consultaApoliceDto.setValorApolice(apolice.getValorApolice());
		
	return consultaApoliceDto;
	}
	
	private void validaApolice (Apolice apolice) {
		if (apolice.getInicioVigencia().isAfter(apolice.getFimVigencia())) {
			throw new DataApoliceException("Data de início é maior que data de fim.");
		}
	}

}
