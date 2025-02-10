package com.example.btalento.controller;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.service.PessoaFisicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas-fisicas")
@RequiredArgsConstructor
public class PessoaFisicaController {

    private final PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public ResponseEntity<PessoaFisica> criarPessoaFisica(@RequestBody @Valid PessoaFisicaDTO dto) {
        PessoaFisica pessoaFisica = pessoaFisicaService.criarPessoaFisica(dto);
        return new ResponseEntity<>(pessoaFisica, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaFisica>> listarTodas() {
        List<PessoaFisica> pessoasFisicas = pessoaFisicaService.listarTodas();
        return new ResponseEntity<>(pessoasFisicas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisica> buscarPorId(@PathVariable Long id) {
        Optional<PessoaFisica> pessoaFisica = pessoaFisicaService.buscarPorId(id);
        return pessoaFisica.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
