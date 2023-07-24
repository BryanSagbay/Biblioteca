package com.ucacue.Biblioteca.controller;

import com.ucacue.Biblioteca.infraestructure.repository.EstudianteRepository;
import com.ucacue.Biblioteca.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*/")

public class EstudianteController {

    @Autowired
    EstudianteRepository estudianteRepository;


    @GetMapping("/estudiantes")
    public List<Estudiante> getAllEstudiante(){
        return estudianteRepository.findAll();
    }
}
