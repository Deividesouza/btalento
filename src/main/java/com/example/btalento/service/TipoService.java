package com.example.btalento.service;

import com.example.btalento.model.PerfilAcesso;
import com.example.btalento.model.PessoaFisicaTipo;
import com.example.btalento.model.PessoaStatus;
import com.example.btalento.repository.PerfilAcessoRepository;
import com.example.btalento.repository.PessoaFisicaTipoRepository;
import com.example.btalento.repository.PessoaStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    private PerfilAcessoRepository perfilAcessoRepository;

    @Autowired
    private PessoaFisicaTipoRepository pessoaFisicaTipoRepository;

    @Autowired
    private PessoaStatusRepository pessoaStatusRepository;

    // 🔹 Buscar todos os Perfis de Acesso
    public List<PerfilAcesso> listarPerfisAcesso() {
        return perfilAcessoRepository.findAll();
    }

    // 🔹 Buscar todos os Tipos de Pessoa Física
    public List<PessoaFisicaTipo> listarPessoaFisicaTipos() {
        return pessoaFisicaTipoRepository.findAll();
    }

    // 🔹 Buscar todos os Status de Pessoa
    public List<PessoaStatus> listarPessoaStatus() {
        return pessoaStatusRepository.findAll();
    }
}
