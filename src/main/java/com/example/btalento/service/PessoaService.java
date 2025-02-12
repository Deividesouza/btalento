package com.example.btalento.service;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.model.Endereco;
import com.example.btalento.model.Pessoa;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.repository.EnderecoRepository;
import com.example.btalento.repository.PessoaFisicaRepository;
import com.example.btalento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public PessoaFisica salvarPessoaComFisica(PessoaFisicaDTO dto) {
        // Primeiro, salvar o endereço
        Endereco endereco = enderecoRepository.save(dto.getPessoa().getEndereco());

        // Depois, salvar a pessoa associando o endereço
        Pessoa pessoa = dto.getPessoa();
        pessoa.setEndereco(endereco);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        // Por fim, salvar a pessoa física associando a pessoa
        PessoaFisica pessoaFisica = dto.getPessoaFisica();
        pessoaFisica.setPessoa(pessoaSalva);
        return pessoaFisicaRepository.save(pessoaFisica);
    }
}
