package com.ucacue.Biblioteca.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "cabecera_reserva")
public class CabeceraRecerva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Persona persona;
    private Date fechaReserva;

    @OneToMany(mappedBy = "cabeceraRecerva")
    private List<DetalleReserva> detalleReserva;
}
