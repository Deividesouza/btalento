package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate anoConclusao;
    private LocalDate anoInicio;
    private String nivel;
    private String email;
    private String telefone;


}