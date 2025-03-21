package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experiencia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String cargo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pessoa_fisica_participante_id")
    private PessoaFisicaParticipante pessoaFisicaParticipante;
}