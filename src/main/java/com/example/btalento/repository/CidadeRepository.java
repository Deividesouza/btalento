package com.example.btalento.repository;

import com.example.btalento.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    // Buscar cidade pelo nome e pela UF associada
    Optional<Cidade> findByNomeAndUf_Sigla(String nome, String ufSigla);
}
