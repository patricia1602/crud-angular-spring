package com.leona.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leona.model.Curso;
import com.leona.model.ReturnError;
import com.leona.service.CursoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cursos")
@AllArgsConstructor
@CrossOrigin
public class CursoController {

	private CursoService cursoService;

	@GetMapping
	public ResponseEntity<Object> list() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cursoService.findAllDesc());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), "/api/cursos/GET"));
		}
	}

	@PostMapping
	@RequestMapping("create")
	public ResponseEntity<Object> create(@RequestBody @Valid Curso curso) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), "/api/cursos/create"));
		}

	}

	@PostMapping
	@RequestMapping("update")
	public ResponseEntity<Object> update(@RequestBody Curso curso) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cursoService.update(curso));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), "/api/cursos/update"));
		}

	}

	@PostMapping
	@RequestMapping("delete")
	public ResponseEntity<Object> delete(@RequestBody Long id) {
		try {
			cursoService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), "/api/cursos/delete"));
		}

	}
}