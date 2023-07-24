package com.ucacue.Biblioteca.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "detalle_reserva")
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Libro libro;
    private Date fechaEntrega;

    @Transient
    private int diasMoras;

    @JsonBackReference
    @ManyToOne
    private CabeceraRecerva cabeceraRecerva;
    //private Multa multa;


    //generame un metodo que reciba una fecha y le sumo 5 dias
    public Date sumarDias(Date fecha, int dias){
        Date fechaSumada = new Date();
        fechaSumada.setDate(fecha.getDate()+dias);
        return fechaSumada;
    }

    public void setDiasMoras(){
        Date fechaActual = new Date();
        int dias = (int) ((fechaActual.getTime()-fechaEntrega.getTime())/86400000);
        this.diasMoras= dias;
    }

    public void setFechaEntrega(Date fechaEntrega) {

        this.fechaEntrega = sumarDias(fechaEntrega,30);

    }

    public int calcularMora(){
        //restar fechas

        if(fechaEntrega.before(new Date()))
        {
            return 0;
        }else {
            //calcular dias de mora con la fecha actual y la fecha de entrega
            int diasMora= fechaEntrega.getDay()-new Date().getDay();

            return diasMora;
        }
    }
}
