package com.example.btalento.service;


import com.example.btalento.model.UF;
import com.example.btalento.repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UFService {

    @Autowired
    private UFRepository ufRepository;

    public List<UF> listarUF() {
        return ufRepository.findAll();
    }
}
