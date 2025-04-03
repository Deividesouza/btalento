package com.example.btalento.controller;

import com.example.btalento.model.PostoGraduacao;
import com.example.btalento.repository.PostoGraduacaoRepository;
import com.example.btalento.service.PostoGraduacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postograducacao")
public class PostoGraduacaoController {

    @Autowired
    private PostoGraduacaoRepository postoGraduacaoRepository;
    @RequestMapping("/postograducacao")
    public List<PostoGraduacao> PostoGraduacao(){
        return postoGraduacaoRepository.findAll();
    }

}
