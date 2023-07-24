package com.ucacue.Biblioteca.infraestructure.repository;

import com.ucacue.Biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findByNombreContainingIgnoreCase(String nombre);

}
