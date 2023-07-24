package com.ucacue.Biblioteca.controller;

import com.ucacue.Biblioteca.infraestructure.repository.CabeceraRecervaRepository;
import com.ucacue.Biblioteca.infraestructure.service.CabeceraRecerbaService;
import com.ucacue.Biblioteca.model.CabeceraRecerva;
import com.ucacue.Biblioteca.model.DetalleReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class CabeceraRecervaController {

    @Autowired
    CabeceraRecervaRepository cabeceraRecervaRepository;

    @Autowired
    CabeceraRecerbaService cabeceraRecerbaService;

    @GetMapping("/recerbas")
    public List<CabeceraRecerva> getAllCabeceraRecerva(){
        List<CabeceraRecerva> cabeceraRecervas = cabeceraRecervaRepository.findAll();
        for(CabeceraRecerva cabeceraRecerva : cabeceraRecervas){
            for (DetalleReserva detalleReserva : cabeceraRecerva.getDetalleReserva()){
                detalleReserva.setDiasMoras();
            }
        }
        return cabeceraRecervaRepository.findAll();
    }

    @GetMapping("/recerbas/mora")
    public List<DetalleReserva> recerbasMora()
    {
        return cabeceraRecerbaService.recerbasMora();
    }
}
