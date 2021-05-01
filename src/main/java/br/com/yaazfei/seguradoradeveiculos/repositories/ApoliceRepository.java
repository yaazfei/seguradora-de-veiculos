package br.com.yaazfei.seguradoradeveiculos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.yaazfei.seguradoradeveiculos.documents.Apolice;

public interface ApoliceRepository extends MongoRepository<Apolice, String> {

}
