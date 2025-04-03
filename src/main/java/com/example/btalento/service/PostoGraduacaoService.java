package com.example.btalento.service;

import com.example.btalento.model.PostoGraduacao;
import com.example.btalento.repository.PostoGraduacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostoGraduacaoService {

    @Autowired
    private PostoGraduacaoRepository postoGraduacaoRepository;

    public List<PostoGraduacao> listarpostograduacao(){
        return postoGraduacaoRepository.findAll();
    }

}
