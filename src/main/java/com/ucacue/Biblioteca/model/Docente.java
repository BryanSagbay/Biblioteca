package com.ucacue.Biblioteca.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("docente")
public class Docente extends Persona {
    private String titulo;
}
