package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private String cep;

    private String complemento;

    private int numeroCasa;

    @ManyToMany
    @JoinTable(
            name = "endereco_cidade",  // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "endereco_id"),  // Chave estrangeira para Endereco
            inverseJoinColumns = @JoinColumn(name = "cidade_id")  // Chave estrangeira para Cidade
    )
    private List<Cidade> cidades;
}
