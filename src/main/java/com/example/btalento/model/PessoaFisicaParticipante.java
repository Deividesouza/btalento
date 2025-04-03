package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;


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

    @ManyToOne
    private PostoGraduacao postoGraduacao;

    @ManyToOne
    private AtivaReserva  ativaReserva;

    @OneToOne
    private PessoaFisica pessoaFisica;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<FormacaoAcademica> formacoesAcademicas;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Curriculo curriculo;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Experiencia> experiencia;

}