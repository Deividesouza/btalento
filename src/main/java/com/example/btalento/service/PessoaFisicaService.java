package com.example.btalento.service;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.model.Endereco;
import com.example.btalento.model.Pessoa;
import com.example.btalento.model.PessoaFisica;
import com.example.btalento.model.Cidade;
import com.example.btalento.repository.PessoaRepository;
import com.example.btalento.repository.PessoaFisicaRepository;
import com.example.btalento.repository.EnderecoRepository;
import com.example.btalento.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaFisicaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final EnderecoRepository enderecoRepository;
    private final CidadeRepository cidadeRepository;
    private final PessoaRepository pessoaRepository; // Injeção de dependência para Pessoa

    @Transactional
    public PessoaFisica criarPessoaFisica(PessoaFisicaDTO dto) {
        // Criando uma instância de Pessoa (classe base)
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setEmail(dto.getEmail());
        pessoa.setDataCadastro(new Date()); // Coloque o valor adequado para data
        pessoa.setDataValidade(dto.getDataValidade());
        pessoa.setPessoaStatus(dto.getPessoaStatus());

        // Salvando a Pessoa antes de associar à PessoaFisica
        pessoa = pessoaRepository.save(pessoa); // Salva a instância de Pessoa

        // Criando a instância de PessoaFisica (classe filha)
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf(dto.getCpf());
        pessoaFisica.setCelular(dto.getCelular());
        pessoaFisica.setLogin(dto.getLogin());
        pessoaFisica.setSenha(dto.getSenha());
        pessoaFisica.setPessoaFisicaTipo(dto.getPessoaFisicaTipo());
        pessoaFisica.setPerfilAcesso(dto.getPerfilAcesso());

        // Verificando se a cidade existe, caso contrário, criando uma nova
        Optional<Cidade> cidade = cidadeRepository.findByNomeAndUf_Sigla(dto.getCidadeNome(), dto.getCidadeUfSigla());
        if (!cidade.isPresent()) {
            Cidade novaCidade = new Cidade();
            novaCidade.setNome(dto.getCidadeNome());
            novaCidade.setUfSigla(dto.getCidadeUfSigla()); // Supondo que a sigla da UF seja um campo da cidade
            cidadeRepository.save(novaCidade);
            cidade = Optional.of(novaCidade); // Atualiza a referência da cidade com a nova cidade criada
        }

        // Criando o endereço
        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setCep(dto.getCep());
        endereco.setNumeroCasa(dto.getNumeroCasa());
        endereco.setCidade(cidade.get());
        enderecoRepository.save(endereco); // Salvando o endereço

        // Associando o endereço e a pessoaFisica à pessoaFisica
        pessoaFisica.setEndereco(endereco); // Associando o endereço à pessoaFisica
        pessoaFisica.setPessoa(pessoa); // A associação da classe filha com a classe pai

        // Salvando a PessoaFisica
        return pessoaFisicaRepository.save(pessoaFisica); // Salva a instância de PessoaFisica
    }

    public List<PessoaFisica> listarTodas() {
        return pessoaFisicaRepository.findAll();
    }

    public Optional<PessoaFisica> buscarPorId(Long id) {
        return pessoaFisicaRepository.findById(id);
    }
}
