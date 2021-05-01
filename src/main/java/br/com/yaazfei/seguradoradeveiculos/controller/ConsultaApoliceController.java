package br.com.yaazfei.seguradoradeveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yaazfei.seguradoradeveiculos.dto.ConsultaApoliceDto;
import br.com.yaazfei.seguradoradeveiculos.services.ApoliceService;

@RestController
@RequestMapping("/seguradoradeveiculos/apolices/valida")
public class ConsultaApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	@GetMapping ("/{id}") //id dinamico
	public ResponseEntity<ConsultaApoliceDto> buscarPorNumero(
			@PathVariable (name = "id") String id){
		return ResponseEntity.ok(this.apoliceService.consultaPorNumero(id));
	}


	
}
