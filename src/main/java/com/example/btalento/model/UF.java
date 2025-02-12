package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "uf")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla; // Ex: SP, RJ, BA...
}
