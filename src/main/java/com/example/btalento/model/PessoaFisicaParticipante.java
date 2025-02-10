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
public class PessoaFisicaParticipante extends PessoaFisica{

    private Date dataPraca;

    private Date dataNasc;

    private Date dataBaixa;

    private String postgrad;

    private String ativaReserva;

}
