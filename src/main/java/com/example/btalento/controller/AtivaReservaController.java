package com.example.btalento.controller;

import com.example.btalento.model.AtivaReserva;
import com.example.btalento.service.AtivaReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ativareserva")
public class AtivaReservaController {

    @Autowired
    private AtivaReservaService ativaReservaService;
    @RequestMapping("/ativareserva")
    public List<AtivaReserva> listarativareserva() {
    return ativaReservaService.listarativareserva();
    }
}
