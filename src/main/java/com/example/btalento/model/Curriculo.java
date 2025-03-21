package com.example.btalento.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "curriculo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeArquivoHash;

    @OneToOne
    @JoinColumn(name = "pessoa_fisica_participante_id")
    private PessoaFisicaParticipante pessoaFisicaParticipante;
}