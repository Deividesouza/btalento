package com.example.btalento.controller;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.dto.PessoaFisicaParticipanteDTO;
import com.example.btalento.model.Pessoa;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.model.PessoaFisicaParticipante;
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

    // ================ ENDPOINTS PARA PESSOA FÍSICA ================
    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaFisica> cadastrarPessoa(@RequestBody PessoaFisicaDTO dto) {
        PessoaFisica pessoaFisica = pessoaService.salvarPessoaComFisica(dto);
        return ResponseEntity.ok(pessoaFisica);
    }

    @GetMapping("/fisicas")
    public ResponseEntity<List<PessoaFisica>> listarTodasPessoasFisicas() {
        return ResponseEntity.ok(pessoaService.listarTodasPessoasFisicas());
    }

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

    // ================ ENDPOINTS PARA PESSOA FÍSICA PARTICIPANTE ================
    @PostMapping("/participantes/cadastrar")
    public ResponseEntity<PessoaFisicaParticipante> cadastrarParticipante(@RequestBody PessoaFisicaParticipanteDTO dto) {
        PessoaFisicaParticipante participante = pessoaService.salvarPessoaFisicaParticipante(dto);
        return ResponseEntity.ok(participante);
    }

    @GetMapping("/participantes/{id}")
    public ResponseEntity<PessoaFisicaParticipante> buscarParticipantePorId(@PathVariable Long id) {
        Optional<PessoaFisicaParticipante> participante = pessoaService.buscarPessoaFisicaParticipantePorId(id);
        return participante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ================ ENDPOINTS GENÉRICOS ================
    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodasPessoas() {
        return ResponseEntity.ok(pessoaService.listarTodasPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.buscarPessoaPorId(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}