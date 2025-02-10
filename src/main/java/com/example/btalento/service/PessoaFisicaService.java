package com.example.btalento.service;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    // Método para criar PessoaFisica
    public PessoaFisicaDTO criarPessoaFisica(PessoaFisica pessoaFisicaDTO) {
        // Lógica para criar PessoaFisica a partir do DTO
        // (Já discutido anteriormente)
        return new PessoaFisicaDTO();  // Apenas um retorno de exemplo
    }

    // Método para listar todas as PessoaFisica
    public List<PessoaFisica> listarTodas() {
        return pessoaFisicaRepository.findAll();
    }
}
