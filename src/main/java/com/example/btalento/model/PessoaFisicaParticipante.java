package com.example.btalento.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.aot.generate.GeneratedTypeReference;

import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaFisicaParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date dataPraca;

    private Date dataNasc;

    private Date dataBaixa;

    private String postgrad;

    private String ativaReserva;

    @ManyToOne
    @JoinColumn(name = "id_pessoa_fisica")
    private PessoaFIsica pessoaFIsica;

}
