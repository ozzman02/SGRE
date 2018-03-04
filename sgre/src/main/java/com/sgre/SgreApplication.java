package com.sgre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.sgre.riesgos.repositories", "com.sgre.eventos.repositories" })
@ComponentScan(basePackages = { "com.sgre.*"})
public class SgreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgreApplication.class, args);
	}
}
