package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "formacao_academica")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FormacaoAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String curso;
    private String instituicao;
    private Integer anoConclusao;

    @ManyToOne
    @JoinColumn(name = "pessoa_fisica_participante_id")
    private PessoaFisicaParticipante pessoaFisicaParticipante;
}