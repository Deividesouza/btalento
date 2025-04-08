package com.example.btalento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "participante_id")
    @JsonIgnore
    private PessoaFisicaParticipante pessoaFisicaParticipante;


}