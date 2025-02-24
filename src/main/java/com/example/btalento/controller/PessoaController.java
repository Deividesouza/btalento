package com.example.btalento.controller;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.model.Pessoa;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // Endpoint para cadastro de pessoa
    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaFisica> cadastrarPessoa(@RequestBody PessoaFisicaDTO dto) {
        PessoaFisica pessoaFisica = pessoaService.salvarPessoaComFisica(dto);
        return ResponseEntity.ok(pessoaFisica);
    }

    // Endpoint para listar todas as pessoas
    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodasPessoas() {
        return ResponseEntity.ok(pessoaService.listarTodasPessoas());
    }

    // Endpoint para buscar pessoa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.buscarPessoaPorId(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Endpoint para listar todas as pessoas físicas
    @GetMapping("/fisicas")
    public ResponseEntity<List<PessoaFisica>> listarTodasPessoasFisicas() {
        return ResponseEntity.ok(pessoaService.listarTodasPessoasFisicas());
    }

    // 🔹 Endpoint para buscar pessoa física por ID
    @GetMapping("/fisicas/{id}")
    public ResponseEntity<PessoaFisica> buscarPessoaFisicaPorId(@PathVariable Long id) {
        Optional<PessoaFisica> pessoaFisica = pessoaService.buscarPessoaFisicaPorId(id);
        return pessoaFisica.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/fisicas/deletar/{id}")
    public ResponseEntity<Void> deletarPessoaFisica(@PathVariable Long id) {
        pessoaService.deletarPessoaFisicaPorId(id);
        return ResponseEntity.noContent().build();
    }


}
