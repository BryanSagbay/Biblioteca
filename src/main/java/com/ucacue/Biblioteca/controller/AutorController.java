package com.ucacue.Biblioteca.controller;


import com.ucacue.Biblioteca.infraestructure.repository.AutorRepository;
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
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @GetMapping("/autores")
    public List<Autor> getAllAutor(){
        return autorRepository.findAll();
    }

    @GetMapping("/autores/{id}")
    public List<Libro> getLibrosByAutor(@PathVariable int id){
        return autorRepository.findById(id).get().getLibros();
    }

    // Guardar libro
    @PostMapping("/guardarAutor")
    @ResponseStatus(HttpStatus.CREATED)
    public Autor saveAutor(@RequestBody Autor autores){
        return autorRepository.save(autores);
    }

    // Actualizar libro
    @PutMapping("/actualizarAutor")
    @ResponseStatus(HttpStatus.CREATED)
    public Autor updateAutor(@RequestBody Autor autores)
    {
        return autorRepository.save(autores);
    }

    // Elminar libro por ID
    @DeleteMapping("/eliminarAutor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutor(@PathVariable int id)
    {
        autorRepository.deleteById(id);
    }


}
