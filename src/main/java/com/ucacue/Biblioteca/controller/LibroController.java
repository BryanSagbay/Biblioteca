package com.ucacue.Biblioteca.controller;

import com.ucacue.Biblioteca.infraestructure.repository.LibroRepository;
import com.ucacue.Biblioteca.model.Autor;
import com.ucacue.Biblioteca.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class LibroController {

    @Autowired
    LibroRepository libroRepository;

    // Lista los libros
    @GetMapping("/libros")
    public List<Libro> getAllAutor(){
        return libroRepository.findAll();
    }

    // Buscar libro por ID

    @GetMapping("/libros/nombre")
    public List<Libro> buscarLibrosPorNombre(@RequestParam String nombreLibro) {
        return libroRepository.findByNombreContainingIgnoreCase(nombreLibro);
    }
}
