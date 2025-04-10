package com.example.btalento.service;

import com.example.btalento.dto.PessoaFisicaDTO;
import com.example.btalento.dto.PessoaFisicaParticipanteDTO;
import com.example.btalento.model.*;
import com.example.btalento.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    // Repositórios
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AtivaReservaRepository  ativaReservaRepository;

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Autowired
    private FormacaoAcademicaRepository formacaoAcademicaRepository;

    @Autowired
    private PostoGraduacaoRepository postoGraduacaoRepository;
    @Autowired
    private PessoaFisicaParticipanteRepository pessoaFisicaParticipanteRepository;

    // ================ MÉTODOS PARA PESSOA FÍSICA ================
    @Transactional
    public PessoaFisica salvarPessoaComFisica(PessoaFisicaDTO dto) {
        Endereco endereco = enderecoRepository.save(dto.getPessoa().getEndereco());

        Pessoa pessoa = dto.getPessoa();
        pessoa.setEndereco(endereco);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        PessoaFisica pessoaFisica = dto.getPessoaFisica();
        pessoaFisica.setPessoa(pessoaSalva);
        return pessoaFisicaRepository.save(pessoaFisica);
    }
    @Transactional
    public void editarPessoaFisica(Long id, PessoaFisicaDTO dto) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa Física com ID " + id + " não encontrada."));

        // Atualiza os dados da pessoa associada
        Pessoa pessoa = pessoaFisica.getPessoa();
        pessoa.setNome(dto.getPessoa().getNome());

        // Salvar Endereço (se for novo ou atualizado)
        Endereco novoEndereco = dto.getPessoa().getEndereco();
        if (novoEndereco != null) {
            Endereco enderecoSalvo = enderecoRepository.save(novoEndereco);
            pessoa.setEndereco(enderecoSalvo);
        }

        pessoaRepository.save(pessoa); // Salvar a Pessoa com o Endereço atualizado

        // Atualiza os campos da Pessoa Física
        pessoaFisica.setCpf(dto.getPessoaFisica().getCpf());
        pessoaFisicaRepository.save(pessoaFisica);
    }



    // ================ MÉTODOS PARA PESSOA FÍSICA PARTICIPANTE ================
    @Transactional
    public PessoaFisicaParticipante salvarPessoaFisicaParticipante(PessoaFisicaParticipanteDTO dto) {
        // Salvar Endereço
        Endereco endereco = enderecoRepository.save(dto.getPessoa().getEndereco());

        // Salvar Pessoa
        Pessoa pessoa = dto.getPessoa();
        pessoa.setEndereco(endereco);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        // Buscar AtivaReserva do banco
        Long ativaReservaId = dto.getPessoaFisicaParticipante().getAtivaReserva().getId();
        AtivaReserva ativaReserva = ativaReservaRepository.findById(ativaReservaId)
                .orElseThrow(() -> new RuntimeException("AtivaReserva com ID " + ativaReservaId + " não encontrada."));

        // Buscar PostoGraduacao do banco
        Long postoGraduacaoId = dto.getPessoaFisicaParticipante().getPostoGraduacao().getId();
        PostoGraduacao postoGraduacao = postoGraduacaoRepository.findById(postoGraduacaoId)
                .orElseThrow(() -> new RuntimeException("PostoGraduacao com ID " + postoGraduacaoId + " não encontrado."));

        List<Experiencia> experienciasSalvas = null;
        if (dto.getPessoaFisicaParticipante().getExperiencia() != null) {
            dto.getPessoaFisicaParticipante().getExperiencia().forEach(exp -> exp.setEmail(pessoaSalva.getEmail()));
            experienciasSalvas = experienciaRepository.saveAll(dto.getPessoaFisicaParticipante().getExperiencia());
        }

        // Salvar Formações Acadêmicas e associar ao participante
        List<FormacaoAcademica> formacoesSalvas = null;
        if (dto.getPessoaFisicaParticipante().getFormacoesAcademicas() != null) {
            dto.getPessoaFisicaParticipante().getFormacoesAcademicas().forEach(f -> f.setEmail(pessoaSalva.getEmail()));
            formacoesSalvas = formacaoAcademicaRepository.saveAll(dto.getPessoaFisicaParticipante().getFormacoesAcademicas());
        }


        // Salvar PessoaFisica
        PessoaFisica pessoaFisica = dto.getPessoaFisica();
        pessoaFisica.setPessoa(pessoaSalva);
        PessoaFisica pessoaFisicaSalva = pessoaFisicaRepository.save(pessoaFisica);

        // Salvar PessoaFisicaParticipante
        PessoaFisicaParticipante participante = dto.getPessoaFisicaParticipante();
        participante.setPessoaFisica(pessoaFisicaSalva);
        participante.setAtivaReserva(ativaReserva);
        participante.setExperiencia(experienciasSalvas);
        participante.setFormacoesAcademicas(formacoesSalvas);
        return pessoaFisicaParticipanteRepository.save(participante);
    }

    @Transactional
    public void editarPessoaFisicaParticipante(Long id, PessoaFisicaParticipante dto) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa Física com ID " + id + " não encontrada."));

        // Atualiza os dados da pessoa associada
        Pessoa pessoa = pessoaFisica.getPessoa();
        pessoa.setNome(dto.getPessoaFisica().getPessoa().getNome());
        pessoa.setEmail(dto.getPessoaFisica().getPessoa().getEmail()); // caso use o email

        // Salvar Endereço (se for novo ou atualizado)
        Endereco novoEndereco = dto.getPessoaFisica().getPessoa().getEndereco();
        if (novoEndereco != null) {
            novoEndereco.setId(pessoa.getEndereco().getId()); // garante que atualiza em vez de criar novo
            Endereco enderecoSalvo = enderecoRepository.save(novoEndereco);
            pessoa.setEndereco(enderecoSalvo);
        }

        Pessoa pessoaSalva = pessoaRepository.save(pessoa); // Salvar Pessoa com Endereço atualizado

        // Atualiza os campos da Pessoa Física
        pessoaFisica.setCpf(dto.getPessoaFisica().getCpf());
        pessoaFisica.setPessoa(pessoaSalva);
        PessoaFisica pessoaFisicaSalva = pessoaFisicaRepository.save(pessoaFisica);

        // ====== Atualizar PessoaFisicaParticipante se existir ======
        Optional<PessoaFisicaParticipante> participanteOpt = pessoaFisicaParticipanteRepository.findById(pessoaFisicaSalva.getId());
        if (participanteOpt.isPresent()) {
            PessoaFisicaParticipante participante = participanteOpt.get();

            // Buscar AtivaReserva
            Long ativaReservaId = dto.getAtivaReserva().getId();
            AtivaReserva ativaReserva = ativaReservaRepository.findById(ativaReservaId)
                    .orElseThrow(() -> new RuntimeException("AtivaReserva com ID " + ativaReservaId + " não encontrada."));

            // Buscar PostoGraduacao
            Long postoGraduacaoId = dto.getPostoGraduacao().getId();
            PostoGraduacao postoGraduacao = postoGraduacaoRepository.findById(postoGraduacaoId)
                    .orElseThrow(() -> new RuntimeException("PostoGraduacao com ID " + postoGraduacaoId + " não encontrado."));

            // Atualizar Experiências
            List<Experiencia> experienciasSalvas = null;
            if (dto.getExperiencia() != null) {
                dto.getExperiencia().forEach(exp -> exp.setEmail(pessoaSalva.getEmail()));
                experienciasSalvas = experienciaRepository.saveAll(dto.getExperiencia());
            }

            // Atualizar Formações Acadêmicas
            List<FormacaoAcademica> formacoesSalvas = null;
            if (dto.getFormacoesAcademicas() != null) {
                dto.getFormacoesAcademicas().forEach(f -> f.setEmail(pessoaSalva.getEmail()));
                formacoesSalvas = formacaoAcademicaRepository.saveAll(dto.getFormacoesAcademicas());
            }

            // Atualiza o participante
            participante.setAtivaReserva(ativaReserva);
            participante.setPostoGraduacao(postoGraduacao);
            participante.setPessoaFisica(pessoaFisicaSalva);
            participante.setExperiencia(experienciasSalvas);
            participante.setFormacoesAcademicas(formacoesSalvas);

            pessoaFisicaParticipanteRepository.save(participante);
        }
    }


    public Optional<PessoaFisicaParticipante> buscarPessoaFisicaParticipantePorId(Long id) {
        return pessoaFisicaParticipanteRepository.findById(id);
    }

    public List<PessoaFisicaParticipante> listarTodosParticipantes(){
        return pessoaFisicaParticipanteRepository.findAll();
    }

    @Transactional
    public void deletarPessoaFisicaParticipantePorId(Long id) {
    PessoaFisicaParticipante participante = pessoaFisicaParticipanteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pessoa Física Participante com ID " + id + " não encontrada."));

    // Apaga experiências se existirem
    if (participante.getExperiencia() != null) {
        experienciaRepository.deleteAll(participante.getExperiencia());
    }

    // Apaga formações acadêmicas se existirem
    if (participante.getFormacoesAcademicas() != null) {
        formacaoAcademicaRepository.deleteAll(participante.getFormacoesAcademicas());
    }

    // Apaga participante
    pessoaFisicaParticipanteRepository.delete(participante);

    // Apaga PessoaFisica
    PessoaFisica pessoaFisica = participante.getPessoaFisica();
    if (pessoaFisica != null) {
        pessoaFisicaRepository.delete(pessoaFisica);
    }

    // Apaga Pessoa e Endereço
    if (pessoaFisica != null && pessoaFisica.getPessoa() != null) {
        Pessoa pessoa = pessoaFisica.getPessoa();
        Endereco endereco = pessoa.getEndereco();

        pessoaRepository.delete(pessoa);

        if (endereco != null) {
            enderecoRepository.delete(endereco);
        }
    }
}


    // ================ MÉTODOS GENÉRICOS ================
    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public PessoaFisica salvarPessoaFisica(PessoaFisica pessoaFisica) {
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public List<Pessoa> listarTodasPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<PessoaFisica> listarTodasPessoasFisicas() {
        return pessoaFisicaRepository.findAll();
    }

    public Optional<PessoaFisica> buscarPessoaFisicaPorId(Long id) {
        return pessoaFisicaRepository.findById(id);
    }

    @Transactional
    public void deletarPessoaFisicaPorId(Long id) {
        Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaRepository.findById(id);

        if (pessoaFisicaOptional.isPresent()) {
            PessoaFisica pessoaFisica = pessoaFisicaOptional.get();

            // Remove vínculo com Pessoa
            Pessoa pessoa = pessoaFisica.getPessoa();
            if (pessoa != null) {
                pessoaFisica.setPessoa(null);
                pessoaRepository.delete(pessoa);
            }

            pessoaFisicaRepository.delete(pessoaFisica);
        } else {
            throw new RuntimeException("Pessoa Física com ID " + id + " não encontrada.");
        }
    }
}