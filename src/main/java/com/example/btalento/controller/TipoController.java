package com.example.btalento.controller;

import com.example.btalento.model.PerfilAcesso;
import com.example.btalento.model.PessoaFisicaTipo;
import com.example.btalento.model.PessoaStatus;
import com.example.btalento.repository.PerfilAcessoRepository;
import com.example.btalento.repository.PessoaFisicaRepository;
import com.example.btalento.repository.PessoaFisicaTipoRepository;
import com.example.btalento.repository.PessoaStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private PerfilAcessoRepository perfilAcessoRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaStatusRepository pessoaStatusRepository;

    @Autowired
    private PessoaFisicaTipoRepository pessoaFisicaTipoRepository;

    @GetMapping("/perfil")
    public ResponseEntity<List<PerfilAcesso>> listarPerfilAcessos() {
        return ResponseEntity.ok(perfilAcessoRepository.findAll());
    }

    @GetMapping("/pessoafisicatipos")
    public ResponseEntity<List<PessoaFisicaTipo>> listarPessoaFisicaTipos() {
        return ResponseEntity.ok(pessoaFisicaTipoRepository.findAll());
    }

    @GetMapping("/pessoastatus")
    public ResponseEntity<List<PessoaStatus>> listarPessoaStatus() {
        return ResponseEntity.ok(pessoaStatusRepository.findAll());
    }

}
