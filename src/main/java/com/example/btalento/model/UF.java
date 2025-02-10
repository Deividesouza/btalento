package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String nome;  // Nome da UF (Estado)
    private String sigla; // Sigla da UF (ex: SP, RJ, etc)
}
