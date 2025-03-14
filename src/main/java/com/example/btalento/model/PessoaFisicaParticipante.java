package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.time.LocalDate;

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

}
