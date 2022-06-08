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
	CommandLineRunner initDatabase(CursosRepository cursosRepository) {
		return (args) -> {
			cursosRepository.deleteAll();

			Cursos c = new Cursos();
			c.setName("Angular com Spring");
			c.setCategory("Front-End");
			
			Cursos c2 = new Cursos();
			c2.setName("Spring api");
			c2.setCategory("Back-End");
			
			cursosRepository.save(c);
			cursosRepository.save(c2);
		};
	}
}
