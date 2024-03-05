package com.booksparadise.comunidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ComunidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunidadeApplication.class, args);
	}

}
