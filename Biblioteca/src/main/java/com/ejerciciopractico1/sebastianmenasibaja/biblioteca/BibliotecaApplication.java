package com.ejerciciopractico1.sebastianmenasibaja.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain")
@EnableJpaRepositories("com.ejerciciopractico1.sebastianmenasibaja.biblioteca.repository")
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
