package com.example.btalento.repository;

import com.example.btalento.model.PerfilAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilAcessoRepository extends JpaRepository<PerfilAcesso, Long> {
    Optional<PerfilAcesso> findBydescricao(String perfilAcesso);
}
