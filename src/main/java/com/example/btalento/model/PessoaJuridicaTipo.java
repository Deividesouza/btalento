package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa_juridica_tipo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaJuridicaTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
}
