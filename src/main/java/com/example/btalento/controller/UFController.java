package com.example.btalento.controller;

import com.example.btalento.model.UF;
import com.example.btalento.service.UFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uf")
public class UFController {

    @Autowired
    private UFService ufService;

    @RequestMapping("/uf")
    public List<UF> listaruf() {
        return ufService.listarUF();
    }
}
