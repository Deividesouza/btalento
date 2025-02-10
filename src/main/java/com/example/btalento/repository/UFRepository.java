package com.example.btalento.repository;

import com.example.btalento.model.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UFRepository extends JpaRepository<UF, Long> {
    Optional<UF> findBySigla(String sigla);
}
