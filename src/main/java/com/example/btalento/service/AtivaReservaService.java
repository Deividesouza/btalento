package com.example.btalento.service;

import com.example.btalento.model.AtivaReserva;
import com.example.btalento.repository.AtivaReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtivaReservaService {

    @Autowired
    private AtivaReservaRepository ativaReservaRepository;

    public List<AtivaReserva> listarativareserva(){
        return ativaReservaRepository.findAll();
    }
}
