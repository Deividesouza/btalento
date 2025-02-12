package com.example.btalento.controller;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaFisica> cadastrarPessoa(@RequestBody PessoaFisicaDTO dto) {
        PessoaFisica pessoaFisica = pessoaService.salvarPessoaComFisica(dto);
        return ResponseEntity.ok(pessoaFisica);
    }
}
