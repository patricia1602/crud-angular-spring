package com.leona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leona.model.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long> {

}
