package br.com.yaazfei.seguradoradeveiculos.controller;

import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import br.com.yaazfei.seguradoradeveiculos.documents.Cliente;
import br.com.yaazfei.seguradoradeveiculos.responses.Resposta;
import br.com.yaazfei.seguradoradeveiculos.services.ClienteService;

@RestController
@RequestMapping("/seguradoradeveiculos/clientes")
public class ClienteController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	private ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public ResponseEntity<Resposta<List<Cliente>>> listarTodos(){
		return ResponseEntity.ok(new Resposta<List<Cliente>>(this.clienteService.listarTodos()));
	}
	
	@GetMapping ("/{id}") //id dinamico
	public ResponseEntity<Resposta<Cliente>> listarPorId(@PathVariable (name = "id") String id){
		return ResponseEntity.ok(new Resposta<Cliente>(this.clienteService.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<Resposta<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Resposta<Cliente>(erros));
		}
		return ResponseEntity.ok(new Resposta<Cliente>(this.clienteService.cadastrar(cliente)));
	}
	
	@PutMapping(path =  "/{id}")
	public ResponseEntity<Resposta <Cliente>> atualizar(@PathVariable(name = "id") String id,@Valid @RequestBody Cliente cliente, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Resposta<Cliente>(erros));
		}
		cliente.setId(id);
		return ResponseEntity.ok(new Resposta<Cliente>(this.clienteService.atualizar(cliente)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Resposta<Integer>> remover(@PathVariable(name = "id") String id){
		this.clienteService.remover(id);
		return ResponseEntity.ok(new Resposta<Integer>(1));	
	}
}
