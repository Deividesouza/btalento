package com.example.btalento.service;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.model.*;
import com.example.btalento.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaFisicaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final CidadeRepository cidadeRepository;
    private final UFRepository ufRepository;

    @Transactional
    public PessoaFisica criarPessoaFisica(PessoaFisicaDTO dto) {
        if (dto == null || dto.getEnderecoDTO() == null || dto.getEnderecoDTO().getCidade() == null ||
                dto.getEnderecoDTO().getCidade().getUf() == null || dto.getPessoaDTO() == null) {
            throw new IllegalArgumentException("Dados obrigatórios ausentes: Endereço, Cidade, UF ou PessoaDTO estão nulos.");
        }

        // Verifica se já existe uma Pessoa Física com o mesmo CPF
        pessoaFisicaRepository.findByCpf(dto.getCpf()).ifPresent(p -> {
            throw new RuntimeException("Já existe uma pessoa física cadastrada com este CPF.");
        });

        // Criando ou recuperando a UF
        UF uf = ufRepository.findBySigla(dto.getEnderecoDTO().getCidade().getUf().getSigla())
                .orElseGet(() -> {
                    UF novaUf = new UF();
                    novaUf.setSigla(dto.getEnderecoDTO().getCidade().getUf().getSigla());
                    novaUf.setNome(dto.getEnderecoDTO().getCidade().getUf().getNome());
                    return ufRepository.save(novaUf);
                });

        // Criando ou recuperando a Cidade associada à UF
        Cidade cidade = cidadeRepository.findByNomeAndUf(dto.getEnderecoDTO().getCidade().getNome(), uf)
                .orElseGet(() -> {
                    Cidade novaCidade = new Cidade();
                    novaCidade.setNome(dto.getEnderecoDTO().getCidade().getNome());
                    novaCidade.setUf(uf);
                    return cidadeRepository.save(novaCidade);
                });

        // Criando um novo Endereço
        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getEnderecoDTO().getLogradouro());
        endereco.setCep(dto.getEnderecoDTO().getCep());
        endereco.setNumeroCasa(dto.getEnderecoDTO().getNumeroCasa() != null ?
                Integer.parseInt(dto.getEnderecoDTO().getNumeroCasa()) : 0);
        endereco.setCidade(cidade);
        endereco = enderecoRepository.save(endereco);

        // Criando e salvando a Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getPessoaDTO().getNome());
        pessoa.setTelefone(dto.getPessoaDTO().getTelefone());
        pessoa.setEmail(dto.getPessoaDTO().getEmail());
        pessoa.setDataCadastro(new Date());
        pessoa.setDataValidade(LocalDate.from(dto.getPessoaDTO().getDataValidade()));
        pessoa.setPessoaStatus(PessoaStatus.(dto.getPessoaDTO().getPessoaStatus()));
        pessoa = pessoaRepository.save(pessoa);

        // Criando e salvando a Pessoa Física
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf(dto.getCpf());
        pessoaFisica.setCelular(dto.getCelular());
        pessoaFisica.setLogin(dto.getLogin());
        pessoaFisica.setSenha(dto.getSenha());
        pessoaFisica.setPessoaFisicaTipo(PessoaFisicaTipo.valueOf(dto.getPessoaFisicaTipo()));
        pessoaFisica.setPerfilAcesso(PerfilAcesso.valueOf(dto.getPerfilAcesso()));
        pessoaFisica.setEndereco(endereco);
        pessoaFisica.setPessoa(pessoa);

        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public List<PessoaFisica> listarTodas() {
        return pessoaFisicaRepository.findAll();
    }

    public Optional<PessoaFisica> buscarPorId(Long id) {
        return pessoaFisicaRepository.findById(id);
    }
}
