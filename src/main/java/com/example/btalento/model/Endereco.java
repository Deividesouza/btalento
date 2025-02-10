package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "endereco")
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

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
