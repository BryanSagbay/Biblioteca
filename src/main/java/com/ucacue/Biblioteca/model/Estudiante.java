package com.ucacue.Biblioteca.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("estudiante")
@Data
public class Estudiante extends Persona {

    private String carrera;
}
