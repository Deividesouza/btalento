package com.example.btalento.repository;

import com.example.btalento.model.PessoaFisicaTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaFisicaTipoRepository extends JpaRepository<PessoaFisicaTipo, Long> {
    Optional<PessoaFisicaTipo> findBydescricao(String pessoaFisicaTipo);
}
