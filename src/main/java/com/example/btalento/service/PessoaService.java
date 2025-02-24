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

import java.util.List;
import java.util.Optional;

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

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public PessoaFisica salvarPessoaFisica(PessoaFisica pessoaFisica) {
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    // 🔹 Buscar todas as pessoas
    public List<Pessoa> listarTodasPessoas() {
        return pessoaRepository.findAll();
    }

    // 🔹 Buscar pessoa por ID
    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    // 🔹 Buscar todas as pessoas físicas
    public List<PessoaFisica> listarTodasPessoasFisicas() {
        return pessoaFisicaRepository.findAll();
    }

    // 🔹 Buscar pessoa física por ID
    public Optional<PessoaFisica> buscarPessoaFisicaPorId(Long id) {
        return pessoaFisicaRepository.findById(id);
    }

    @Transactional
    public void deletarPessoaFisicaPorId(Long id) {
        Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaRepository.findById(id);

        if (pessoaFisicaOptional.isPresent()) {
            PessoaFisica pessoaFisica = pessoaFisicaOptional.get();

            // Remover vínculo com a entidade Pessoa antes de excluir
            Pessoa pessoa = pessoaFisica.getPessoa();
            if (pessoa != null) {
                pessoaFisica.setPessoa(null);
                pessoaRepository.delete(pessoa);
            }

            // Excluir a pessoa física
            pessoaFisicaRepository.delete(pessoaFisica);
        } else {
            throw new RuntimeException("Pessoa Física com ID " + id + " não encontrada.");
        }
    }



}
