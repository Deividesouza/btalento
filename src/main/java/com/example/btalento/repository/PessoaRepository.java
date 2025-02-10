package com.example.btalento.repository;

import com.example.btalento.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    // Aqui você pode adicionar métodos personalizados se necessário, por exemplo:
    // Optional<Pessoa> findByEmail(String email);
}
