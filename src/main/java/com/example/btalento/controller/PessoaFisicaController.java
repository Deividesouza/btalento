package com.example.btalento.controller;

import com.example.btalento.model.Pessoa;
import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public PessoaFisicaDTO criarPessoaFisica(@RequestBody PessoaFisicaDTO pessoaFisicaDTO) {
        PessoaFisica pessoaFisica = new PessoaFisica();

        // Popula os campos de PessoaFisica
        pessoaFisica.setCpf(pessoaFisicaDTO.getCpf());
        pessoaFisica.setCelular(pessoaFisicaDTO.getCelular());
        pessoaFisica.setLogin(pessoaFisicaDTO.getLogin());
        pessoaFisica.setSenha(pessoaFisicaDTO.getSenha());

        // Cria e popular o objeto Pessoa relacionado
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaFisicaDTO.getPessoaDTO().getNome());
        pessoa.setTelefone(pessoaFisicaDTO.getPessoaDTO().getTelefone());
        pessoa.setEmail(pessoaFisicaDTO.getPessoaDTO().getEmail());
        pessoa.setPessoaStatus(pessoa.getPessoaStatus());
        pessoaFisica.setPessoa(pessoa);

        pessoaFisicaService.criarPessoaFisica(pessoaFisica);

        return convertToDTO(pessoaFisica); // Retorna o DTO preenchido
    }

    private PessoaFisicaDTO convertToDTO(PessoaFisica pessoaFisica) {
        PessoaFisicaDTO pessoaFisicaDTO = new PessoaFisicaDTO();
        pessoaFisicaDTO.setId(pessoaFisica.getId());
        pessoaFisicaDTO.setCpf(pessoaFisica.getCpf());
        pessoaFisicaDTO.setCelular(pessoaFisica.getCelular());
        pessoaFisicaDTO.setLogin(pessoaFisica.getLogin());
        pessoaFisicaDTO.setSenha(pessoaFisica.getSenha());

        // Converte o objeto Pessoa associado
        PessoaFisicaDTO.PessoaDTO pessoaDTO = new PessoaFisicaDTO.PessoaDTO();
        pessoaDTO.setId(pessoaFisica.getPessoa().getId());
        pessoaDTO.setNome(pessoaFisica.getPessoa().getNome());
        pessoaDTO.setTelefone(pessoaFisica.getPessoa().getTelefone());
        pessoaDTO.setEmail(pessoaFisica.getPessoa().getEmail());
        pessoaDTO.setPessoaStatus(pessoaDTO.getPessoaStatus());

        pessoaFisicaDTO.setPessoaDTO(pessoaDTO);

        return pessoaFisicaDTO;
    }
}
