package com.example.btalento.controller;


import com.example.btalento.model.Cidade;
import com.example.btalento.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping("/cidades")
    public List<Cidade> listarCidades() {
        return cidadeService.listarCidades();
    }

}
