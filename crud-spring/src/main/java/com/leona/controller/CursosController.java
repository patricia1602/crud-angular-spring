package com.leona.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leona.model.Cursos;
import com.leona.repository.CursosRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/cursos")
@AllArgsConstructor
public class CursosController {

	private CursosRepository cursosRepository;

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public List<Cursos> list() {
		return cursosRepository.findAll();

	}
}
