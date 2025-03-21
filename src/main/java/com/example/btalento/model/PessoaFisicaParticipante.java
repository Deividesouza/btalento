package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pessoa_fisica_participante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaFisicaParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataPraca;
    private LocalDate dataNasc;
    private LocalDate dataBaixa;
    private String postgrad;
    private String ativaReserva;

    @OneToOne
    @JoinColumn(name = "pessoa_fisica_id")
    private PessoaFisica pessoaFisica;

    @OneToMany(mappedBy = "pessoaFisicaParticipante")
    private List<FormacaoAcademica> formacoesAcademicas;


    @OneToOne(mappedBy = "pessoaFisicaParticipante")
    private Curriculo curriculo;


    @OneToMany(mappedBy = "pessoaFisicaParticipante")
    private List<Experiencia> experiencias;

}