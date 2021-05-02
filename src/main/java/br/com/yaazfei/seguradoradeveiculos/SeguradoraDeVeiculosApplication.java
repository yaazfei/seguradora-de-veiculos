package br.com.yaazfei.seguradoradeveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class SeguradoraDeVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguradoraDeVeiculosApplication.class, args);
	}
}
