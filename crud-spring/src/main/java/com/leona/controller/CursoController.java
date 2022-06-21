package com.leona.controller;

import java.util.List;

import com.leona.model.Curso;
import com.leona.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cursos")
@AllArgsConstructor
@CrossOrigin
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public List<Curso> list() {
		return cursoRepository.findAll();
	}

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Curso create(@RequestBody Curso curso) {
		// System.out.println(course.getName());
		return cursoRepository.save(curso);
		// return ResponseEntity.status(HttpStatus.CREATED)
		// .body(cursoRepository.save(curso));

	}
}
