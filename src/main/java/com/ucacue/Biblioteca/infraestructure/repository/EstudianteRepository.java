package com.ucacue.Biblioteca.infraestructure.repository;

import com.ucacue.Biblioteca.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
