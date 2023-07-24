package com.ucacue.Biblioteca.infraestructure.service;


import com.ucacue.Biblioteca.infraestructure.repository.CabeceraRecervaRepository;
import com.ucacue.Biblioteca.model.CabeceraRecerva;
import com.ucacue.Biblioteca.model.DetalleReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabeceraRecerbaService {

    @Autowired
    CabeceraRecervaRepository cabeceraRecervaRepository;

    public List<DetalleReserva> recerbasMora()
    {
        List<CabeceraRecerva> cabeceraRecervas = cabeceraRecervaRepository.findAll();
        List<DetalleReserva> detalleReservasMora = new ArrayList<>();
        for(CabeceraRecerva cabeceraRecerva : cabeceraRecervas){
            for (DetalleReserva detalleReserva : cabeceraRecerva.getDetalleReserva()){
                detalleReserva.setDiasMoras();
                if(detalleReserva.getDiasMoras()>0){
                    detalleReservasMora.add(detalleReserva);
                }
            }
        }
        return detalleReservasMora;
    }
}
