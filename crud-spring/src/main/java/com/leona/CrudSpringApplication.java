package com.leona;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.leona.model.Cursos;
import com.leona.repository.CursosRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);

	}

	@Bean
	CommandLineRunner initDataBase(CursosRepository cursosRepository) {
		return args -> {
			cursosRepository.deleteAll();

			Cursos cursos = new Cursos();
			cursos.setName("Angular com Spring");
			cursos.setCategory("front-end");

			cursosRepository.save(new Cursos());

		};
	}
}
