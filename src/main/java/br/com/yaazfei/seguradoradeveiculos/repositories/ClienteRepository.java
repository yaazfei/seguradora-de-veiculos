package br.com.yaazfei.seguradoradeveiculos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.yaazfei.seguradoradeveiculos.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {


}
