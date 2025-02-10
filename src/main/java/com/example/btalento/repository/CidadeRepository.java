package com.example.btalento.repository;

import com.example.btalento.model.Cidade;
import com.example.btalento.model.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findByNomeAndUf(String nome, UF uf);
}
