package br.com.yaazfei.seguradoradeveiculos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yaazfei.seguradoradeveiculos.documents.Apolice;
import br.com.yaazfei.seguradoradeveiculos.responses.Resposta;
import br.com.yaazfei.seguradoradeveiculos.services.ApoliceService;

@RestController
@RequestMapping(path = "/seguradoradeveiculos/apolices")
public class ApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	@GetMapping
	public ResponseEntity<Resposta<List<Apolice>>> listarTodos(){
		return ResponseEntity.ok(new Resposta<List<Apolice>>(this.apoliceService.listarTodos()));
	}
	
	@GetMapping (path = "/{id}") //id dinamico
	public ResponseEntity<Resposta<Apolice>> listarPorId(@PathVariable (name = "id") String id){
		return ResponseEntity.ok(new Resposta<Apolice>(this.apoliceService.listarPorID(id)));
	}
	
	@PostMapping
	public ResponseEntity<Resposta<Apolice>> cadastrar(@Valid @RequestBody Apolice cliente, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Resposta<Apolice>(erros));
		}
		
		return ResponseEntity.ok(new Resposta<Apolice>(this.apoliceService.cadastrar(cliente)));
	}
	
	@PutMapping(path =  "/{id}")
	public ResponseEntity<Resposta <Apolice>> atualizar(@PathVariable(name = "id") String id,@Valid @RequestBody Apolice cliente, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Resposta<Apolice>(erros));
		}
		cliente.setNumApolice(id);
		return ResponseEntity.ok(new Resposta<Apolice>(this.apoliceService.atualizar(cliente)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Resposta<Integer>> remover(@PathVariable(name = "id") String id){
		this.apoliceService.remover(id);
		return ResponseEntity.ok(new Resposta<Integer>(1));
		
	}
}