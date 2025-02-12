package com.example.btalento.repository;

import com.example.btalento.model.PessoaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaStatusRepository extends JpaRepository<PessoaStatus, Long> {
    // Aqui você pode adicionar métodos customizados de consulta se necessário
}
