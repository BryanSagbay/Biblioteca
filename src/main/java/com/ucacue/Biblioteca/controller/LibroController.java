package com.ucacue.Biblioteca.controller;

import com.ucacue.Biblioteca.infraestructure.repository.LibroRepository;
import com.ucacue.Biblioteca.model.Autor;
import com.ucacue.Biblioteca.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Guardar libro
    @PostMapping("/guardarLibro")
    @ResponseStatus(HttpStatus.CREATED)
    public Libro saveJugador(@RequestBody Libro jugador){
        return libroRepository.save(jugador);
    }

    // Actualizar libro
    @PutMapping("/actualizarlibro")
    @ResponseStatus(HttpStatus.CREATED)
    public Libro updateJugador(@RequestBody Libro jugador)
    {
        return libroRepository.save(jugador);
    }

    // Elminar libro por ID
    @DeleteMapping("/eliminarlibro/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJugador(@PathVariable int id)
    {
        libroRepository.deleteById(id);
    }

    // Buscar libro por ID
    @GetMapping("/libros/nombre")
    public List<Libro> buscarLibrosPorNombre(@RequestParam String nombreLibro) {
        return libroRepository.findByNombreContainingIgnoreCase(nombreLibro);
    }
}
