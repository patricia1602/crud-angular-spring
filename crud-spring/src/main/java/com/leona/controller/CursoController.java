package com.leona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leona.model.Cursos;
import com.leona.repository.CursosRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/cursos")
@AllArgsConstructor
public class CursosController {

	@Autowired
	private CursosRepository cursosRepository;

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public @ResponseBody List<Cursos> list() {
		return cursosRepository.findAll();

	}
}
