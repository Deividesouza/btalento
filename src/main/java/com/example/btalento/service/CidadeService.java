package com.example.btalento.service;


import com.example.btalento.model.Cidade;
import com.example.btalento.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> listarCidades() {
        return cidadeRepository.findAll();
    }

}
