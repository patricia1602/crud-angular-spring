package com.leona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.leona.model.Curso;
import com.leona.repository.CursoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CursoService {

	private CursoRepository cursoRepository;

	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	public Optional<Curso> findById(Long id) {
		return cursoRepository.findById(id);
	}

	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}

	public Curso update(Curso curso) {
		return cursoRepository.save(curso);
	}

	public void delete(Long id) {
		cursoRepository.deleteById(id);
	}

	public List<Curso> findAllDesc() {
		return cursoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}
}
